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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionPrices {
    @Id
    @GeneratedValue
    private Long id;

    private String currencyPairName;
    private double value;
    private String timeStamp;
}



