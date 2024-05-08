package br.com.lts.desafio.joiasfigure.strategies.contracts;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.RelatorioResponseDto;

import java.util.List;

public abstract class RelatorioCase {

    public abstract List<RelatorioResponseDto> executar(Object objeto);

}
