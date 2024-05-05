package br.com.lts.desafio.cadcli.strategies.cases.pedido;

import br.com.lts.desafio.cadcli.models.dtos.requests.CriacaoPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.ItemPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.PedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.PedidoResponseDto;
import br.com.lts.desafio.cadcli.services.ClienteService;
import br.com.lts.desafio.cadcli.services.PedidoService;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.contracts.PedidoCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarPedidoCase extends PedidoCase {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public PedidoResponseDto executar(Object objeto) {
        String mensagem = "";
        boolean processamentoComSucesso = false;
        List<CriacaoPedidoDto> criacaoPedidoDtos = new ArrayList<>();

        try{
            var pedidosDto = pedidoService.listarPedidos();

            for(PedidoDto pedidoDto : pedidosDto){
                var itensPedidoDto = pedidoService.pesquisarItensPedidoPorId(pedidoDto.getCodigoPedido());
                CriacaoPedidoDto itemCriacaoPedidoDto = new CriacaoPedidoDto(pedidoDto, itensPedidoDto);
                criacaoPedidoDtos.add(itemCriacaoPedidoDto);

                ConsoleLogService.logMessage(String.format("Info do Pedido: codigoPedido: %s, codigoCliente: %s",
                        pedidoDto.getCodigoPedido(), pedidoDto.getCodigoCliente()));
            }

            mensagem = "Processamento efetuado com sucesso";
            processamentoComSucesso = true;
        }
        catch (Exception ex) {
            mensagem = ex.getMessage();
            ConsoleLogService.logMessage(mensagem);
        }

        var result = new PedidoResponseDto(processamentoComSucesso, mensagem, criacaoPedidoDtos);
        return result;
    }
}
