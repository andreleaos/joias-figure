package br.com.lts.desafio.cadcli.strategies.cases.produto;

import br.com.lts.desafio.cadcli.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.cadcli.models.entities.ProdutoModel;
import br.com.lts.desafio.cadcli.models.exceptions.ProdutoException;
import br.com.lts.desafio.cadcli.services.GerenciadorArquivoService;
import br.com.lts.desafio.cadcli.services.ProdutoService;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.contracts.ProdutoCase;
import br.com.lts.desafio.cadcli.utils.ProdutoConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtualizarProdutoCase extends ProdutoCase {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    GerenciadorArquivoService gerenciadorArquivoService;


    @Override
    public ProdutoResponseDto executar(Object objeto) {

        String mensagem = "";
        List<ProdutoDto> produtos = new ArrayList<>();
        boolean processamentoComSucesso = false;

        ProdutoDto produtoDto = (ProdutoDto) objeto;
        ProdutoModel produtoValidacao = ProdutoConversor.converterParaModel(produtoDto);

        try{
            produtoValidacao.validarDadosParaAtuaizacao();
            var produto = produtoService.atualizar(produtoDto);
            gerenciadorArquivoService.gravarProdutoAtualizado(produtoDto);
            produtos = criarListaRetorno(produto);
            processamentoComSucesso = true;
            mensagem = "processamento efetuado com sucesso";
        }
        catch (IllegalArgumentException e){
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(mensagem);
        }
        catch (ProdutoException e){
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(mensagem);
        }

        var result = new ProdutoResponseDto(processamentoComSucesso, mensagem, produtos);
        return result;
    }
}
