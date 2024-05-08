package br.com.lts.desafio.joiasfigure.strategies.contexts;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.PedidoResponseDto;
import br.com.lts.desafio.joiasfigure.strategies.contracts.PedidoCase;
import org.springframework.stereotype.Service;

@Service
public class PedidoContext {
    private PedidoCase pedidoCase;

    public void setCase(PedidoCase pedidoCase) {
        this.pedidoCase = pedidoCase;
    }

    public PedidoResponseDto executar(Object objeto) {
        return pedidoCase.executar(objeto);
    }
}
