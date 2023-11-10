package com.example;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
@Data
public class Word {

    @Id
    private Long id;

    private String text;

    @Transient
    private String computedData;

}
