package br.com.lts.desafio.joiasfigure.strategies.cases.produto;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.joiasfigure.models.entities.ProdutoModel;
import br.com.lts.desafio.joiasfigure.models.exceptions.ProdutoException;
import br.com.lts.desafio.joiasfigure.services.ProdutoService;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.strategies.contracts.ProdutoCase;
import br.com.lts.desafio.joiasfigure.utils.ProdutoConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastrarProdutoCase extends ProdutoCase {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ProdutoResponseDto executar(Object objeto) {
        String mensagem = "";
        List<ProdutoDto> produtos = new ArrayList<>();
        boolean processamentoComSucesso = false;

        ProdutoDto produtoDto = (ProdutoDto) objeto;
        ProdutoModel produtoValidacao = ProdutoConversor.converterParaModel(produtoDto);

        try{
            produtoValidacao.validarDadosParaCadastro();
            var produto = produtoService.salvar(produtoDto);
            produtos.add(produto);
            mensagem = "processamento efetuado com sucesso";
        }
        catch(ProdutoException e){
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(e.getMessage());
        }

        var result = new ProdutoResponseDto(processamentoComSucesso, mensagem, produtos);
        return result;
    }
}
