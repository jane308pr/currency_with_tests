package com.example.curency.model;


/*
import lombok.Getter;
import lombok.Setter;
*/
import javax.persistence.*;

@Entity
@Table(name = "currency")
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

        public Integer getId() {
                        return id;
                    }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }


}
