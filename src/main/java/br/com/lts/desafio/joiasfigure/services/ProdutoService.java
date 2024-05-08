package br.com.lts.desafio.joiasfigure.services;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.joiasfigure.models.entities.ProdutoModel;
import br.com.lts.desafio.joiasfigure.repositories.ProdutoRepository;
import br.com.lts.desafio.joiasfigure.utils.ProdutoConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoDto salvar(ProdutoDto produtoDto) {
        var produto = ProdutoConversor.converterParaModel(produtoDto);
        var produtoCadastrado = produtoRepository.save(produto);
        var produtoSalvo = ProdutoConversor.converterParaDto(produtoCadastrado);
        return produtoSalvo;
    }

    public List<ProdutoDto> listar() {
        var produtos = produtoRepository.findAll();
        var produtosDtos = ProdutoConversor.converterParaListDto(produtos);
        return produtosDtos;
    }

    public ProdutoDto pesquisarPorId(Long id) {
        var produto = produtoRepository.findById(id).get();
        var produtoDto = ProdutoConversor.converterParaDto(produto);
        return produtoDto;
    }

    public ProdutoDto excluir(Long id) {
        ProdutoModel produto = produtoRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto nao localizado: " + id));

        produtoRepository.deleteById(id);
        var dto = ProdutoConversor.converterParaDto(produto);
        return dto;
    }

    public ProdutoDto atualizar(ProdutoDto produtoDto) {
        var produto = produtoRepository.findById(produtoDto.getCodigoProduto())
                .orElseThrow(() -> new IllegalArgumentException("Produto nao localizado: " + produtoDto.getCodigoProduto()));

        produto.setNomeProduto(produtoDto.getNomeProduto());
        produto.setPrecoProduto(produtoDto.getPrecoProduto());

        produtoRepository.save(produto);
        var dto = ProdutoConversor.converterParaDto(produto);
        return dto;
    }
}
