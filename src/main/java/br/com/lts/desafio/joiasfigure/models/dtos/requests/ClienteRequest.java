package br.com.lts.desafio.joiasfigure.models.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteRequest {
    private ClienteDto cliente;

    @JsonProperty("cliente")
    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }
}

