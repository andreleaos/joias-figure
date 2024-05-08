package br.com.lts.desafio.joiasfigure.unitTests;

import br.com.lts.desafio.joiasfigure.mocks.ClienteDtoMock;
import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.utils.JsonConversor;
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
