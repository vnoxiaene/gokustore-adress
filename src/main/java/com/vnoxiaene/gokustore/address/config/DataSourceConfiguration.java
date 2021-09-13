package com.vnoxiaene.gokustore.address.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfiguration {
    @Value("${datasource.driverClassName}")
    private String driver;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.hikari.minimumIdle}")
    private int minimumIdle;

    @Value("${datasource.hikari.maximumPoolSize}")
    private int maximumPoolSize;

    @Value("${datasource.hikari.idleTimeout}")
    private int idleTimeout;

    @Value("${datasource.hikari.poolName}")
    private String poolName;

    @Value("${datasource.hikari.maxLifetime}")
    private int maxLifetime;

    @Value("${datasource.hikari.connectionTimeout}")
    private int connectionTimeout;

    @Bean
    public DataSource primaryDataSource() {
        Properties dsProps = new Properties();
        dsProps.put("url", url);
        dsProps.put("user", username);
        dsProps.put("password", password);

        Properties configProps = new Properties();
        configProps.put("dataSourceClassName", driver);
        configProps.put("poolName", poolName);
        configProps.put("maximumPoolSize", maximumPoolSize);
        configProps.put("minimumIdle", minimumIdle);
        configProps.put("connectionTimeout", connectionTimeout);
        configProps.put("idleTimeout", idleTimeout);
        configProps.put("dataSourceProperties", dsProps);

        HikariConfig hc = new HikariConfig(configProps);
        HikariDataSource ds = new HikariDataSource(hc);
        return ds;
    }
}
