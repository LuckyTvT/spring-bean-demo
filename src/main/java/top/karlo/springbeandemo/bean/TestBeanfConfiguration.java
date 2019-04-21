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
@Order(0)
public class TestBeanfConfiguration {

    @Bean
    public Demo1 tt1() {
        System.out.println("tt1 bean create");
        return new Demo1();
    }

}
