package com.ejemplo.pedidos.dto;

import java.util.List;

public class PedidoResponseDTO {
    public Long id;
    public String nombreCliente;
    public String emailCliente;
    public List<ItemPedidoResponseDTO> items;
    public Double total;

    public PedidoResponseDTO(Long id, String nombreCliente, String emailCliente, List<ItemPedidoResponseDTO> items, Double total) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.emailCliente = emailCliente;
        this.items = items;
        this.total = total;
    }
}
