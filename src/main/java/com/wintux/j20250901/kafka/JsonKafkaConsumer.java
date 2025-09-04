package com.wintux.j20250901.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wintux.j20250901.DTO.Usuario;

@Service
public class JsonKafkaConsumer {
	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	@KafkaListener(topics="jsonTopic",groupId="miGrupito")
	public void consumir(Usuario us) {
		logger.info(String.format("Mensaje JSON recibido: %s", us));
	}

}
