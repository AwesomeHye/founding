package dev.elsboo.founding.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@RequiredArgsConstructor
public class DailyJobConfig {
    @Bean
    public Job dailyJob(JobRepository jobRepository, Step dailyStep) {
        return new JobBuilder("dailyJob", jobRepository)
            .start(dailyStep)
            .build();
    }

    @Bean
    private Step dailyStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("dailyStep", jobRepository)
            .<String, String>chunk(1, transactionManager)
            .reader(new ApiReader())
            .writer()
            .build();
    }
}
