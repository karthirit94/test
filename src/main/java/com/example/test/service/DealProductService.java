package com.example.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dto.Deal;
import com.example.test.exception.AlreadyClaimedException;
import com.example.test.exception.ProductNotFoundException;
import com.example.test.model.DealProduct;
import com.example.test.model.Product;
import com.example.test.repository.DealProductRepository;
import com.example.test.repository.ProductRepositiory;

@Service
public class DealProductService {

	@Autowired
	ProductRepositiory productRepositiory;
	
	@Autowired
	DealProductRepository dealProductRepositiory;
	
	public void createDeal(Deal deal) throws ProductNotFoundException {
		
		Product product = productRepositiory.getById(deal.getId());
		if(product == null) {
			throw new ProductNotFoundException();
		}else {
			DealProduct dealProduct = dealProductRepositiory.getById(deal.getId());
//			DealProduct dealProduct = new DealProduct();
//			dealProduct.setId(deal.getId());
			dealProduct.setDealPrice(deal.getUpdatedPrice());
			dealProduct.setQuantity(deal.getUpdatedQuantity());
			dealProductRepositiory.save(dealProduct);
		}
	}

	public void updateDealByPrice(Long productId, double price) throws ProductNotFoundException {
		DealProduct dealProduct = dealProductRepositiory.getById(productId);
//		dealProduct.getIsDealPresent();
		
		if(dealProduct == null) {
			throw new ProductNotFoundException();
		}else {
			dealProduct.setDealPrice(price);
			dealProductRepositiory.save(dealProduct);
		}
	}
	
	public DealProduct dealClaim(Long productId) throws ProductNotFoundException, AlreadyClaimedException {
		
		DealProduct dealProduct = dealProductRepositiory.getById(productId);
		if(dealProduct == null) {
			throw new ProductNotFoundException();
		}else {
			if(dealProduct.getCustomerBought() == dealProduct.getQuantity()) {
				throw new AlreadyClaimedException();
			}else {
				dealProduct.setCustomerBought(dealProduct.getCustomerBought() + 1);
				dealProductRepositiory.save(dealProduct);
			}
		}
		
		return dealProduct;
	}
	
	public void closeDeal(Long productId) throws ProductNotFoundException {
		DealProduct dealProduct = dealProductRepositiory.getById(productId);
		if(dealProduct == null) {
			throw new ProductNotFoundException();
		}else {
			dealProduct.setDealPresent(false);
			dealProductRepositiory.save(dealProduct);
		}
	}
}
