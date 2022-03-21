package com.example.curency.model;


/*
import lombok.Getter;
import lombok.Setter;
*/
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "currency")
@Builder
@Data
public class Currency {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "name")
        private String name;

        @Column(name = "code")
        private String code;

        @Column(name = "symbol")
        private String symbol;

}
