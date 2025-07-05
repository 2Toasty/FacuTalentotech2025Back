package com.ejemplo.clientes.service;

import com.ejemplo.clientes.model.Cliente;

public interface ClienteService {
    Cliente obtenerOCrearCliente(Cliente cliente);
}
// Esta interfaz define el servicio para manejar clientes
// Contiene un método para obtener o crear un cliente basado en su información
// El método recibe un objeto Cliente y devuelve el cliente encontrado o creado
// Permite manejar la lógica de negocio relacionada con los clientes   
