package com.example.batchcsvtodb.demo.Config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.batchcsvtodb.demo.Model.Product;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jbf;
	
	
	@Autowired
	private StepBuilderFactory sb;
	
	
	public Job job() {
		return jbf.get("job1")
				.incrementer(new RunIdIncrementer())
				.start(step())
				.build();
		
	}

	public Step step() {
		return sb.get("step1").
				<Product,Product>chunk(2)
				.reader(reader())
				.processor(process())
				.writer(write())
				.build();
		
	}
	
	@Bean
	public ItemReader<Product> reader(){
		
		FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("Product.csv"));
		
		DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id","name","price");
		
		BeanWrapperFieldSetMapper<Product> setMapper = new BeanWrapperFieldSetMapper<Product>();
		setMapper.setTargetType(Product.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(setMapper);
		
		reader.setLineMapper(lineMapper);
		return reader;
		
	}
	
	@Bean
	public ItemProcessor<Product,Product> process(){
		return P->{
			P.setPrice(P.getPrice() - P.getPrice() * 10/100);
			return P;
		};
		
	}
	
	@Bean
	public ItemWriter<Product> write(){
		JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(datasource());
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
		writer.setSql("Insert into Product(id,name,price) values (:id,:name,:price)");
		return writer;
		
	}
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql//localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
		
	}

}
