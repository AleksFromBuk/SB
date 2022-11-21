package com.example.analyticsdata;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import javax.annotation.PostConstruct;
import java.time.*;
import java.util.Date;
import java.util.HashMap;

@Component
public class LoadHistoryTransaction {
    @NonNull
    private final TransactionPricesRepository repository;
    private WebClient client;
    private final HashMap<Long, String> forPairsName = new HashMap<>();

    public LoadHistoryTransaction(TransactionPricesRepository repository) {
        this.repository = repository;
        this.forPairsName.put(1L, "RUBUSD");
        this.forPairsName.put(2L, "USDJPY");
        this.forPairsName.put(3L, "EURUSD");
    }

    @PostConstruct
    private void pollTransactions() {
        LocalDateTime now = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
        String startToDay  = now.toString() + ":00Z";
        String to = Instant.now().toString();


        for (Long it : forPairsName.keySet()) {
            client = WebClient.create("http://localhost:8081/historytransactions"
                    +"?pair_Name="
                    + forPairsName.get(it)
                    + "&date_From="
                    + startToDay
                    + "&date_To="
                    + to
            );

            client.get()
                    .retrieve()
                    .bodyToFlux(DataStructureFromHistory.class)
                    .toStream()
                    .forEach(dataStructureFromHistory -> {
                        repository.save(new TransactionPrices(
                                dataStructureFromHistory.getIdPk()
                                , forPairsName.get(it)
                                , dataStructureFromHistory.getValue()
                                , dataStructureFromHistory.getTimeStamp()
                        ));
                    });
        }
    }
}