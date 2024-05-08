package br.com.lts.desafio.joiasfigure.strategies.contracts;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.ClienteStrategyEnum;

public interface IClienteStrategy {

    ClienteResponseDto executar(ClienteStrategyEnum strategyEnum, Object objeto);
}

