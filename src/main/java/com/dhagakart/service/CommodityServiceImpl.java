package com.dhagakart.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dhagakart.entity.Commodity;
import com.dhagakart.exception.CommodityNotFoundException;
import com.dhagakart.models.CommodityPriceAddRequest;
import com.dhagakart.models.CommodityPriceAddResponse;
import com.dhagakart.models.PriceResponse;
import com.dhagakart.repo.CommodityRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommodityServiceImpl implements ICommodityService {

	private CommodityRepo commodityRepo;

	@Override
	public CommodityPriceAddResponse addCommodityPrice(CommodityPriceAddRequest commodity) {

		Commodity commodityy = new Commodity(commodity.getVariant(), commodity.getTodayPrice(),
				commodity.getMaximumPrice(), commodity.getMinimumPrice(), commodity.getAvgPrice(), LocalDate.now());

		commodityRepo.save(commodityy);

		return new CommodityPriceAddResponse(200, "Added successfully");
	}

	@Override
	public List<PriceResponse> getCommodityPrice(String variant) {
		List<Commodity> commodities = commodityRepo.findByVariant(variant);
		if (commodities.isEmpty()) {
			throw new CommodityNotFoundException("Given Commodity is not there");
		}

		return commodities.stream().map(commodity -> new PriceResponse(commodity.getTodayPrice(),
				commodity.getMaximumPrice(), commodity.getMinimumPrice(), commodity.getAvgPrice()))
				.collect(Collectors.toList());
	}

}
