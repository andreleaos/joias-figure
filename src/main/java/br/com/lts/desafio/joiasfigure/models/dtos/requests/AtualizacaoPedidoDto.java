package br.com.lts.desafio.joiasfigure.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AtualizacaoPedidoDto {
    private Long codigoPedido;
    private int codigoStatusPedido;
}
