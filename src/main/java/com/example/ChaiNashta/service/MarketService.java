package com.example.ChaiNashta.service;

import com.example.ChaiNashta.entity.Market;
import com.example.ChaiNashta.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MarketService {
    @Autowired
    private MarketRepository marketRepository;

    public Market save(Market market) {
        return marketRepository.save(market);
    }

    public Optional<Market> findByMarketId(Integer marketId) {
        return marketRepository.findByMarketId(marketId);
    }

    public List<Market> findAll() {
        return marketRepository.findAll();
    }

}
