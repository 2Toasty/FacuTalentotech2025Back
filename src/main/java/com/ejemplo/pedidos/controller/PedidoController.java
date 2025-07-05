package com.ejemplo.pedidos.controller;

import com.ejemplo.pedidos.dto.CrearPedidoDTO;
import com.ejemplo.pedidos.dto.PedidoCreadoResponse;
import com.ejemplo.pedidos.dto.PedidoResponseDTO;
import com.ejemplo.pedidos.model.Pedido;
import com.ejemplo.pedidos.service.PedidoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Endpoint: POST /api/pedidos
   @PostMapping
public ResponseEntity<?> crearPedido(@RequestBody CrearPedidoDTO dto) {
    try {
        Pedido pedido = pedidoService.crearPedido(dto);
        PedidoCreadoResponse response = new PedidoCreadoResponse(
            pedido.getId(),
            pedido.getTotal(),
            "Pedido creado con éxito"
        );
        return ResponseEntity.status(201).body(response);
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}


@GetMapping
public ResponseEntity<List<PedidoResponseDTO>> listarPedidos() {
    return ResponseEntity.ok(pedidoService.listarPedidos());
}

}
