package com.anupama.ks.consumer.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anupama.ks.consumer.service.FileHandler;


@RestController
public class ConsumerImpl {

	@RequestMapping(value = "/data/consumer", method = RequestMethod.GET,
			produces = MediaType.ALL_VALUE)
	public String consumeData(@RequestParam(value = "data", required = true) String dataPoint,
			@RequestParam(value = "mac", required = true) String macAddress) {
		String data = "Fail to write data";
		FileHandler handler = new FileHandler();
		if(handler.isAuthentic(macAddress)) {
			handler.writeData(dataPoint);
			data= "Data written successfully";
		}
		System.out.println(data);
		return data;
	}



}