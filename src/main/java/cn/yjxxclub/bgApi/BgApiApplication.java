package cn.yjxxclub.bgApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-7-25
 * Time: 上午9:01
 * Describe: 程序入口
 */

@SpringBootApplication
@EnableAutoConfiguration
public class BgApiApplication extends SpringBootServletInitializer {

    /*Mainspringboot(){
        super();
        setRegisterErrorPageFilter(false); // <- this one
    }*/
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BgApiApplication.class, args);
    }
}

