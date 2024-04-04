package org.databaseproject.service;

import org.databaseproject.model.Card;
import org.databaseproject.model.Customer;
import org.databaseproject.repository.CardRepository;
import org.databaseproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Optional<Card> getCard(String id) {
        return cardRepository.findById(id);
    }
}
