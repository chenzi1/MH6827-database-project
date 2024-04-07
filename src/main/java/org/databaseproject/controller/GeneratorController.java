package org.databaseproject.controller;

import org.databaseproject.oltp.service.CardService;
import org.databaseproject.oltp.service.CustomerService;
import org.databaseproject.oltp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/generate")
public class GeneratorController {

    String DELIMITER = ",";

    @Autowired
    CustomerService customerService;

    @Autowired
    CardService cardService;

    @Autowired
    TransactionService transactionService;

    @GetMapping("/payment")
    public void generatePayment() {
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        List<String> paymentList = new ArrayList<>();
        Map<String, Map<Date, BigDecimal>> transactionMap = transactionService.getPayments();
        transactionMap.forEach((cardNumber, monthAmountMap) -> {
            monthAmountMap.forEach((date, amount) -> {
                paymentList.add(UUID.randomUUID() + DELIMITER + cardService.getCard(cardNumber).get().getCustomerId() + DELIMITER + simpleDateFormat.format(date) + DELIMITER + simpleDateFormat.format(between(new GregorianCalendar(2021, Calendar.MARCH, 20).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 26).getTime())) + DELIMITER + amount);
            });
        });

        try {
            writeCSVToFile(paymentList, "output.csv"); // Write CSV content to file
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Generation completed");
    }

    public void writeCSVToFile(List<String> data, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String row : data) {
                System.out.println(row);
                writer.write(row + "\n");
            }
        }

        System.out.println("CSV file generated successfully at: " + filePath);
    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }
}
