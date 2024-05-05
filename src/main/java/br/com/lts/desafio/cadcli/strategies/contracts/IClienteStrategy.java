package br.com.lts.desafio.cadcli.strategies.contracts;

import br.com.lts.desafio.cadcli.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.cadcli.models.enums.ClienteStrategyEnum;

public interface IClienteStrategy {

    ClienteResponseDto executar(ClienteStrategyEnum strategyEnum, Object objeto);
}

