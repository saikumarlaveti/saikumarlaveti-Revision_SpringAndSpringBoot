package com.Config;

import javax.sql.DataSource;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;

import org.springframework.batch.infrastructure.item.database.JdbcBatchItemWriter;
import org.springframework.batch.infrastructure.item.database.builder.JdbcBatchItemWriterBuilder;

import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.Listener.JobMonitoringListener;
import com.Processor.EmployeeItemProcessor;
import com.mode.Employee;


@Configuration
public class BatchConfig {


    @Autowired
    private JobMonitoringListener listener;

    @Autowired
    private EmployeeItemProcessor processor;

    @Autowired
    private DataSource ds;


    // reader (version3)

    @Bean(name = "reader")
    public FlatFileItemReader<Employee> createReader() {

        return new FlatFileItemReaderBuilder<Employee>()

                .name("file-reader")

                .resource(
                        new ClassPathResource("EmployeesInfo.csv")
                )

                .delimited()
                .delimiter(",")

                .names(
                        "empno",
                        "empname",
                        "empaddrs",
                        "salary"
                )

                .targetType(Employee.class)

                .build();
    }


    // writer (version2)

    @Bean(name = "writer")
    public JdbcBatchItemWriter<Employee> createWriter() {

        return new JdbcBatchItemWriterBuilder<Employee>()

                .dataSource(ds)

                .sql("""
                    INSERT INTO EMPLOYEE
                    (empno, empname, empaddrs, salary, grossSalary, netSalary)
                    VALUES
                    (:empno, :empname, :empaddrs, :salary, :grossSalary, :netSalary)
                    """)

                .beanMapped()

                .build();
    }


    // step preparation

    @Bean(name = "step1")
    public Step createStep1(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager) {

        return new StepBuilder(
                "step1",
                jobRepository
        )

                .<Employee, Employee>chunk(
                        3,
                        transactionManager
                )

                .reader(createReader())

                .writer(createWriter())

                .processor(processor)

                .build();
    }


    // job preparation

    @Bean(name = "job1")
    public Job createJob1(
            JobRepository jobRepository,
            Step step1) {

        return new JobBuilder(
                "job1",
                jobRepository
        )

                .listener(listener)

                .incrementer(
                        new RunIdIncrementer()
                )

                .start(step1)

                .build();
    }

}