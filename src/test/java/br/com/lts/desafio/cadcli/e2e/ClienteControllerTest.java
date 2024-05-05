package br.com.lts.desafio.cadcli.e2e;

import br.com.lts.desafio.cadcli.controllers.ClienteController;
import br.com.lts.desafio.cadcli.mocks.ClienteDtoMock;
import br.com.lts.desafio.cadcli.mocks.ClienteResponseDtoMock;
import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.cadcli.models.enums.ClienteStrategyEnum;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.ClienteStrategy;
import br.com.lts.desafio.cadcli.utils.JsonConversor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteStrategy clienteStrategy;

    @Test
    public void cadastrarCliente() throws Exception {

        ClienteResponseDto response = ClienteResponseDtoMock.getClienteResponseDto();
        ClienteDto clienteDto = response.getClientes().get(0);
        ClienteStrategyEnum acao = ClienteStrategyEnum.CADASTRAR_CLIENTE;
        String content = JsonConversor.convertToJson(clienteDto);
        String respostaEsperada = response.getMensagemRetorno();

        given(clienteStrategy.executar(acao, any(ClienteDto.class))).willReturn(response);

        mockMvc.perform(MockMvcRequestBuilders
            .post("/api/cliente/cadastrar")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content))
            .andExpect(status().isOk());
    }
}
