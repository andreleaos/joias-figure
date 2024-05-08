package br.com.lts.desafio.joiasfigure.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
    private Long codigoPedido;
    private String codigoCliente;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private int codigoStatusPedido;
    private double valorTotalPedido;
}
