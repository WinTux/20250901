package com.wintux.j20250901.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wintux.j20250901.DTO.Usuario;
import com.wintux.j20250901.kafka.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MensajeJsonController {
	private JsonKafkaProducer kafkaJsonProd;
	
	public MensajeJsonController(JsonKafkaProducer kafkaJsonProd) {
		super();
		this.kafkaJsonProd = kafkaJsonProd;
	}

	@PostMapping("/publicar") // http://localhost:8080/api/v1/kafka/publicar [POST]
	public ResponseEntity<String> publicarJson(@RequestBody Usuario u){
		kafkaJsonProd.enviarMensaje(u);
		return ResponseEntity.ok("Se envio el mensaje al topic kafka");
	}
}
