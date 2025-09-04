package com.wintux.j20250901.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	@KafkaListener(topics="pruebita",groupId="miGrupito")
	public void consumir(String mensaje) {
		// Realizamos todo lo que nos interese con el mensaje
		LOGGER.info(String.format("Se recibió el mensaje: %s", mensaje));
	}
}
