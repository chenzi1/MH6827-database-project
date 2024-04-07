package org.databaseproject.olap.service;

import org.databaseproject.olap.model.*;
import org.databaseproject.olap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtlService {

    @Autowired
    DateDimensionRepository dateDimensionRepository;

    @Autowired
    CardDimensionRepository cardDimensionRepository;

    @Autowired
    CustomerDimensionRepository customerDimensionRepository;

    @Autowired
    TransactionTypeDimensionRepository transactionTypeDimensionRepository;

    @Autowired
    TransactionFactRepository transactionFactRepository;

    public List<DateDimension> getDateDimensions() {
        return dateDimensionRepository.findAll();
    }

    public DateDimension saveDateDimension(DateDimension dateDimension) {
        return dateDimensionRepository.save(dateDimension);
    }

    public CardDimension saveCardDimension(CardDimension cardDimension) {
        return cardDimensionRepository.save(cardDimension);
    }

    public CustomerDimension saveCustomerDimension(CustomerDimension customerDimension) {
        return customerDimensionRepository.save(customerDimension);
    }

    public TransactionTypeDimension saveTransactionTypeDimension(TransactionTypeDimension transactionTypeDimension) {
        return transactionTypeDimensionRepository.save(transactionTypeDimension);
    }

    public TransactionFact saveTransactionFact(TransactionFact transactionFact) {
        return transactionFactRepository.save(transactionFact);
    }
}
