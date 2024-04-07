package org.databaseproject.oltp.service;

import org.databaseproject.oltp.model.Card;
import org.databaseproject.oltp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Optional<Card> getCard(String id) {
        return cardRepository.findById(id);
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
