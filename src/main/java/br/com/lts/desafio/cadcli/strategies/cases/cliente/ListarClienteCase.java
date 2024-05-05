package br.com.lts.desafio.cadcli.strategies.cases.cliente;

import br.com.lts.desafio.cadcli.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.cadcli.services.ClienteService;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.contracts.ClienteCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarClienteCase extends ClienteCase {

    @Autowired
    ClienteService clienteService;

    public ClienteResponseDto executar(Object objeto) {
        var clientes = clienteService.listar();
        ConsoleLogService.logMessage("Itens retornados: " + clientes.size());
        String mensagem = "processamento efetuado com sucesso";

        if(clientes.isEmpty()){
            mensagem = "nao há clientes na base de dados";
        }

        var result = new ClienteResponseDto(true, mensagem, clientes);
        return result;
    }
}
