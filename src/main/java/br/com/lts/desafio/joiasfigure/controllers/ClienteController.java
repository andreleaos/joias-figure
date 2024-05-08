package br.com.lts.desafio.joiasfigure.controllers;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.models.dtos.responses.ClienteResponseDto;
import br.com.lts.desafio.joiasfigure.models.enums.ClienteStrategyEnum;
import br.com.lts.desafio.joiasfigure.services.logs.ConsoleLogService;
import br.com.lts.desafio.joiasfigure.strategies.ClienteStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteStrategy clienteStrategy;

    @GetMapping("/info")
    public ResponseEntity<String> info(){
        return ResponseEntity.status(HttpStatus.OK).body("Api de cadastro de clientes");
    }

    @GetMapping("/listar")
    public ResponseEntity<ClienteResponseDto> listar(){
        ClienteResponseDto result = clienteStrategy.executar(ClienteStrategyEnum.LISTAR_CLIENTE, null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ClienteResponseDto> pesquisar(@PathVariable String id){
        ConsoleLogService.logMessage("[ClienteController][pesquisar] - Pesquisa solicitada para o cliente: " + id);
        var result = clienteStrategy.executar(ClienteStrategyEnum.PESQUISAR_CLIENTE, id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<ClienteResponseDto> excluir(@PathVariable String id){
        var result = clienteStrategy.executar(ClienteStrategyEnum.EXCLUIR_CLIENTE, id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteResponseDto> cadastrar(@RequestBody ClienteDto clienteDto){
        var result = clienteStrategy.executar(ClienteStrategyEnum.CADASTRAR_CLIENTE, clienteDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ClienteResponseDto> atualizar(@RequestBody ClienteDto clienteDto){
        var result = clienteStrategy.executar(ClienteStrategyEnum.ATUALIZAR_CLIENTE, clienteDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
