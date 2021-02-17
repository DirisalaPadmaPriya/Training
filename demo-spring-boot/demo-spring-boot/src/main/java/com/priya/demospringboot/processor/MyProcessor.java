package com.priya.demospringboot.processor;

import java.util.Map;

import org.apache.camel.*;
import org.apache.logging.log4j.*;


import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

@Component
public class MyProcessor implements Processor {

	
	private static Logger logger=LogManager.getLogger(MyProcessor.class);
	
	public void process(Exchange exchange) throws Exception{
	String messageBody=exchange.getIn().getBody(String.class);
	Map<String,Object>exchangeProperties=exchange.getProperties();
	System.out.println("------");
	logger.info("Message Body from including Exchange, {}",messageBody);
	logger.info("Exchange Properties {}",exchangeProperties);
	
	messageBody=messageBody.concat("Updating processor");
	logger.info("Updated Exchange, {}",messageBody);
	exchange.getIn().setBody(messageBody);
}	
}
