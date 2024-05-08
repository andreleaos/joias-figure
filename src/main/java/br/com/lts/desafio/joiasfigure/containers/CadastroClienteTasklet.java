package br.com.lts.desafio.joiasfigure.containers;

import br.com.lts.desafio.joiasfigure.models.dtos.requests.ClienteDto;
import br.com.lts.desafio.joiasfigure.models.enums.ClienteStrategyEnum;
import br.com.lts.desafio.joiasfigure.strategies.ClienteStrategy;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteTasklet implements Tasklet {

    @Autowired
    ClienteStrategy clienteStrategy;

    @Autowired
    ClienteDataHolder clienteDataHolder;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        ClienteDto clienteDto = clienteDataHolder.getCliente();
        if(clienteDto == null) {
            clienteStrategy.executar(ClienteStrategyEnum.CADASTRAR_CLIENTE, clienteDto);
        }
        return RepeatStatus.FINISHED;
    }
}
