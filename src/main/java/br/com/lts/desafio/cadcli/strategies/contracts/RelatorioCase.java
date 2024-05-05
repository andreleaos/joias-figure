package br.com.lts.desafio.cadcli.strategies.contracts;

import br.com.lts.desafio.cadcli.models.dtos.responses.RelatorioResponseDto;

import java.util.List;

public abstract class RelatorioCase {

    public abstract List<RelatorioResponseDto> executar(Object objeto);

}
