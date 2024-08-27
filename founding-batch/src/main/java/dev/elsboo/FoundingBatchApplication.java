package dev.elsboo;

import dev.elsboo.coupang.CoupangClientConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import static dev.elsboo.foundingbatch.DailyJobConfig.DAILY_JOB;

@SpringBootApplication
@EnableBatchProcessing
@Slf4j
public class FoundingBatchApplication implements ApplicationRunner {

    private final JobLauncher jobLauncher;
    private final Job job;

    public FoundingBatchApplication(JobLauncher jobLauncher, @Qualifier(DAILY_JOB) Job job, CoupangClientConfiguration coupangClientConfiguration) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    public static void main(String[] args) {
        SpringApplication.run(FoundingBatchApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        jobLauncher.run(job, new JobParametersBuilder().addString("timestamp", LocalDateTime.now().toString()).toJobParameters());
    }
}
