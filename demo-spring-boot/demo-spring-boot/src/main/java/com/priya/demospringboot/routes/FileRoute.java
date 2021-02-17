package com.priya.demospringboot.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.priya.demospringboot.processor.MyProcessor;

@Component
public class FileRoute extends RouteBuilder{
	
@Value("${app.source}")	
private String sourceLocation;
@Value("${app.destination}")
private String destination;
@Autowired
private MyProcessor processor;
	@Override
	public void configure() throws Exception {
		
		fileCopier();
	}
	private void fileCopier() {
		from("file:"+sourceLocation)
		.routeId("Demo-File-Route")
		//.setBody(simple("${body}.I have updated the file"))
		.process(processor)
		.to("file:"+destination)
		.log(LoggingLevel.INFO,"File is moved to destination \n ${body}");
	}
}
