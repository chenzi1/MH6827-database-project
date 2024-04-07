package org.databaseproject.controller;

import org.databaseproject.olap.model.*;
import org.databaseproject.olap.repository.TransactionFactRepository;
import org.databaseproject.olap.repository.TransactionTypeDimensionRepository;
import org.databaseproject.olap.service.EtlService;
import org.databaseproject.oltp.model.Card;
import org.databaseproject.oltp.model.Customer;
import org.databaseproject.oltp.model.Transaction;
import org.databaseproject.oltp.service.CardService;
import org.databaseproject.oltp.service.CustomerService;
import org.databaseproject.oltp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.util.Map.entry;

@RestController
@RequestMapping("/etl")
public class EtlController {

    @Autowired
    EtlService etlService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CardService cardService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionTypeDimensionRepository transactionTypeDimensionRepository;

    Map<Integer, Integer> quarterMap = Map.ofEntries(
            entry(0, 1),
            entry(1, 1),
            entry(2, 1),
            entry(3, 2),
            entry(4, 2),
            entry(5, 2),
            entry(6, 3),
            entry(7, 3),
            entry(8, 3),
            entry(9, 4),
            entry(10, 4),
            entry(11, 4)
    );

    @GetMapping("date")
    public DateDimension saveDate() {
        DateDimension dateDimension = new DateDimension();
        dateDimension.setDate_key(1);
        dateDimension.setHour(1);
        dateDimension.setDay(1);
        dateDimension.setDate(new Date());
        dateDimension.setMonth(1);
        dateDimension.setQuarter(1);
        dateDimension.setYear(1);
        dateDimension.setPeakHour(true);
        dateDimension.setDayOfWeek(1);

        return etlService.saveDateDimension(dateDimension);
    }

    @GetMapping("/loadTxnTypes")
    public String saveTransactionTypes() {
        String[] arr = {"Purchase","Payment","Cash Advance","Balance Transfer","Refund","Foreign Transaction","Late Payment","Over-limit"};
        for (int i = 0; i < arr.length; i++) {
            TransactionTypeDimension transactionTypeDimension = new TransactionTypeDimension();
            transactionTypeDimension.setType_id(i);
            transactionTypeDimension.setTypeName(arr[i]);
            etlService.saveTransactionTypeDimension(transactionTypeDimension);
        }
        return "All txn types loaded";
    }

    @GetMapping("/loadDates")
    public String saveDateDimensions() {

        Random random = new Random();

        int counter = 1;
        Calendar calendar = Calendar.getInstance();
        for (long l = 1616198400000L; l <= 1711411200000L; l+=86400000 ) {
            Date date = new Date();
            date.setTime(l);
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DATE);
            int year = calendar.get(Calendar.YEAR);


            DateDimension dateDimension = new DateDimension();
            dateDimension.setDate_key(counter);
            dateDimension.setHour(0);
            dateDimension.setDay(day);
            dateDimension.setDate(date);
            dateDimension.setMonth(month);
            dateDimension.setQuarter(quarterMap.get(month));
            dateDimension.setYear(year);
            dateDimension.setPeakHour(random.nextBoolean());
            dateDimension.setDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
            etlService.saveDateDimension(dateDimension);
            counter++;
        }
        return "All dates loaded";
    }

    @GetMapping("/loadCustomerDimension")
    public String saveCustomerDimension() {
        List<Customer> customerList = customerService.getAllCustomers();
        Random random = new Random();

        customerList.forEach(customer -> {
            CustomerDimension customerDimension = new CustomerDimension();
            customerDimension.setCustomer_id(customer.getCustomerId());
            customerDimension.setFirstName(customer.getFirstName());
            customerDimension.setLastName(customer.getLastName());
            customerDimension.setEmail(customer.getEmail());
            customerDimension.setPhoneNumber(customer.getPhoneNumber());
            customerDimension.setAddress(customer.getAddress());
            customerDimension.setAge(customer.getAge());
            customerDimension.setAgeGroup(customer.getAgeGroup());
            customerDimension.setEducation(customer.getEducation());
            customerDimension.setIncome(customer.getIncome());
            customerDimension.setIncomeRange(customer.getIncomeRange());
            customerDimension.setCreditRating(customer.getCreditRating());
            customerDimension.setRiskGrade(customer.getRiskGrade());
            customerDimension.setChurned(random.nextBoolean());

            etlService.saveCustomerDimension(customerDimension);
        });

        return "All customers loaded";
    }

    @GetMapping("/loadCardDimension")
    public String saveCardDimension() {
        List<Card> cardList = cardService.getAllCards();

        cardList.forEach(card -> {
            CardDimension cardDimension = new CardDimension();
            cardDimension.setCardNumber(card.getCardNumber());
            cardDimension.setCreditLimit(card.getCreditLimit());
            cardDimension.setCardType(card.getCardType());
            cardDimension.setInterestRate(card.getInterestRate());
            cardDimension.setIssueDate(card.getIssueDate());
            cardDimension.setExpirationDate(card.getExpirationDate());
            cardDimension.setCancellationDate(card.getCancellationDate());
            cardDimension.setStatus(card.getStatus());
            cardDimension.setCustomerId(card.getCustomerId());

            etlService.saveCardDimension(cardDimension);
        });

        return "All cards loaded";
    }

    @GetMapping("/loadTransactions")
    public String saveTransactions() {
        List<Transaction> transactionList = transactionService.findAll();

        transactionList.forEach(transaction -> {
            TransactionFact transactionFact = new TransactionFact();
            transactionFact.setTransactionId(transaction.getTransactionId());
            transactionFact.setCardNumber(transaction.getCardNumber());
            transactionFact.setMerchantName(transaction.getMerchantName());
            transactionFact.setTransactionDate(transaction.getTransactionDate());
            transactionFact.setAmount(transaction.getAmount());
            transactionFact.setCurrency(transaction.getCurrency());
            transactionFact.setTypeId(transactionTypeDimensionRepository.findByTypeNameEqualsIgnoreCase(transaction.getType()).get(0).getType_id());
            transactionFact.setStatus(transaction.getStatus());

            etlService.saveTransactionFact(transactionFact);
        });

        return "All transactions loaded";
    }
}
