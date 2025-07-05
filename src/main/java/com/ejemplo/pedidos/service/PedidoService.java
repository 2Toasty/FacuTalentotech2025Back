package com.ejemplo.pedidos.service;

import com.ejemplo.pedidos.model.Pedido;

import java.util.List;

import com.ejemplo.pedidos.dto.CrearPedidoDTO;
import com.ejemplo.pedidos.dto.PedidoResponseDTO;

public interface PedidoService {
    Pedido crearPedido(CrearPedidoDTO dto);

    List<PedidoResponseDTO> listarPedidos();
}
