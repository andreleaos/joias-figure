package br.com.lts.desafio.joiasfigure.strategies;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.PedidoResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.PedidoStrategyEnum;
import br.com.lts.desafio.joiasfigure.strategies.cases.pedido.AtualizarStatusPedidoCase;
import br.com.lts.desafio.joiasfigure.strategies.cases.pedido.CriarPedidoCase;
import br.com.lts.desafio.joiasfigure.strategies.cases.pedido.ListarPedidoCase;
import br.com.lts.desafio.joiasfigure.strategies.cases.pedido.PesquisarPedidoCase;
import br.com.lts.desafio.joiasfigure.strategies.contexts.PedidoContext;
import br.com.lts.desafio.joiasfigure.strategies.contracts.IPedidoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoStrategy implements IPedidoStrategy {

    @Autowired
    CriarPedidoCase criarPedidoCase;

    @Autowired
    AtualizarStatusPedidoCase atualizarStatusPedidoCase;

    @Autowired
    PesquisarPedidoCase pesquisarPedidoCase;

    @Autowired
    ListarPedidoCase listarPedidoCase;

    @Autowired
    PedidoContext pedidoContext;

    @Override
    public PedidoResponseDto executar(PedidoStrategyEnum strategyEnum, Object objeto) {

        switch (strategyEnum) {
            case CRIAR_PEDIDO:
                pedidoContext.setCase(criarPedidoCase);
                break;

            case PESQUISAR_PEDIDO:
                pedidoContext.setCase(pesquisarPedidoCase);
                break;

            case LISTAR_PEDIDOS:
                pedidoContext.setCase(listarPedidoCase);
                break;

            case ATUALIZAR_STATUS_PEDIDO:
                pedidoContext.setCase(atualizarStatusPedidoCase);
                break;

            default:
                pedidoContext.setCase(listarPedidoCase);
                break;
        }

        var result = pedidoContext.executar(objeto);
        return result;
    }
}
