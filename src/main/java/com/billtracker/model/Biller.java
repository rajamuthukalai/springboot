package com.billtracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * Created by kgtl075 on 17/12/17.
 */
@Entity
public @Data class Biller {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="billerSeq")
    @SequenceGenerator(sequenceName="biller_seq", name = "billerSeq")
    private Long id;

    @NotNull
    @Column(unique=true)
    @Length(max = 20)
    private String name ;


}
