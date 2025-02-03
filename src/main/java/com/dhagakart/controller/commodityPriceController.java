package com.dhagakart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhagakart.models.CommodityPriceAddRequest;
import com.dhagakart.models.CommodityPriceAddResponse;
import com.dhagakart.models.PriceRequest;
import com.dhagakart.models.PriceResponse;
import com.dhagakart.service.ICommodityService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/api/today")
@RestController
@AllArgsConstructor
public class commodityPriceController {

	private ICommodityService commodityService;

	@PostMapping("/price")
	public ResponseEntity<List<PriceResponse>> fetchCommodityPrice(@Valid @RequestBody PriceRequest priceRequest) {

		List<PriceResponse> priceResponse = commodityService.getCommodityPrice(priceRequest.getVariant());

		return new ResponseEntity<>(priceResponse, HttpStatus.CREATED);

	}

	@PostMapping("/addPrice")
	public ResponseEntity<CommodityPriceAddResponse> addCommodityPrice(
			@Valid @RequestBody CommodityPriceAddRequest priceAddRequest) {

		CommodityPriceAddResponse priceAddResponse = commodityService.addCommodityPrice(priceAddRequest);

		return new ResponseEntity<>(priceAddResponse, HttpStatus.OK);

	}

}
