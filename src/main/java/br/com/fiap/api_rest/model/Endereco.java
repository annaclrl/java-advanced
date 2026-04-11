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
}