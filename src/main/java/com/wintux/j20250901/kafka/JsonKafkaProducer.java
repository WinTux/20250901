package com.wintux.j20250901.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.wintux.j20250901.DTO.Usuario;

@Service
public class JsonKafkaProducer {
	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);
	private KafkaTemplate<String,Usuario> kafkaTemplate;
	public JsonKafkaProducer(KafkaTemplate<String, Usuario> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void enviarMensaje(Usuario usu) {
		Message<Usuario> mensaje = MessageBuilder
				.withPayload(usu)
				.setHeader(KafkaHeaders.TOPIC, "jsonTopic")
				.build();
		kafkaTemplate.send(mensaje);
		logger.info(String.format("Mensaje enviado: %s", usu.toString()));
	}
}
