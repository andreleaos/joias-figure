package br.com.lts.desafio.joiasfigure.models.dtos.responses;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoResponseDto {
    private boolean processadoComSucesso;
    private String mensagemRetorno;
    private List<ProdutoDto> produtos;
}

