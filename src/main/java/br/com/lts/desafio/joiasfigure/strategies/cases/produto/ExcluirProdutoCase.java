package br.com.lts.desafio.joiasfigure.strategies.cases.produto;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.joiasfigure.models.entities.ProdutoModel;
import br.com.lts.desafio.joiasfigure.models.exceptions.ProdutoException;
import br.com.lts.desafio.joiasfigure.services.ProdutoService;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.strategies.contracts.ProdutoCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExcluirProdutoCase extends ProdutoCase {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ProdutoResponseDto executar(Object objeto) {
        String mensagem = "";
        List<ProdutoDto> produtos = new ArrayList<>();
        boolean processamentoComSucesso = false;

        long codigoProduto = Long.parseLong((String) objeto);

        try {
            ProdutoModel.validarDadosParaExclusao(codigoProduto);
            var produtoExcluido = produtoService.excluir(codigoProduto);
            produtos.add(produtoExcluido);
            processamentoComSucesso = true;
            mensagem = "Processamento efetuado com sucesso";
        } catch (ProdutoException e) {
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(mensagem);
            processamentoComSucesso = false;
        }
        catch (IllegalArgumentException e) {
            mensagem = "Produto: " + codigoProduto + " nao localizado";
            ConsoleLogService.logMessage("[ClienteService][pesquisarPorId] - Cliente: " + codigoProduto + " não localizado");
            processamentoComSucesso = false;
        }

        var result = new ProdutoResponseDto(processamentoComSucesso, mensagem, produtos);
        return result;
    }
}
