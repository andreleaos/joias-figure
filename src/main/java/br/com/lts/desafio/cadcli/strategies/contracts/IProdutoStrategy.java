package br.com.lts.desafio.cadcli.strategies.contracts;

import br.com.lts.desafio.cadcli.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.cadcli.models.enums.ProdutoStrategyEnum;

public interface IProdutoStrategy {
    ProdutoResponseDto executar(ProdutoStrategyEnum strategyEnum, Object objeto);
}
