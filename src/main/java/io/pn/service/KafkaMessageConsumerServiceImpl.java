package io.pn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.pn.dto.CricketScore;

@Service
public class KafkaMessageConsumerServiceImpl {
	
	@Autowired
	ObjectMapper mapper;
	
	@KafkaListener(topics = "quickstart-events",groupId = "application_group")
	public void listen(String message) {
		CricketScore score = null;
		try {
		score = mapper.readValue(message, CricketScore.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Message :"+ score);
	}
}
