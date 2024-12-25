package com.example.ChaiNashta.repository;

import com.example.ChaiNashta.entity.Market;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MarketRepository extends MongoRepository<Market,Integer> {
	Optional<Market> findByMarketId(Integer marketId);

}
