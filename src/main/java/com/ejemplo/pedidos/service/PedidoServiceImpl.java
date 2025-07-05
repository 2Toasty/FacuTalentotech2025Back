package com.ejemplo.pedidos.service;

import com.ejemplo.articulos.model.Articulo;
import com.ejemplo.articulos.repository.ArticuloRepository;
import com.ejemplo.clientes.model.Cliente;
import com.ejemplo.clientes.service.ClienteService;
import com.ejemplo.pedidos.dto.CrearPedidoDTO;
import com.ejemplo.pedidos.dto.ItemPedidoDTO;
import com.ejemplo.pedidos.dto.ItemPedidoResponseDTO;
import com.ejemplo.pedidos.dto.PedidoResponseDTO;
import com.ejemplo.pedidos.model.LineaPedido;
import com.ejemplo.pedidos.model.Pedido;
import com.ejemplo.pedidos.repository.PedidoRepository;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;
    private final ArticuloRepository articuloRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository,
                             ClienteService clienteService,
                             ArticuloRepository articuloRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
        this.articuloRepository = articuloRepository;
    }

    @Override
    @Transactional
    public Pedido crearPedido(CrearPedidoDTO dto) {
        // 1. Obtener o crear cliente
        Cliente cliente = clienteService.obtenerOCrearCliente(
            new Cliente(dto.cliente.nombre, dto.cliente.email)
        );

        // 2. Crear pedido vacío y asignar cliente
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        // 3. Agregar líneas con artículos
        for (ItemPedidoDTO item : dto.items) {
            Articulo articulo = articuloRepository.findById(item.idArticulo)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado: " + item.idArticulo));

            LineaPedido linea = new LineaPedido();
            linea.setArticulo(articulo);
            linea.setCantidad(item.cantidad);

            pedido.agregarLinea(linea); // suma subtotal automáticamente
        }

        // 4. Guardar y retornar
        return pedidoRepository.save(pedido);
    }

   @Override
public List<PedidoResponseDTO> listarPedidos() {
    return pedidoRepository.findAll().stream().map(pedido -> {
        List<ItemPedidoResponseDTO> items = pedido.getLineas().stream().map(linea ->
            new ItemPedidoResponseDTO(
                linea.getArticulo().getNombre(),
                linea.getCantidad(),
                linea.getArticulo().getPrecio()
            )
        ).toList();

        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getCliente().getNombre(),
            pedido.getCliente().getEmail(),
            items,
            pedido.getTotal()
        );
    }).toList();
}
}
