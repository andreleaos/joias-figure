package br.com.lts.desafio.cadcli.strategies.cases.pedido;

import br.com.lts.desafio.cadcli.models.dtos.requests.CriacaoPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.ItemPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.PedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.PedidoResponseDto;
import br.com.lts.desafio.cadcli.models.entities.PedidoModel;
import br.com.lts.desafio.cadcli.models.exceptions.PedidoException;
import br.com.lts.desafio.cadcli.services.ClienteService;
import br.com.lts.desafio.cadcli.services.PedidoService;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.contracts.PedidoCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PesquisarPedidoCase extends PedidoCase {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public PedidoResponseDto executar(Object objeto) {
        String mensagem = "";
        boolean processamentoComSucesso = false;

        List<CriacaoPedidoDto> criacaoPedidoDtos = new ArrayList<>();
        PedidoDto pedidoDto = null;
        List<ItemPedidoDto> itensPedidoDto = new ArrayList<>();

        long codigoPedido = Long.parseLong((String) objeto);

        try{
            PedidoModel.validarDadosParaPesquisa(codigoPedido);
            pedidoDto = pedidoService.pesquisarPedidoPorId(codigoPedido);
            itensPedidoDto = pedidoService.pesquisarItensPedidoPorId(codigoPedido);

            ConsoleLogService.logMessage(String.format("Info do Pedido: codigoPedido: %s, codigoCliente: %s",
                    pedidoDto.getCodigoPedido(), pedidoDto.getCodigoCliente()));

            CriacaoPedidoDto itemCriacaoPedidoDto = new CriacaoPedidoDto(pedidoDto, itensPedidoDto);
            criacaoPedidoDtos.add(itemCriacaoPedidoDto);

            mensagem = "pesquisa efetuada com sucesso";
            processamentoComSucesso = true;
        }
        catch (PedidoException ex){
            mensagem = ex.getMessage();
            ConsoleLogService.logMessage(mensagem);
        }
        catch (Exception ex){
            mensagem = ex.getMessage();
            ConsoleLogService.logMessage(mensagem);
        }

        PedidoResponseDto result = new PedidoResponseDto(processamentoComSucesso, mensagem, criacaoPedidoDtos);
        return result;
    }
}
