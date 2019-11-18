package com.anupama.ks.producer.controller;

import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anupama.ks.producer.util.FileHandler;
import com.anupama.ks.producer.util.IKafkaConstants;
import com.anupama.ks.producer.util.ProducerCreator;


@RestController
public class ProducerImpl {
	

	@RequestMapping(value = "/data/producer", method = RequestMethod.GET,
			produces = MediaType.ALL_VALUE)
	public String produceFileData(@RequestParam(value = "data", required = true) String dataPoint,
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
	
	@RequestMapping(value = "/data/producer/kafka", method = RequestMethod.POST,
			produces = MediaType.ALL_VALUE)
	public void produceKafkaData(@RequestParam(value = "data", required = true) String dataPoint) {
		
		Producer<String, String> producer = ProducerCreator.createProducer();
		final ProducerRecord<String, String> record = new ProducerRecord<String, String>(IKafkaConstants.TOPIC_NAME,
				dataPoint);
		
		producer.send(record);
	}
	
	


	
}
