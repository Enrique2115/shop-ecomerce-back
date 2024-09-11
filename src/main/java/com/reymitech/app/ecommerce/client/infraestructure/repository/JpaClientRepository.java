package com.reymitech.app.ecommerce.client.infraestructure.repository;

import com.reymitech.app.ecommerce.client.domain.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaClientRepository extends JpaRepository<Client, String> {
    Client findByDocument(String document);
}
