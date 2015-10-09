package com.gl.qbean;

import org.jpos.q2.QBeanSupport;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ggpratama on 10/9/2015.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.gl")
public class QRestService extends QBeanSupport {
    @Override
    protected void startService() throws Exception {
        SpringApplication app = new SpringApplication();
        app.setShowBanner(true);
        app.run(QRestService.class);
    }

}
