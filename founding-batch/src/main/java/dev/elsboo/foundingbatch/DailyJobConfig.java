package dev.elsboo.foundingbatch;

import dev.elsboo.founding.client.coupang.BestCategoryResponse;
import dev.elsboo.founding.db.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class DailyJobConfig {

    public static final String DAILY_JOB = "dailyJob";

    @Bean
    public Job dailyJob(JobRepository jobRepository, Step dailyStep) {
        return new JobBuilder(DAILY_JOB, jobRepository)
            .start(dailyStep)
            .build();
    }

    @Bean
    public Step dailyStep(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager,
                          ApiReader apiReader, DbWriter dbWriter
    ) {
        return new StepBuilder("dailyStep", jobRepository)
            .<List<BestCategoryResponse>, List<Product>>chunk(1, transactionManager)
            .reader(apiReader)
            .processor(new ApiToDbProcessor())
            .writer(dbWriter)
            .build();
    }
}
