package com.example.web.pl;

import com.example.web.proxy.Box;
import com.example.web.proxy.Crawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class LanguageController {
    @Autowired Crawler crawler;
    @Autowired Box<Object> box;
    @Autowired LanguageRepository languageRepository;

    @GetMapping("/pl/{searchWord}")
    public HashMap<String,Object> pl(@PathVariable String searchWord){
        System.out.println("넘어온 키워드 : " +searchWord);
        box.clear();
        if(languageRepository.count() == 0) crawler.pl();
        List<Language> list = languageRepository.findAll();
        box.put("list",list);
        box.put("count",list.size());
        return box.get();


    }
}
