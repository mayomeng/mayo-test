package mayo.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by SKJ-05A14-0049 on 2018/3/6.
 */
@EnableConfigurationProperties
@SpringBootApplication
@ServletComponentScan
public class TestApplication implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        //ApplicationContextUtil.setApplicationContext();
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8085);
    }
}
