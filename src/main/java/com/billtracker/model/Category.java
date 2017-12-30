package com.billtracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Created by kgtl075 on 17/12/17.
 */
@Entity
public @Data class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="categorySeq")
    @SequenceGenerator(sequenceName="category_seq", name = "categorySeq")
    private Long id;

    @NotNull
    @Column(unique=true)
    @Size(max = 20)
    private String name;

}
