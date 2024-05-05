package br.com.lts.desafio.cadcli.strategies.contracts;

import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.ClienteResponseDto;

import java.util.ArrayList;
import java.util.List;

public abstract class ClienteCase {

    public abstract ClienteResponseDto executar(Object objeto);

    public List<ClienteDto> criarListaRetorno(ClienteDto clienteDto){
        List<ClienteDto> clientes = new ArrayList<>();
        if(clienteDto != null){
            clientes.add(clienteDto);
        }
        return clientes;
    }
}
