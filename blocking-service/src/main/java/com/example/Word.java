package com.example;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data
public class Word {

    @Id
    private Long id;

    private String text;

    @Transient
    private String data;

}
