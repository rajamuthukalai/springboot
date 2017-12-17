package com.billtracker.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by kgtl075 on 17/12/17.
 */
@Entity
public @Data class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String accountNumber;


    private int mobile;


    @OneToOne
    private Biller biller;


    @ManyToOne
    private Category category;


    private String accountType;




}
