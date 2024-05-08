package br.com.lts.desafio.joiasfigure.strategies.contracts;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.PedidoResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.PedidoStrategyEnum;

public interface IPedidoStrategy {
    PedidoResponseDto executar(PedidoStrategyEnum strategyEnum, Object objeto);
}
