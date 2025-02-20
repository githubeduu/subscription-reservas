package com.example.subscription_reservas.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.subscription_reservas.model.CitaMedica;
import com.example.subscription_reservas.repository.ReservasRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitMQListener {

    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "citas")
    public void recibirMensaje(String mensajeJson) {
        try {
            // Convertir el JSON recibido a un objeto Encuesta
            CitaMedica citaMedica = objectMapper.readValue(mensajeJson, CitaMedica.class);

            reservasRepository.save(citaMedica);

            System.out.println("citaMedica guardada correctamente: " + citaMedica.getId());

        } catch (Exception e) {
            System.err.println("Error al procesar el mensaje: " + e.getMessage());
        }
    }
}