package com.dhagakart.service;

import java.util.List;

import com.dhagakart.models.CommodityPriceAddRequest;
import com.dhagakart.models.CommodityPriceAddResponse;
import com.dhagakart.models.PriceResponse;

public interface ICommodityService {

	public CommodityPriceAddResponse addCommodityPrice(CommodityPriceAddRequest commodity);

	public List<PriceResponse> getCommodityPrice(String variant);

}
