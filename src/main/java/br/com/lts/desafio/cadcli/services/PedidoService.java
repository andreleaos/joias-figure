package br.com.lts.desafio.cadcli.services;

import br.com.lts.desafio.cadcli.models.dtos.requests.CriacaoPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.ItemPedidoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.ItemPedidoProdutoDto;
import br.com.lts.desafio.cadcli.models.dtos.requests.PedidoDto;
import br.com.lts.desafio.cadcli.repositories.ItemPedidoRepository;
import br.com.lts.desafio.cadcli.repositories.PedidoRepository;
import br.com.lts.desafio.cadcli.repositories.ProdutoRepository;
import br.com.lts.desafio.cadcli.services.logs.ConsoleLogService;
import br.com.lts.desafio.cadcli.utils.ItemPedidoConversor;
import br.com.lts.desafio.cadcli.utils.PedidoConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public CriacaoPedidoDto criarPedido(PedidoDto pedidoDto, List<ItemPedidoDto> itensPedidoDto) {
        var pedido = PedidoConversor.converterParaModel(pedidoDto);
        var itensPedidoCadastrado = new ArrayList<ItemPedidoDto>();

        var pedidoCadastrado = pedidoRepository.save(pedido);
        var itensPedido = ItemPedidoConversor.converterParaListModel(itensPedidoDto);

        for (var item : itensPedido) {
            item.setCodigoPedido(pedidoCadastrado.getCodigoPedido());
            var itemPedidoCadastrado = itemPedidoRepository.save(item);

            var itemPedidoDto = ItemPedidoConversor.converterParaDto(itemPedidoCadastrado);
            itensPedidoCadastrado.add(itemPedidoDto);
        }

        var pedidoCriado = PedidoConversor.converterParaDto(pedidoCadastrado);
        var cricaoPedidoDto = new CriacaoPedidoDto(pedidoCriado, itensPedidoCadastrado);
        return cricaoPedidoDto;
    }

    public PedidoDto pesquisarPedidoPorId(Long id) {
        var pedido = pedidoRepository.findById(id).get();
        var pedidoDto = PedidoConversor.converterParaDto(pedido);
        return pedidoDto;
    }

    public List<PedidoDto> listarPedidos() {
        var pedidos = pedidoRepository.findAll();
        var pedidosDto = PedidoConversor.converterParaListDto(pedidos);
        return pedidosDto;
    }

    public List<ItemPedidoProdutoDto> PesquisarItensPedidoProduto(List<ItemPedidoDto> itensPedidoDto){
        List<ItemPedidoProdutoDto> itensPedidoProdutoDto = new ArrayList<>();

        for (var itemPedido : itensPedidoDto) {
            var produtoItem = produtoRepository.findById(itemPedido.getCodigoProduto()).get();

            var itensPedidoProduto = new ItemPedidoProdutoDto(produtoItem.getPrecoProduto(), itemPedido.getQuantidade());
            itensPedidoProdutoDto.add(itensPedidoProduto);
        }

        return itensPedidoProdutoDto;
    }

    public List<ItemPedidoDto> pesquisarItensPedidoPorId(Long id) {
        var itensPedido = itemPedidoRepository.findByCodigoPedido(id);
        var itensPedidoDto = ItemPedidoConversor.converterParaListDto(itensPedido);
        return itensPedidoDto;
    }

    public void atualizarStatusPedido(PedidoDto pedidoDto) {
        var pedido = PedidoConversor.converterParaModel(pedidoDto);
        pedidoRepository.save(pedido);
    }
}
