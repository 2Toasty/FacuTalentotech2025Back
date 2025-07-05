package com.ejemplo.clientes.service;

import com.ejemplo.clientes.model.Cliente;
import com.ejemplo.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente obtenerOCrearCliente(Cliente cliente) {
        return clienteRepository.findByEmail(cliente.getEmail())
                .orElseGet(() -> clienteRepository.save(cliente));
    }
}
