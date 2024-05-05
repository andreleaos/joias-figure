package br.com.lts.desafio.cadcli.mocks;

import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;

import java.util.UUID;

public class ClienteDtoMock {

    public static ClienteDto getClienteDto() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNomeCliente("Joao da Silva");
        clienteDto.setEmailCliente("joao.silva@email.com");
        clienteDto.setFoneCliente("11 4578-9865");
        clienteDto.setClienteEstaAtivo(true);
        return clienteDto;
    }

    public static ClienteDto getClienteDtoComId() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCodigoCliente(UUID.randomUUID().toString());
        clienteDto.setNomeCliente("Joao da Silva");
        clienteDto.setEmailCliente("joao.silva@email.com");
        clienteDto.setFoneCliente("11 4578-9865");
        clienteDto.setClienteEstaAtivo(true);
        return clienteDto;
    }

    public static ClienteDto getClienteDtoComIdESemNome() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCodigoCliente(UUID.randomUUID().toString());
        clienteDto.setEmailCliente("joao.silva@email.com");
        clienteDto.setFoneCliente("11 4578-9865");
        clienteDto.setClienteEstaAtivo(true);
        return clienteDto;
    }


    public static ClienteDto getClienteDtoComDocumentos() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCodigoCliente(UUID.randomUUID().toString());
        clienteDto.setNomeCliente("Joao da Silva");
        clienteDto.setEmailCliente("joao.silva@email.com");
        clienteDto.setFoneCliente("11 4578-9865");
        clienteDto.setRgCliente("569878985");
        clienteDto.setCpfCliente("58762365897");
        clienteDto.setClienteEstaAtivo(true);
        return clienteDto;
    }

    public static ClienteDto getClienteDtoSemNome() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setEmailCliente("joao.silva@email.com");
        clienteDto.setFoneCliente("11 4578-9865");
        return clienteDto;
    }

    public static ClienteDto getClienteDtoSemEmail() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNomeCliente("Joao da Silva");
        clienteDto.setFoneCliente("11 4578-9865");
        return clienteDto;
    }
}
