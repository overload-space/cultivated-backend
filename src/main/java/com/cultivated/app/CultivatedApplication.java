package com.cultivated.app;

import com.cultivated.app.config.AutoCreateDataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@AutoCreateDataBase
@MapperScan("com.cultivated.app.persistence.mapper.impl")
public class CultivatedApplication {

    public static void main(String[] args) {
        SpringApplication.run(CultivatedApplication.class, args);
    }
}
