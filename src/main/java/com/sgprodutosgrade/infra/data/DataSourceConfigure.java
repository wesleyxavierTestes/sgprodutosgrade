package com.sgprodutosgrade.infra.data;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataSourceConfigure {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder datasource = DataSourceBuilder.create();

        if (System.getenv("ambiente") != null) {
            datasource.driverClassName("org.postgresql.Driver");
            datasource.url("jdbc:postgresql://0.0.0.0:5432/produtograde");
            datasource.username("trainee");
            datasource.password("123");
        } else {
            datasource.driverClassName("org.h2.Driver");
            datasource.url("jdbc:h2:mem:produtograde");
            datasource.username("sa");
            datasource.password("sa");
        }
        return datasource.build();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        if (System.getenv("ambiente") != null) {
            adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
            adapter.setDatabase(Database.POSTGRESQL);
        } else {
            adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
            adapter.setDatabase(Database.H2);
        }
        adapter.setGenerateDdl(true);
        adapter.setPrepareConnection(true);
        adapter.setShowSql(false);

        return adapter;
    }
}