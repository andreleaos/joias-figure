package br.com.lts.desafio.cadcli.strategies;

import br.com.lts.desafio.cadcli.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.cadcli.models.enums.ClienteStrategyEnum;
import br.com.lts.desafio.cadcli.strategies.cases.cliente.*;
import br.com.lts.desafio.cadcli.strategies.contexts.ClienteContext;
import br.com.lts.desafio.cadcli.strategies.contracts.IClienteStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteStrategy implements IClienteStrategy {

    @Autowired
    CadastrarClienteCase cadastrarClienteCase;

    @Autowired
    AtualizarClienteCase atualizarClienteCase;

    @Autowired
    ExcluirClienteCase excluirClienteCase;

    @Autowired
    ListarClienteCase listarClienteCase;

    @Autowired
    PesquisarClienteCase pesquisarClienteCase;

    @Autowired
    ClienteContext clienteContext;

    public ClienteResponseDto executar(ClienteStrategyEnum strategyEnum, Object objeto) {

        switch (strategyEnum) {
            case CADASTRAR_CLIENTE:
                clienteContext.setCase(cadastrarClienteCase);
                break;

            case ATUALIZAR_CLIENTE:
                clienteContext.setCase(atualizarClienteCase);
                break;

            case EXCLUIR_CLIENTE:
                clienteContext.setCase(excluirClienteCase);
                break;

            case LISTAR_CLIENTE:
                clienteContext.setCase(listarClienteCase);
                break;

            case PESQUISAR_CLIENTE:
                clienteContext.setCase(pesquisarClienteCase);
                break;

            default:
                clienteContext.setCase(listarClienteCase);
                break;
        }

        var result = clienteContext.executar(objeto);
        return result;
    }
}
