package br.com.lts.desafio.cadcli.lambdas;

import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteRequest;
import br.com.lts.desafio.cadcli.models.enums.ClienteStrategyEnum;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.ClienteStrategy;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteHandler implements RequestHandler<ClienteRequest,String> {

    @Autowired
    ClienteStrategy clienteStrategy;

    @Override
    public String handleRequest(ClienteRequest request, Context context) {

        String mensagem = "";

        try {
            ClienteDto clienteDto = request.getCliente();
            var result = clienteStrategy.executar(ClienteStrategyEnum.CADASTRAR_CLIENTE, clienteDto);
            mensagem = String.format("Cadastro do cliente %s efetuado com sucesso: ", result.getClientes().get(0).getCodigoCliente());
        } catch (Exception ex) {
            mensagem = String.format("Falha na requisicao CadastrarCliente: %s", ex.getMessage());
            ConsoleLogService.logMessage(mensagem);
            return mensagem;
        }

        return mensagem;
    }
}
