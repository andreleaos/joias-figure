package br.com.lts.desafio.joiasfigure.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private String codigoCliente;
    private String nomeCliente;
    private String emailCliente;
    private String foneCliente;
    private String rgCliente;
    private String cpfCliente;
    private boolean clienteEstaAtivo;
}
