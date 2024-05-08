package br.com.lts.desafio.joiasfigure.strategies;

import br.com.lts.desafio.joiasfigure.models.dtos.responses.RelatorioResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.RelatorioStrategyEnum;
import br.com.lts.desafio.joiasfigure.strategies.contexts.RelatorioContext;
import br.com.lts.desafio.joiasfigure.strategies.contracts.IRelatorioStrategy;
import br.com.lts.desafio.joiasfigure.strategies.contracts.RelatorioCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioStrategy implements IRelatorioStrategy {

    @Autowired
    RelatorioCase relatorioCase;

    @Autowired
    RelatorioContext relatorioContext;

    @Override
    public List<RelatorioResponseDto> executar(RelatorioStrategyEnum strategyEnum, Object objeto) {

        switch (strategyEnum) {
            case RELATORIO_PEDIDOS:
                relatorioContext.setCase(relatorioCase);
                break;

            default:
                relatorioContext.setCase(relatorioCase);
                break;
        }

        var result = relatorioContext.executar(objeto);
        return result;
    }
}
