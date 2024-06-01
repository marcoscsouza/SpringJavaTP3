package com.marcoscsouza.TP3.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_SUPPLIER")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String company;
    private String email;


}
