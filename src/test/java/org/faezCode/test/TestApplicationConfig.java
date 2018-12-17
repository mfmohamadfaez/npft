package org.faezCode.test;

import org.faezCode.npft.config.DataSourceConfig;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "org.faezCode.npft",
}
        , excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
}
)
@Import({
        DataSourceConfig.class,
})
@PropertySource(value = "classpath:application.properties")
public class TestApplicationConfig {


}
