package com.config;

import javax.sql.DataSource;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.batch.infrastructure.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.Listener.JobMonitoringListener;
import com.Model.Employee;

import jakarta.annotation.PostConstruct;



@Configuration
public class BatchConfig {

    // --------------------------------------------------
    // ITEM READER
    // --------------------------------------------------

	@Bean
	public ItemReader<Employee> reader() {

	    return new FlatFileItemReaderBuilder<Employee>()
	            .name("employeeReader")
	            .resource(new ClassPathResource("employees.csv"))
	            .delimited()
	            .delimiter(",")   // ADD THIS
	            .names("id", "name", "age", "salary")
	            .fieldSetMapper(fieldSet -> {

	                Employee employee = new Employee();

	                employee.setId(
	                        fieldSet.readInt("id")
	                );

	                employee.setName(
	                        fieldSet.readString("name")
	                );

	                employee.setAge(
	                        fieldSet.readInt("age")
	                );

	                employee.setSalary(
	                        fieldSet.readDouble("salary")
	                );

	                return employee;
	            })
	            .build();
	}


    // --------------------------------------------------
    // ITEM WRITER
    // --------------------------------------------------

    @Bean
    public ItemWriter<Employee> writer(DataSource dataSource) {

        return new JdbcBatchItemWriterBuilder<Employee>()
                .dataSource(dataSource)
                .sql("""
                        INSERT INTO employee
                        (id, name, age, salary)
                        VALUES
                        (:id, :name, :age, :salary)
                        """)
                .beanMapped()
                .build();
    }


    // --------------------------------------------------
    // STEP
    // --------------------------------------------------

    @Bean
    public Step employeeStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            ItemReader<Employee> reader,
            ItemProcessor<Employee, Employee> processor,
            ItemWriter<Employee> writer) {

        return new StepBuilder(
                "employeeStep",
                jobRepository
        )
        .<Employee, Employee>chunk(2)
        .transactionManager(transactionManager)
        .reader(reader)
        .processor(processor)
        .writer(writer)
        .build();
    }


    // --------------------------------------------------
    // JOB
    // --------------------------------------------------

    @Bean
    public Job employeeJob(
            JobRepository jobRepository,
            Step employeeStep,
            JobMonitoringListener jmListener) {

        return new JobBuilder(
                "employeeJob",
                jobRepository
        )
        .start(employeeStep)
        .listener(jmListener)
        .build();
    }
    @PostConstruct
    public void checkFile() throws Exception {

        ClassPathResource resource =
                new ClassPathResource("employees.csv");

        System.out.println("FILE EXISTS = " + resource.exists());
        System.out.println("FILE URL    = " + resource.getURL());

        try (var reader =
                     new java.io.BufferedReader(
                             new java.io.InputStreamReader(
                                     resource.getInputStream()))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("ACTUAL CSV LINE = [" + line + "]");
            }
        }
    }
}