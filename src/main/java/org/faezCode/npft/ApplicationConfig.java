package org.faezCode.npft;

import org.faezCode.npft.config.DataSourceConfig;
import org.faezCode.npft.config.WebMVCConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@EnableWebSecurity
@EnableScheduling
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
        WebMVCConfig.class,
})
@PropertySource(value = "classpath:application.properties")
public class ApplicationConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

}
