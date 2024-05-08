package br.com.lts.desafio.joiasfigure.strategies.cases.relatorio;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ItemPedidoDto;
import br.com.lts.desafio.joiasfigure.models.dtos.requests.ItemPedidoRelatorioDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.RelatorioResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.StatusPedidoEnum;
import br.com.lts.desafio.joiasfigure.services.ClienteService;
import br.com.lts.desafio.joiasfigure.services.PedidoService;
import br.com.lts.desafio.joiasfigure.services.ProdutoService;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.strategies.contracts.RelatorioCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioPedidoCase extends RelatorioCase {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProdutoService produtoService;


    @Override
    public List<RelatorioResponseDto> executar(Object objeto) {

        List<RelatorioResponseDto> relatorioResponseDto = new ArrayList<RelatorioResponseDto>();

        try{
            var pedidos = pedidoService.listarPedidos();

            for (var pedido : pedidos){

                RelatorioResponseDto itemRelatorioDto = new RelatorioResponseDto();

                var cliente = clienteService.pesquisarPorId(pedido.getCodigoCliente());
                var itensPedido = pedidoService.pesquisarItensPedidoPorId(pedido.getCodigoPedido());

                itemRelatorioDto.setCodigoCliente(cliente.getCodigoCliente());
                itemRelatorioDto.setNomeCliente(cliente.getNomeCliente());

                itemRelatorioDto.setCodigoPedido(pedido.getCodigoPedido());
                itemRelatorioDto.setStatusPedido(StatusPedidoEnum
                        .getEnumById(pedido.getCodigoStatusPedido())
                        .getStatus());

                itemRelatorioDto.setValorTotalPedido(pedido.getValorTotalPedido());

                List<ItemPedidoRelatorioDto> itensPedidoRelatorio = new ArrayList<>();

                for (ItemPedidoDto item : itensPedido){
                    ItemPedidoRelatorioDto itemRelatorioItem = new ItemPedidoRelatorioDto();

                    var produtoDto = produtoService.pesquisarPorId(item.getCodigoProduto());

                    itemRelatorioItem.setCodigoItemPedido(item.getCodigoItemPedido());
                    itemRelatorioItem.setQuantidade(item.getQuantidade());
                    itemRelatorioItem.setCodigoProduto(item.getCodigoProduto());
                    itemRelatorioItem.setNomeProduto(produtoDto.getNomeProduto());
                    itemRelatorioItem.setPrecoProduto(produtoDto.getPrecoProduto());

                    itensPedidoRelatorio.add(itemRelatorioItem);
                }

                itemRelatorioDto.setItensPedido(itensPedidoRelatorio);
                relatorioResponseDto.add(itemRelatorioDto);
            }
        }
        catch (Exception ex){
            ConsoleLogService.logMessage(ex.getMessage());
            throw ex;
        }

        return relatorioResponseDto;
    }
}
