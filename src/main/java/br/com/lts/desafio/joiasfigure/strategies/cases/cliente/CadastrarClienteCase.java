package br.com.lts.desafio.joiasfigure.strategies.cases.cliente;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.joiasfigure.models.entities.ClienteModel;
import br.com.lts.desafio.joiasfigure.models.exceptions.ClienteException;
import br.com.lts.desafio.joiasfigure.services.ClienteService;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.strategies.contracts.ClienteCase;
import br.com.lts.desafio.joiasfigure.utils.ClienteConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastrarClienteCase extends ClienteCase {

    @Autowired
    ClienteService clienteService;

    @Override
    public ClienteResponseDto executar(Object objeto) {
        String mensagem = "";
        List<ClienteDto> clientes = new ArrayList<>();
        boolean processamentoComSucesso = false;

        ClienteDto clienteDto = (ClienteDto) objeto;
        clienteDto.setClienteEstaAtivo(true);
        ClienteModel clienteValidacao = ClienteConversor.converterParaModel(clienteDto);

        try{
            clienteValidacao.validarDadosMinimosParaCadastro();
            var cliente = clienteService.salvar(clienteDto);
            clientes = criarListaRetorno(cliente);
            processamentoComSucesso = true;
            mensagem = "processamento efetuado com sucesso";
        }
        catch (ClienteException e){
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(e.getMessage());
        }

        var result = new ClienteResponseDto(processamentoComSucesso, mensagem, clientes);
        return result;
    }
}
