package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    private Produto create(Produto produto){
        return produtoRepository.save(produto);
    }

    private Produto read(UUID id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    private List<Produto> readAll(){
        return produtoRepository.findAll();
    }

    private Produto update(Produto produto){
        return produtoRepository.save(produto);
    }

    private void delete(UUID id){
        produtoRepository.deleteById(id);
    }
}
