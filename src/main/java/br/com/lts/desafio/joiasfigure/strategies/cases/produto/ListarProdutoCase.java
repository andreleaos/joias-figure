package br.com.lts.desafio.joiasfigure.strategies.cases.produto;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.joiasfigure.services.ProdutoService;
import br.com.lts.desafio.joiasfigure.strategies.contracts.ProdutoCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarProdutoCase extends ProdutoCase {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ProdutoResponseDto executar(Object objeto) {
        List<ProdutoDto> produtos = produtoService.listar();
        boolean processamentoComSucesso = true;
        String mensagem = "processamento efetuado com sucesso";

        if(produtos.isEmpty())
            mensagem = "Nao ha produtos na base de dados";

        var result = new ProdutoResponseDto(processamentoComSucesso, mensagem, produtos);
        return result;
    }
}
