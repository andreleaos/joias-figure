package br.com.lts.desafio.joiasfigure.strategies.cases.cliente;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.joiasfigure.models.entities.ClienteModel;
import br.com.lts.desafio.joiasfigure.models.exceptions.ClienteException;
import br.com.lts.desafio.joiasfigure.services.ClienteService;
import br.com.lts.desafio.joiasfigure.services.GerenciadorArquivoService;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.strategies.contracts.ClienteCase;
import br.com.lts.desafio.joiasfigure.utils.ClienteConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtualizarClienteCase extends ClienteCase {

    @Autowired
    ClienteService clienteService;

    @Autowired
    GerenciadorArquivoService gerenciadorArquivoService;

    @Override
    public ClienteResponseDto executar(Object objeto) {
        String mensagem = "";
        List<ClienteDto> clientes = new ArrayList<>();
        boolean processamentoComSucesso = false;

        ClienteDto clienteDto = (ClienteDto) objeto;
        ClienteModel clienteValidacao = ClienteConversor.converterParaModel(clienteDto);

        try{
            clienteValidacao.validarDadosMinimosParaAtualizacao();
            var cliente = clienteService.atualizar(clienteDto);
            gerenciadorArquivoService.gravarClienteAtualizado(cliente);
            clientes = criarListaRetorno(cliente);
            processamentoComSucesso = true;
            mensagem = "processamento efetuado com sucesso";
        }
        catch (IllegalArgumentException e){
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(mensagem);
        }
        catch (ClienteException e){
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(mensagem);
        }

        var result = new ClienteResponseDto(processamentoComSucesso, mensagem, clientes);
        return result;
    }
}
