package br.com.lts.desafio.cadcli.models.dtos.responses;

import br.com.lts.desafio.cadcli.models.dtos.requests.ItemPedidoRelatorioDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioResponseDto {

    private String codigoCliente;
    private String nomeCliente;

    private Long codigoPedido;
    private String statusPedido;
    private double valorTotalPedido;

    private List<ItemPedidoRelatorioDto> itensPedido;
}
