package com.billtracker.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kgtl075 on 17/12/17.
 */
@Entity
public @Data class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="billSeq")
    @SequenceGenerator(sequenceName="bill_seq", name = "billSeq")
    private Long id;


    @ManyToOne
    private Account account;


    private String billNumber;


    private Double billAmount;


    private Date  dueDate;
}
