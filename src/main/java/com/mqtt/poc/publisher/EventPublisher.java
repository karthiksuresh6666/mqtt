package com.mqtt.poc.publisher;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Karthik Suresh
 *
 */
public class EventPublisher {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventPublisher.class);

	String topic = "first_topic";
	int qos = 2;
	String broker = "tcp://localhost:1883";
	String clientId = "rebel";
	MemoryPersistence persistence = new MemoryPersistence();

	public void publish(String msg) {
		try {
			MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			sampleClient.connect(connOpts);
			MqttMessage message = new MqttMessage(msg.getBytes());
			message.setQos(qos);
			sampleClient.publish(topic, message);
			sampleClient.disconnect();
			System.out.println("Disconnected");
			sampleClient.close();
		} catch (MqttException ex) {
			System.out.println("exception occured"+ ex.getMessage());
			LOGGER.error("Exception in publish() :{}", ex.getMessage());
		}
	}

}
