package br.com.lts.desafio.cadcli.strategies.cases.cliente;

import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.cadcli.models.entities.ClienteModel;
import br.com.lts.desafio.cadcli.models.exceptions.ClienteException;
import br.com.lts.desafio.cadcli.services.ClienteService;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.contracts.ClienteCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ExcluirClienteCase extends ClienteCase {

    @Autowired
    ClienteService clienteService;

    @Override
    public ClienteResponseDto executar(Object objeto) {
        String mensagem = "";
        List<ClienteDto> clientes = new ArrayList<>();
        boolean processamentoComSucesso = false;

        String codigoCliente = (String) objeto;

        try{
            ClienteModel.validarDadosParaExclusao(codigoCliente);
            var cliente = clienteService.excluir(codigoCliente);
            clientes = criarListaRetorno(cliente);
            processamentoComSucesso = true;
            mensagem = "processamento efetuado com sucesso";
        }
        catch (ClienteException e){
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(e.getMessage());
        }
        catch (NoSuchElementException e) {
            mensagem = "Cliente: " + codigoCliente + " nao localizado";
            ConsoleLogService.logMessage("[ClienteService][pesquisarPorId] - Cliente: " + codigoCliente + " não localizado");
            processamentoComSucesso = false;
        }
        catch (Exception e){
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(e.getMessage());
            processamentoComSucesso = false;
        }

        var result = new ClienteResponseDto(processamentoComSucesso, mensagem, clientes);
        return result;
    }
}
