package com.ejemplo.pedidos.dto;

public class PedidoCreadoResponse {
    public Long id;
    public Double total;
    public String mensaje;

    public PedidoCreadoResponse(Long id, Double total, String mensaje) {
        this.id = id;
        this.total = total;
        this.mensaje = mensaje;
    }
}
