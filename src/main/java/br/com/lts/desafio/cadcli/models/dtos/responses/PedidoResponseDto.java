package br.com.lts.desafio.cadcli.models.dtos.responses;

import br.com.lts.desafio.cadcli.models.dtos.requests.CriacaoPedidoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDto {
    private boolean processadoComSucesso;
    private String mensagemRetorno;
    private List<CriacaoPedidoDto> pedidos;
}
