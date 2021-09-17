package com.mea.ex.cs.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String comment;
}
