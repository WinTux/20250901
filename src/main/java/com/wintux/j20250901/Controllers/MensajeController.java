package com.wintux.j20250901.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wintux.j20250901.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka") // http://localhost:8080/pai/v1/kafka
public class MensajeController {
	private KafkaProducer kafkaProd;
	
	
	public MensajeController(KafkaProducer kafkaProd) {
		super();
		this.kafkaProd = kafkaProd;
	}


	@GetMapping("/publicar") // http://localhost:8080/pai/v1/kafka/publicar [GET]
	public ResponseEntity<String> publicar(@RequestParam("mensajito") String msj){
		kafkaProd.enviarMensaje(msj);
		return ResponseEntity.ok("Mensaje enviado al topic.");
	}
}
