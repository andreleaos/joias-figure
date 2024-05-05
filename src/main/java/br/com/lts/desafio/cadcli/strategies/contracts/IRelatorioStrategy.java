package br.com.lts.desafio.cadcli.strategies.contracts;

import br.com.lts.desafio.cadcli.models.dtos.responses.RelatorioResponseDto;
import br.com.lts.desafio.cadcli.models.enums.RelatorioStrategyEnum;

import java.util.List;

public interface IRelatorioStrategy {

    List<RelatorioResponseDto> executar(RelatorioStrategyEnum strategyEnum, Object objeto);

}
