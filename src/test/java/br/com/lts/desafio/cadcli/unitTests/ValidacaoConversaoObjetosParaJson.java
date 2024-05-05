package br.com.lts.desafio.cadcli.unitTests;

import br.com.lts.desafio.cadcli.mocks.ClienteDtoMock;
import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.utils.JsonConversor;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidacaoConversaoObjetosParaJson {

    @Test
    public void validarAConversaoDeObjetosClientesParaJson() throws JsonProcessingException {

        ClienteDto clienteDto = ClienteDtoMock.getClienteDtoComDocumentos();

        var clienteDtoJson = JsonConversor.convertToJson(clienteDto);
        ConsoleLogService.logMessage(clienteDtoJson);
        assertThat(clienteDtoJson).contains(clienteDto.getNomeCliente());
    }
}
