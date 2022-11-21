package com.example.analyticsdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataStructureFromHistory {

    @Id
    @GeneratedValue
    private Long idPk;

    private Long idFk;
    private double value;
    private String timeStamp;
}
