package com.ejemplo.pedidos.model;

import com.ejemplo.clientes.model.Cliente;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineas = new ArrayList<>();

    private Double total = 0.0;

    public Pedido() {}

    public Pedido(Long id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    // Método para agregar una línea y actualizar el total
    public void agregarLinea(LineaPedido linea) {
        linea.setPedido(this); // establece la relación bidireccional
        lineas.add(linea);
        total += linea.getSubtotal();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaPedido> lineas) {
        this.lineas = lineas;
        this.total = lineas.stream()
                           .mapToDouble(LineaPedido::getSubtotal)
                           .sum();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
