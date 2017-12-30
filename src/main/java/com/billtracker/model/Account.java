package com.billtracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by kgtl075 on 17/12/17.
 */
@Entity
public @Data class Account {

    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="accountSeq")
    @SequenceGenerator(sequenceName="account_seq", name = "accountSeq")    
    private Long Id;

    @NotNull
    @Column(unique=true)
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
