package br.com.fiap.api_rest.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_endereco")
    private UUID id;

    @Column(name = "ds_logradouro")
    private String logradouro;

    @Column(name = "nr_endereco")
    private int numero;

    @Column(name = "ds_complemento")
    private String complemento;

    @Column(name = "nm_cidade")
    private String cidade;

    @Column(name = "nm_bairro")
    private String bairro;

    @Column(name = "sg_estado")
    private String estado;

    @Column(name = "nr_cep")
    private String cep;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}