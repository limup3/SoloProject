package com.example.web.proxy;

import org.apache.ibatis.annotations.Lang;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.example.web.pl.Language;
import com.example.web.pl.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("crawler")
public class Crawler extends Proxy {

    @Autowired Inventory<Language> inventory;
    @Autowired Box<String> box;
    @Autowired LanguageRepository languageRepository;

    public void pl(){
        inventory.clear();
        try{
            String url = "https://www.tiobe.com/tiobe-index/";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements thisyear = d.select("table#top20>tbody>tr>td:nth-child(1)");
            Elements lastyear = d.select("table#top20>tbody>tr>td:nth-child(2)");
            Elements changes = d.select("table#top20>tbody>tr>td:nth-child(3)");
            Elements pl = d.select("table#top20>tbody>tr>td:nth-child(4)");
            Elements ratings = d.select("table#top20>tbody>tr>td:nth-child(5)");
            Elements changeratings = d.select("table#top20>tbody>tr>td:nth-child(6)");
            Language language = null;
            System.out.println("changes값:"+changes);

            for(int i =0 ; i< thisyear.size(); i++){
                language = new Language();
                language.setThisyear(thisyear.get(i).text());
                language.setLastyear(lastyear.get(i).text());
                if(changes.get(i).select("img").attr("src") == ""){
                    language.setChangess(changes.get(i).select("img").attr("src"));
                }else
                {
                    language.setChangess("https://www.tiobe.com"+changes.get(i).select("img").attr("src"));
                }
                language.setPl(pl.get(i).text());
                language.setRating(ratings.get(i).text());
                language.setChangerating(changeratings.get(i).text());
                languageRepository.save(language);
            }

        }catch (Exception e){
            print("에러발생");
        }

    }
}
