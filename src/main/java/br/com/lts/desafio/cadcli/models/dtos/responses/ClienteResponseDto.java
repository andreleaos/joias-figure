package br.com.lts.desafio.cadcli.models.dtos.responses;

import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ClienteResponseDto {
    private boolean processadoComSucesso;
    private String mensagemRetorno;
    private List<ClienteDto> clientes;
}
