package com.example.subscription_reservas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.subscription_reservas.model.CitaMedica;


@Repository
public interface ReservasRepository extends JpaRepository<CitaMedica, Long> {
}