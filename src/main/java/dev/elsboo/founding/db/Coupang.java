package dev.elsboo.founding.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coupang")
@Getter
@NoArgsConstructor
public class Coupang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String memo;

    @Builder
    public Coupang(String memo) {
        this.memo = memo;
    }
}
