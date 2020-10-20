package ming.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@ConditionalOnClass(MingHelloTemplate.class)
@EnableConfigurationProperties(MingProperties.class)
public class MingAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(MingAutoConfiguration.class);

    @Autowired
    private MingProperties mingProperties;

    @Bean
    @ConditionalOnMissingBean
    public MingHelloTemplate mingHelloTemplate() {
        MingHelloTemplate mingHelloTemplate = new MingHelloTemplate();
        mingHelloTemplate.setMessage(mingProperties.getMessage());
        logger.info("mingHelloTemplate inited");
        return mingHelloTemplate;
    }
}


