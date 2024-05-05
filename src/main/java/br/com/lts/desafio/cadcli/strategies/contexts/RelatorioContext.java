package br.com.lts.desafio.cadcli.strategies.contexts;

import br.com.lts.desafio.cadcli.models.dtos.responses.RelatorioResponseDto;
import br.com.lts.desafio.cadcli.strategies.contracts.RelatorioCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioContext {

    private RelatorioCase relatorioCase;

    public void setCase(RelatorioCase relatorioCase) {
        this.relatorioCase = relatorioCase;
    }

    public List<RelatorioResponseDto> executar(Object objeto) {
        return relatorioCase.executar(objeto);
    }

}
