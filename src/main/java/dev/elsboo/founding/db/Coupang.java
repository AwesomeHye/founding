package dev.elsboo.founding.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table
@Getter
public class Coupang {

    @Id
    @GeneratedValue
    private Integer id;

    private String column;

}
