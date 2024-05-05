package br.com.lts.desafio.cadcli.controllers;

import br.com.lts.desafio.cadcli.models.dtos.responses.RelatorioResponseDto;
import br.com.lts.desafio.cadcli.models.enums.RelatorioStrategyEnum;
import br.com.lts.desafio.cadcli.strategies.RelatorioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/relatorio")
public class RelatorioController {

    @Autowired
    RelatorioStrategy relatorioStrategy;

    @GetMapping("/executar")
    public ResponseEntity<List<RelatorioResponseDto>> executar(){
        var result = relatorioStrategy.executar(RelatorioStrategyEnum.RELATORIO_PEDIDOS, null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
