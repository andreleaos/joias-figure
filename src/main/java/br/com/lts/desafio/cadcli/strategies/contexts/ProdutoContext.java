package br.com.lts.desafio.cadcli.strategies.contexts;

import br.com.lts.desafio.cadcli.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.cadcli.strategies.contracts.ProdutoCase;
import org.springframework.stereotype.Service;

@Service
public class ProdutoContext {
    private ProdutoCase produtoCase;

    public void setCase(ProdutoCase produtoCase) {
        this.produtoCase = produtoCase;
    }

    public ProdutoResponseDto executar(Object objeto) {
        return produtoCase.executar(objeto);
    }
}
