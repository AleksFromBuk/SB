package com.example.analyticsdata;

import org.springframework.data.repository.CrudRepository;

public interface TransactionPricesRepository extends
        CrudRepository<TransactionPrices, Long> {
}
