package br.com.lts.desafio.cadcli.strategies.contracts;

import br.com.lts.desafio.cadcli.models.dtos.responses.PedidoResponseDto;
import br.com.lts.desafio.cadcli.models.enums.PedidoStrategyEnum;

public interface IPedidoStrategy {
    PedidoResponseDto executar(PedidoStrategyEnum strategyEnum, Object objeto);
}
