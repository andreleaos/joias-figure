package br.com.lts.desafio.joiasfigure.containers;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class CadastroClienteBatchConfig {

    @Bean
    public Job cadastroClienteJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("cadastroClienteJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step cadastroClienteStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("cadastroClienteStep", jobRepository)
                .tasklet(new CadastroClienteTasklet(), transactionManager).build();
    }
}
