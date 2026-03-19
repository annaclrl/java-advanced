package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.ProdutoRequest;
import br.com.fiap.api_rest.dto.ProdutoResponse;
import br.com.fiap.api_rest.mapper.ProdutoMapper;
import br.com.fiap.api_rest.model.Produto;
import br.com.fiap.api_rest.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper){
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public Produto create(ProdutoRequest produtoRequest){
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoRequest, produto);
        return produtoRepository.save(produto);
    }


    public ProdutoResponse read(UUID id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            return null;
        }
        return produtoMapper.produtoToResponse(produto.get());
    }

    //Page, Pageable
    public Page<ProdutoResponse> readAll(Pageable peageable){
        return produtoRepository
                .findAll(peageable)
                .map(produtoMapper::produtoToResponse);
    }

    public Produto update(Produto produto){
        return produtoRepository.save(produto);
    }

    public void delete(UUID id){
        produtoRepository.deleteById(id);
    }
}
