package br.com.fiap.api_rest.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_pedido")
    private UUID id;

    @Column(name = "dt_pedido")
    private LocalDate data;

    private List<Produto> produtos;

    @Column(name = "vl_pedido")
    private int valor;
}