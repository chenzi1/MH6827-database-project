package org.databaseproject.service;

import org.databaseproject.model.Transaction;
import org.databaseproject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Map<String, Map<Date, BigDecimal>> getPayments() {
        Calendar calendar = Calendar.getInstance();
        Map<String, Map<Date, BigDecimal>> paymentMap = new HashMap<>();
        List<Transaction> transactionList = transactionRepository.findAll();
        transactionList.forEach(transaction -> {
            calendar.setTime(transaction.getTransactionDate());
            calendar.set(Calendar.DATE, 1);
            paymentMap.put(transaction.getCardNumber(), paymentMap.get(transaction.getCardNumber()) != null? addAmount(paymentMap.get(transaction.getCardNumber()), calendar.getTime(), transaction.getAmount()) : addAmount(new HashMap<>(), calendar.getTime(), transaction.getAmount()));
        });

        return paymentMap;
    }

    public Map<Date, BigDecimal> addAmount(Map<Date, BigDecimal> amountMap, Date date, BigDecimal amount) {
        if (amountMap.containsKey(date)) {
            amountMap.put(date, amountMap.get(date).add(amount));
        } else {
            amountMap.put(date, amount);
        }
        return amountMap;
    }
}
