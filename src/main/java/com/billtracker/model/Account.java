package com.billtracker.model;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * Created by kgtl075 on 17/12/17.
 */
@Entity
public @Data class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotNull
    private String accountNumber;


    @OneToOne
    @NotNull
    private Biller biller;


    @ManyToOne
    @NotNull
    private Category category;


    private String accountType;

    @NotNull
    //@Size(max = 11)
    private Long mobile;

}
