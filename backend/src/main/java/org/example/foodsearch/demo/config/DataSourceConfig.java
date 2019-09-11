// package org.example.foodsearch.demo.config;

// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;

// @Configuration
// public class DataSourceConfig {

// @Value("${postgres.user}")
// public String username;

// @Value("${postgress.password}")
// public String password;

// @Value("${postgress.url}")
// public String url;

// @Value("${postgress.port}")
// public String port;

// @Value("${postgress.db}")
// public String db;
// @Bean
// public DataSource dataSource() {
// DriverManagerDataSource dataSource = new DriverManagerDataSource();

// dataSource.setDriverClassName("org.postgresql.Driver");
// dataSource.setUsername(username);
// dataSource.setPassword(password);
// dataSource.setUrl(String.format("jdbc:postgresql://%s:%s/%s", url, port,
// db));

// return dataSource;
// }
// }