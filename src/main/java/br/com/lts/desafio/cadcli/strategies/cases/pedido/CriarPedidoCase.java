package br.com.lts.desafio.cadcli.strategies.cases.pedido;

import br.com.lts.desafio.cadcli.models.dtos.requests.CriacaoPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.ItemPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.PedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.responses.PedidoResponseDto;
import br.com.lts.desafio.cadcli.models.entities.ItemPedidoModel;
import br.com.lts.desafio.cadcli.models.enums.StatusPedidoEnum;
import br.com.lts.desafio.cadcli.models.exceptions.PedidoException;
import br.com.lts.desafio.cadcli.services.ClienteService;
import br.com.lts.desafio.cadcli.services.PedidoService;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.strategies.contracts.PedidoCase;
import br.com.lts.desafio.cadcli.utils.ItemPedidoConversor;
import br.com.lts.desafio.cadcli.utils.PedidoConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CriarPedidoCase extends PedidoCase {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public PedidoResponseDto executar(Object objeto) {
        String mensagem = "";
        boolean processamentoComSucesso = false;
        List<CriacaoPedidoDto> criacaoPedidoDtos = new ArrayList<>();
        PedidoDto pedidoCriado = new PedidoDto();
        List<ItemPedidoDto> itensPedido = new ArrayList<>();

        var criacaoPedidoDto = (CriacaoPedidoDto) objeto;

        var pedidoDto = criacaoPedidoDto.getPedido();
        var itensPedidoDto = criacaoPedidoDto.getItensPedido();

        var pedidoValidacao = PedidoConversor.converterParaModel(pedidoDto);
        var itensPedidoValidacao = ItemPedidoConversor.converterParaListModel(itensPedidoDto);

        try {

            var clientePesquisado = clienteService.pesquisarPorId(pedidoDto.getCodigoCliente());
            if (clientePesquisado == null) {
                throw new PedidoException("Cliente não localizado, ele é obrigatorio para seguir com a criacao do pedido");
            }

            for (ItemPedidoModel itemPedido : itensPedidoValidacao) {
                itemPedido.validar();
            }

            var itensPedidoProduto = pedidoService.PesquisarItensPedidoProduto(itensPedidoDto);

            ConsoleLogService.logMessage(String.format("[CriarPedidoCase][executar] - Qtde Itens Pedido: %s", itensPedidoProduto.size()));
            ConsoleLogService.logMessage(String.format("[CriarPedidoCase][executar] - valor: %s, qtde: %s",
                    itensPedidoProduto.get(0).getQuantidade(), itensPedidoProduto.get(0).getValor()));

            pedidoValidacao.calcularValorTotal(itensPedidoProduto);
            pedidoValidacao.validarDadosParaCadastro();

            ConsoleLogService.logMessage(String.format("[CriarPedidoCase][executar] - Valor calculado: %s",
                    pedidoValidacao.getValorTotalPedido()));

            pedidoDto.setCodigoStatusPedido(StatusPedidoEnum.NOVO.getId());
            pedidoDto.setDataCadastro(LocalDate.now());
            pedidoDto.setDataAtualizacao(LocalDate.now());
            pedidoDto.setValorTotalPedido(pedidoValidacao.getValorTotalPedido());

            ConsoleLogService.logMessage("[CriarPedidoCase][executar] - Dados validados e configurados para a criacao de pedido");

            var pedidoCriadoComItens = pedidoService.criarPedido(pedidoDto, itensPedidoDto);
            pedidoCriado = pedidoCriadoComItens.getPedido();
            itensPedido = pedidoCriadoComItens.getItensPedido();

            ConsoleLogService.logMessage("[CriarPedidoCase][executar] - Pedido criado com sucesso");

            CriacaoPedidoDto itemCriacaoPedidoDto = new CriacaoPedidoDto(pedidoCriado, itensPedido);
            criacaoPedidoDtos.add(itemCriacaoPedidoDto);
            mensagem = "pedido criado com sucesso";
            processamentoComSucesso = true;
        } catch (PedidoException e) {
            mensagem = e.getMessage();
            ConsoleLogService.logMessage(mensagem);
            processamentoComSucesso = false;
        }

        var result = new PedidoResponseDto(processamentoComSucesso, mensagem, criacaoPedidoDtos);
        return result;
    }
}
