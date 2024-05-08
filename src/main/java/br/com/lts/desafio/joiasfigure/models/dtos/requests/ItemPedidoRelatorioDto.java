package br.com.lts.desafio.joiasfigure.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoRelatorioDto {
    private Long codigoItemPedido;
    private Long codigoProduto;
    private int quantidade;
    private String nomeProduto;
    private double precoProduto;
}
