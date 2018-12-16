package com.cultivated.app.config;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 基于flyway的自动创建数据库工具
 * Created by Nirvana on 2017/10/30.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class DatabaseAutoCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseAutoCreator.class);

    private static final String JDBC_PREFIX = "jdbc:";

    @Bean
    public FlywayMigrationInitializer flywayInitializer(Flyway flyway, DataSourceProperties properties) {

        String url = properties.getUrl();
        if (!url.startsWith(JDBC_PREFIX)) {
            throw new RuntimeException("create database failed.");
        }

        String dbUri = url.substring(JDBC_PREFIX.length());
        URI uri = URI.create(dbUri);
        String hostPort = uri.getHost() + ":" + uri.getPort();
        if (uri.getHost() == null) {
            hostPort = uri.getAuthority();
        }
        createDB(JDBC_PREFIX + uri.getScheme() + "://" + hostPort,
                properties.getUsername(),
                properties.getPassword(),
                uri.getPath().substring(1));
        return new FlywayMigrationInitializer(flyway, null);
    }

    private static void createDB(String url, String username, String password, String dbName) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(String.format("CREATE DATABASE IF NOT EXISTS `%s` CHARACTER SET utf8", dbName));
        } catch (SQLException e) {
            LOGGER.error("create database failed: ", e);
            throw new RuntimeException("create database failed.");
        }
    }
}
