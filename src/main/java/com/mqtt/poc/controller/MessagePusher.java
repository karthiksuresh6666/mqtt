package com.mqtt.poc.controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mqtt.poc.publisher.EventPublisher;

/**
 * @author Karthik Suresh
 *
 */
@RestController
@RequestMapping("/msg")
public class MessagePusher {

	@GetMapping("/v1/publish")
	public void getFactoryMapConfig() {
		LocalDateTime ldt = LocalDateTime.now(ZoneOffset.UTC);
		String msg = "Current time is :{ " + ldt + "}";
		EventPublisher eventP = new EventPublisher();
		eventP.publish(msg);
	}

}
