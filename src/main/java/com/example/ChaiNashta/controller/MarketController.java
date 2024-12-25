package com.example.ChaiNashta.controller;

import com.example.ChaiNashta.entity.Market;
import com.example.ChaiNashta.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
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
		if(market.getMarketId() == null)
			market.setMarketId(marketService.findAll().size()+1);
		return marketService.save(market);
	}

	@GetMapping("/getAllMarkets")
	public List<Market> getAllMenu() {
		return marketService.findAll();
	}

}
