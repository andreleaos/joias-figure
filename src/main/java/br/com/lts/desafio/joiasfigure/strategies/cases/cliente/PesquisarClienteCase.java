package br.com.lts.desafio.joiasfigure.strategies.cases.cliente;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.joiasfigure.models.entities.ClienteModel;
import br.com.lts.desafio.joiasfigure.models.exceptions.ClienteException;
import br.com.lts.desafio.joiasfigure.services.ClienteService;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.strategies.contracts.ClienteCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PesquisarClienteCase extends ClienteCase {

    @Autowired
    ClienteService clienteService;

    @Override
    public ClienteResponseDto executar(Object objeto) {
        String mensagem = "";
        List<ClienteDto> clientes = new ArrayList<>();
        boolean processamentoComSucesso = false;

        String codigoCliente = (String) objeto;

        try{
            ClienteModel.validarDadosParaPesquisa(codigoCliente);
            var cliente = clienteService.pesquisarPorId(codigoCliente);
            clientes = criarListaRetorno(cliente);
            processamentoComSucesso = true;
            mensagem = "processamento efetuado com sucesso";
            if(clientes.isEmpty()){
                mensagem = "cliente nao encontrado";
            }
        }
        catch (ClienteException e){
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(e.getMessage());
        }

        var result = new ClienteResponseDto(true, mensagem, clientes);
        return result;
    }
}
