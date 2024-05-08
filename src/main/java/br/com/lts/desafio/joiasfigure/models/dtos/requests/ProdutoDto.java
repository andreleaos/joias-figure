package br.com.lts.desafio.joiasfigure.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
    private Long codigoProduto;
    private String nomeProduto;
    private double precoProduto;
}
