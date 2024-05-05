package br.com.lts.desafio.cadcli.containers;

import br.com.lts.desafio.cadcli.models.dtos.requests.ClienteDto;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cadastrocliente")
public class CadastroClienteController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job cadastroClienteJob;

    @Autowired
    private ClienteDataHolder clienteDataHolder;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarHandle(@RequestBody ClienteDto clienteDto) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        clienteDataHolder.setCliente(clienteDto);
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(cadastroClienteJob, jobParameters);
        return ResponseEntity.ok("Cliente recebido e processamento de cadastro iniciado");
    }
}
