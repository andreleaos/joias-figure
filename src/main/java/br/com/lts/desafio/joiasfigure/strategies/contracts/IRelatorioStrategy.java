package br.com.lts.desafio.joiasfigure.strategies.contracts;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.RelatorioResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.RelatorioStrategyEnum;

import java.util.List;

public interface IRelatorioStrategy {

    List<RelatorioResponseDto> executar(RelatorioStrategyEnum strategyEnum, Object objeto);

}
