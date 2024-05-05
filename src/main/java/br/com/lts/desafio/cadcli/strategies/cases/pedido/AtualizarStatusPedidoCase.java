package br.com.lts.desafio.cadcli.strategies.cases.pedido;

import br.com.lts.desafio.cadcli.models.dtos.requests.AtualizacaoPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.CriacaoPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.ItemPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.PedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.PedidoResponseDto;
import br.com.lts.desafio.cadcli.models.exceptions.PedidoException;
import br.com.lts.desafio.cadcli.services.PedidoService;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.PedidoStrategy;
import br.com.lts.desafio.cadcli.strategies.contracts.PedidoCase;
import br.com.lts.desafio.cadcli.utils.PedidoConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AtualizarStatusPedidoCase extends PedidoCase {

    @Autowired
    private PedidoService pedidoService;

    @Override
    public PedidoResponseDto executar(Object objeto) {
        String mensagem = "";
        boolean processamentoComSucesso = false;
        List<CriacaoPedidoDto> criacaoPedidoDtos = new ArrayList<>();
        PedidoDto pedidoAtualizado = new PedidoDto();
        List<ItemPedidoDto> itensPedido = new ArrayList<>();

        var atualizacaoPedido = (AtualizacaoPedidoDto) objeto;
        var pedidoParaAtualizacao = pedidoService.pesquisarPedidoPorId(atualizacaoPedido.getCodigoPedido());

        pedidoParaAtualizacao.setCodigoStatusPedido(atualizacaoPedido.getCodigoStatusPedido());
        pedidoParaAtualizacao.setDataAtualizacao(LocalDate.now());

        try{
            var pedidoValidacao = PedidoConversor.converterParaModel(pedidoParaAtualizacao);
            pedidoValidacao.validarDadosParaAtualizacao();
            pedidoService.atualizarStatusPedido(pedidoParaAtualizacao);

            pedidoAtualizado = PedidoConversor.converterParaDto(pedidoValidacao);
            itensPedido = pedidoService.pesquisarItensPedidoPorId(pedidoAtualizado.getCodigoPedido());

            CriacaoPedidoDto pedidoDto = new CriacaoPedidoDto(pedidoAtualizado, itensPedido);
            criacaoPedidoDtos.add(pedidoDto);

            mensagem = "atualizacao efetuada com sucesso";
            processamentoComSucesso = true;
        }
        catch (PedidoException ex){
            mensagem = ex.getMessage();
            ConsoleLogService.logMessage(mensagem);
        }

        var result = new PedidoResponseDto(processamentoComSucesso, mensagem, criacaoPedidoDtos);
        return result;
    }
}
