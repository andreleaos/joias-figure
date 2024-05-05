package br.com.lts.desafio.cadcli.strategies.cases.produto;

import br.com.lts.desafio.cadcli.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.cadcli.models.entities.ProdutoModel;
import br.com.lts.desafio.cadcli.models.exceptions.ProdutoException;
import br.com.lts.desafio.cadcli.services.ProdutoService;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.contracts.ProdutoCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PesquisarProdutoCase extends ProdutoCase {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ProdutoResponseDto executar(Object objeto) {
        String mensagem = "";
        boolean processamentoComSucesso = false;
        List<ProdutoDto> produtos = new ArrayList<>();

        long codigoProduto = Long.parseLong((String) objeto);

        try {
            ProdutoModel.validarDadosParaPesquisa(codigoProduto);
            var produto = produtoService.pesquisarPorId(codigoProduto);
            produtos.add(produto);
            processamentoComSucesso = true;
            mensagem = "Processamento efetuado com sucesso";
        } catch (ProdutoException e) {
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(mensagem);
        }
        catch (NoSuchElementException e) {
            mensagem = "Produto: " + codigoProduto + " nao localizado";
            ConsoleLogService.logMessage("[ClienteService][pesquisarPorId] - Cliente: " + codigoProduto + " não localizado");
            processamentoComSucesso = false;
        }

        var result = new ProdutoResponseDto(processamentoComSucesso, mensagem, produtos);
        return result;
    }
}
