package com.ejemplo.pedidos.repository;

import com.ejemplo.pedidos.model.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineaPedidoRepository extends JpaRepository<LineaPedido, Long> {
}
