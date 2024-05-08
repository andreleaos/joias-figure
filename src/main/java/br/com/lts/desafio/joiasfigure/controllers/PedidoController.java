package br.com.lts.desafio.joiasfigure.controllers;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.AtualizacaoPedidoDto;
import br.com.lts.desafio.joiasfigure.models.dtos.requests.CriacaoPedidoDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.PedidoResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.PedidoStrategyEnum;
import br.com.lts.desafio.joiasfigure.strategies.PedidoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    @Autowired
    private PedidoStrategy pedidoStrategy;

    @GetMapping("/info")
    public ResponseEntity<String> info(){
        return ResponseEntity.status(HttpStatus.OK).body("Api de pedidos");
    }

    @PostMapping("/criar")
    public ResponseEntity<PedidoResponseDto> criar(@RequestBody CriacaoPedidoDto criacaoPedidoDto){
        var result = pedidoStrategy.executar(PedidoStrategyEnum.CRIAR_PEDIDO, criacaoPedidoDto);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<PedidoResponseDto> atualizar(@RequestBody AtualizacaoPedidoDto atualizacaoPedidoDto) {
        var result = pedidoStrategy.executar(PedidoStrategyEnum.ATUALIZAR_STATUS_PEDIDO, atualizacaoPedidoDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/listar")
    public ResponseEntity<PedidoResponseDto> listar() {
        var result = pedidoStrategy.executar(PedidoStrategyEnum.LISTAR_PEDIDOS, null);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<PedidoResponseDto> pesquisar(@PathVariable String id) {
        var result = pedidoStrategy.executar(PedidoStrategyEnum.PESQUISAR_PEDIDO, id);
        return ResponseEntity.ok().body(result);
    }

}
