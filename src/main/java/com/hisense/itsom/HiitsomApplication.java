package com.hisense.itsom;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Springboot启动类
 * @author W.K.
 *
 */
@Slf4j
@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
public class HiitsomApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application = SpringApplication.run(HiitsomApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        // W.K.->JDK1.8 server.servlet.context-path下边是1.7
        String path = env.getProperty("server.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application HIITSOM is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t" +
                "Doc: \t\thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
        
	}
	
	
    /**
     * tomcat-embed-jasper引用后提示jar找不到的问题
     */
	/*
	 * @Bean public TomcatServletWebServerFactory tomcatFactory() { return new
	 * TomcatServletWebServerFactory() {
	 * 
	 * @Override protected void postProcessContext(Context context) {
	 * ((StandardJarScanner) context.getJarScanner()).setScanManifest(false); } }; }
	 */

}
