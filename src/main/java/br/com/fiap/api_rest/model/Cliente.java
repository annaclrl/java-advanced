package br.com.fiap.api_rest.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @Column(name = "nr_cpf")
    private String cpf;

    @Column(name = "nm_cliente")
    private String nome;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "nr_telefone")
    private String telefone;
}