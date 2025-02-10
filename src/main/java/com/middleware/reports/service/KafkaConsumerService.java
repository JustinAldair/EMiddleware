package com.middleware.reports.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "campanas-topic", groupId = "grupo-reportes")
    public void recibirMensaje(String mensaje) {
        System.out.println("Mensaje recibido" + mensaje);
    }
}
