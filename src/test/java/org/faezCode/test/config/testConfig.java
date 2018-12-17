package org.faezCode.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"org.faezCode.npft.Controllers", "org.faezCode.npft.Dao", "org.faezCode.npft.Entity", "org.faezCode.npft.Service"})
public class testConfig {

    @Configuration
    @PropertySource({"classpath:test-app.properties"})
    static class Offline {
        // nothing needed here if you are only overriding property values
    }

}
