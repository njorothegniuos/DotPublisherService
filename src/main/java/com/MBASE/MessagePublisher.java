package com.MBASE;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MBASE.model.Transaction;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@EnableBinding(Source.class)
public class MessagePublisher {
	
	@Autowired
	Source source;
	
	@PostMapping(value="/txn")
	public String sendMessage(@RequestBody String payload) {
		ObjectMapper ob = new ObjectMapper();
		Transaction txn = null;
		try {
			txn = ob.readValue(payload,Transaction.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		source.output().send(MessageBuilder.withPayload(txn).setHeader("DotHeader", "DotHeaderValue").build());
		System.out.print("DotPublisher message sent succesfully to Rabbitmq");
		return "Success";
	}

}
