package com.anupama.ks.consumer.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anupama.ks.consumer.service.FileHandler;

@RestController
public class DataHandler {
	
    @RequestMapping(value = "/data/consumer", method = RequestMethod.GET,
    produces = MediaType.ALL_VALUE)
	public String consumeData(@RequestParam(value = "data", required = true) String dataPoint) {
    	FileHandler handler = new FileHandler();
    	handler.writeData(dataPoint);
		return "Data written successfully";
	}
    
    @RequestMapping(value = "/data/producer", method = RequestMethod.POST,
    produces = MediaType.ALL_VALUE)
	public String produceData() {
    	FileHandler handler = new FileHandler();
    	String data = handler.readData();
		return data;
	}

}
