package br.com.lts.desafio.joiasfigure.strategies.contracts;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.ProdutoStrategyEnum;

public interface IProdutoStrategy {
    ProdutoResponseDto executar(ProdutoStrategyEnum strategyEnum, Object objeto);
}
