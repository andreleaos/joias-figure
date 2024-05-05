package br.com.lts.desafio.cadcli.strategies.contexts;

import br.com.lts.desafio.cadcli.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.cadcli.strategies.contracts.ClienteCase;
import org.springframework.stereotype.Service;

@Service
public class ClienteContext {
    private ClienteCase clienteCase;

    public void setCase(ClienteCase clienteCase) {
        this.clienteCase = clienteCase;
    }

    public ClienteResponseDto executar(Object objeto) {
        return clienteCase.executar(objeto);
    }
}
