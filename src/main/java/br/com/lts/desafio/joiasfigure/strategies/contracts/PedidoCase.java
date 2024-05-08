package br.com.lts.desafio.joiasfigure.strategies.contracts;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.PedidoResponseDto;

public abstract class PedidoCase {

    public abstract PedidoResponseDto executar(Object objeto);
}
