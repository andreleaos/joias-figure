package br.com.lts.desafio.cadcli.strategies.contracts;

import br.com.lts.desafio.cadcli.models.dtos.responses.PedidoResponseDto;

public abstract class PedidoCase {

    public abstract PedidoResponseDto executar(Object objeto);
}
