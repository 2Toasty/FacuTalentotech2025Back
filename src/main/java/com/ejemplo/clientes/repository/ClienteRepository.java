package com.ejemplo.clientes.repository;

import com.ejemplo.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
// Esta interfaz se conecta con la base de datos y maneja operaciones sobre la entidad Cliente
// Extiende JpaRepository para heredar métodos CRUD básicos