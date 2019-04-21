package top.karlo.springbeandemo.beanconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/28 10:00
 */
@Configuration
@Order(13)
public class MyBeanPostProcessor1 implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("tt")){
            System.out.println("before1");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("tt")){
            System.out.println("after1");
        }
        return bean;
    }

}
