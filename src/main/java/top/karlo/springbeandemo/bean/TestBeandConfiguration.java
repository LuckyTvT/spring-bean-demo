package top.karlo.springbeandemo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/28 10:02
 */
@Configuration
@Order(1)
public class TestBeandConfiguration{

    @Bean
    public Demo2 tt(){
        System.out.println("tt bean create");
        return new Demo2();
    }


}
