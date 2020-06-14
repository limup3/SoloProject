package com.example.web.pl;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name="Language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String thisyear, lastyear, changess, pl, rating, changerating;

    @Builder
    public Language(String thisyear, String lastyear, String changess, String pl, String rating, String changerating) {
        this.thisyear = thisyear;
        this.lastyear = lastyear;
        this.changess = changess;
        this.pl = pl;
        this.rating = rating;
        this.changerating = changerating;
    }

}
