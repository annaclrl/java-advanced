package br.com.fiap.api_rest.model;

import br.com.fiap.api_rest.model.enums.StatusPedido;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(name = "vl_pedido")
    private int valor;

    @Column(name = "status_pedido")
    private StatusPedido status;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToMany
    @JoinTable(name = "produto_pedido",
            joinColumns = @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id_produto"))
    private List<Produto> produtos;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}