package br.com.lts.desafio.joiasfigure.strategies;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.ProdutoStrategyEnum;
import br.com.lts.desafio.joiasfigure.strategies.cases.produto.*;
import br.com.lts.desafio.joiasfigure.strategies.contexts.ProdutoContext;
import br.com.lts.desafio.joiasfigure.strategies.contracts.IProdutoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoStrategy implements IProdutoStrategy {

    @Autowired
    CadastrarProdutoCase cadastrarProdutoCase;

    @Autowired
    AtualizarProdutoCase atualizarProdutoCase;

    @Autowired
    PesquisarProdutoCase pesquisarProdutoCase;

    @Autowired
    ListarProdutoCase listarProdutoCase;

    @Autowired
    private ExcluirProdutoCase excluirProdutoCase;

    @Autowired
    ProdutoContext produtoContext;

    @Override
    public ProdutoResponseDto executar(ProdutoStrategyEnum strategyEnum, Object objeto) {

        switch (strategyEnum) {
            case CADASTRAR_PRODUTO:
                produtoContext.setCase(cadastrarProdutoCase);
                break;

            case ATUALIZAR_PRODUTO:
                produtoContext.setCase(atualizarProdutoCase);
                break;

            case EXCLUIR_PRODUTO:
                produtoContext.setCase(excluirProdutoCase);
                break;

            case LISTAR_PRODUTO:
                produtoContext.setCase(listarProdutoCase);
                break;

            case PESQUISAR_PRODUTO:
                produtoContext.setCase(pesquisarProdutoCase);
                break;

            default:
                produtoContext.setCase(listarProdutoCase);
                break;
        }

        var result = produtoContext.executar(objeto);
        return result;
    }
}
