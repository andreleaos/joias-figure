package br.com.lts.desafio.joiasfigure.mocks;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ClienteResponseDto;

import java.util.ArrayList;
import java.util.List;

public class ClienteResponseDtoMock {

    public static ClienteResponseDto getClienteResponseDto() {
        ClienteDto clienteDto = ClienteDtoMock.getClienteDtoComId();
        List<ClienteDto> clientes = new ArrayList<>();
        clientes.add(clienteDto);
        boolean processado = true;
        String mensagem = "processamento efetuado com sucesso";
        ClienteResponseDto response = new ClienteResponseDto(processado, mensagem, clientes);
        return response;
    }

    public static ClienteResponseDto getClienteResponseDto(ClienteDto clienteDto) {
        List<ClienteDto> clientes = new ArrayList<>();
        clientes.add(clienteDto);
        boolean processado = true;
        String mensagem = "processamento efetuado com sucesso";
        ClienteResponseDto response = new ClienteResponseDto(processado, mensagem, clientes);
        return response;
    }
}
