package com.ejemplo.pedidos.dto;

public class ItemPedidoResponseDTO {
    public String nombreArticulo;
    public int cantidad;
    public double precioUnitario;
    public double subtotal;

    public ItemPedidoResponseDTO(String nombreArticulo, int cantidad, double precioUnitario) {
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = cantidad * precioUnitario;
    }
}
