package br.com.lts.desafio.joiasfigure.strategies.contracts;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ProdutoResponseDto;

import java.util.ArrayList;
import java.util.List;

public abstract class ProdutoCase {

    public abstract ProdutoResponseDto executar(Object objeto);

    public List<ProdutoDto> criarListaRetorno(ProdutoDto produtoDto){
        List<ProdutoDto> produtos = new ArrayList<>();
        if(produtoDto != null){
            produtos.add(produtoDto);
        }
        return produtos;
    }
}

