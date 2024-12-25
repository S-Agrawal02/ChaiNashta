package com.example.ChaiNashta.controller;

import com.example.ChaiNashta.entity.Market;
import com.example.ChaiNashta.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/markets")
public class MarketController {
	@Autowired
	MarketService marketService;

	@GetMapping("/getByMarketId")
	public Optional<Market> getByMarketId(@RequestParam Integer marketId) {
		return marketService.findByMarketId(marketId);
	}

	@PutMapping("/saveMarket")
	public Market save(@RequestBody Market market) {
		return marketService.save(market);
	}

	@GetMapping("/getAllMarkets")
	public List<Market> getAllMenu() {
		return marketService.findAll();
	}

}
