package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.dto.Deal;
import com.example.test.exception.AlreadyClaimedException;
import com.example.test.exception.ProductNotFoundException;
import com.example.test.model.DealProduct;
import com.example.test.service.DealProductService;

@RestController
@RequestMapping("/deal")
public class SampleController {
	
	@Autowired
	DealProductService dealProductService;
	
	
	@PostMapping("/create")
	public ResponseEntity<String> createDeal(@RequestBody Deal deal) throws ProductNotFoundException {
		dealProductService.createDeal(deal);
		return ResponseEntity.ok().body("Deal Successfully Created");
	}
	
	@PostMapping("/update/{productId}/{price}")
	public ResponseEntity<String> updateDealByPrice(@PathVariable Long productId, @PathVariable double price) throws ProductNotFoundException {
		dealProductService.updateDealByPrice(productId, price);
		return ResponseEntity.ok().body("Deal Successfully Updated By Price");
	}
	
	@PostMapping("/claim/{productId}")
	public ResponseEntity<DealProduct> dealClaim(@PathVariable Long productId) throws ProductNotFoundException, AlreadyClaimedException {
		DealProduct dealProductClaimed = dealProductService.dealClaim(productId);
		return ResponseEntity.ok().body(dealProductClaimed);
	}
	
	@PostMapping("/closeDeal/{productId}")
	public ResponseEntity<String> closeDeal(@PathVariable Long productId) throws ProductNotFoundException{
		dealProductService.closeDeal(productId);
		return ResponseEntity.ok().body("Deal closed successfully");
	}
	
	
}
