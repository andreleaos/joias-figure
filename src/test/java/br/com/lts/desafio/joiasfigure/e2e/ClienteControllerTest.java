package br.com.lts.desafio.joiasfigure.e2e;

import br.com.lts.desafio.joiasfigure.controllers.ClienteController;
import br.com.lts.desafio.joiasfigure.mocks.ClienteResponseDtoMock;
import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.ClienteStrategyEnum;
import br.com.lts.desafio.joiasfigure.strategies.ClienteStrategy;
import br.com.lts.desafio.joiasfigure.utils.JsonConversor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
