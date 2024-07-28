package dev.elsboo.founding;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static dev.elsboo.founding.batch.DailyJobConfig.DAILY_JOB;

@EnableBatchProcessing
@SpringBootApplication
public class FoundingApplication implements ApplicationRunner {

    private final JobLauncher jobLauncher;
    private final Job job;

    public FoundingApplication(JobLauncher jobLauncher, @Qualifier(DAILY_JOB) Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    public static void main(String[] args) {
        SpringApplication.run(FoundingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        jobLauncher.run(job, new JobParametersBuilder().addString("timestamp", LocalDateTime.now().toString()).toJobParameters());
    }
}
