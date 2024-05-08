package br.com.lts.desafio.joiasfigure.controllers;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ProdutoDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ProdutoResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.ProdutoStrategyEnum;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.strategies.ProdutoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoStrategy produtoStrategy;

    @GetMapping("/info")
    public ResponseEntity<String> info(){
        return ResponseEntity.status(HttpStatus.OK).body("Api de cadastro de produtos");
    }

    @GetMapping("/listar")
    public ResponseEntity<ProdutoResponseDto> listar(){
        ProdutoResponseDto result = produtoStrategy.executar(ProdutoStrategyEnum.LISTAR_PRODUTO, null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ProdutoResponseDto> pesquisar(@PathVariable String id){
        ConsoleLogService.logMessage("[ClienteController][pesquisar] - Pesquisa solicitada para o cliente: " + id);
        var result = produtoStrategy.executar(ProdutoStrategyEnum.PESQUISAR_PRODUTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<ProdutoResponseDto> excluir(@PathVariable String id){
        var result = produtoStrategy.executar(ProdutoStrategyEnum.EXCLUIR_PRODUTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ProdutoResponseDto> cadastrar(@RequestBody ProdutoDto produtoDto){
        var result = produtoStrategy.executar(ProdutoStrategyEnum.CADASTRAR_PRODUTO, produtoDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ProdutoResponseDto> atualizar(@RequestBody ProdutoDto produtoDto){
        var result = produtoStrategy.executar(ProdutoStrategyEnum.ATUALIZAR_PRODUTO, produtoDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
