package br.com.lts.desafio.cadcli.containers;

import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import org.springframework.stereotype.Service;

@Service
public class ClienteDataHolder {
    private ClienteDto cliente;

    public synchronized void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public synchronized ClienteDto getCliente() {
        return cliente;
    }
}
