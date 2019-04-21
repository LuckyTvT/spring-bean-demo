package top.karlo.springbeandemo.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import top.karlo.springbeandemo.service.TestService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/29 09:14
 */
@Controller
public class TestController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private TestService testService;

    /**
     * 通过反射动态注入请求地址及handler的映射
     *
     *
     * @return
     */
    @RequestMapping("/regist")
    @ResponseBody
    public String regist(){
        RequestMappingHandlerMapping mapping = applicationContext.getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        Class<RegistController> clazz = RegistController.class;
        try {
            Method method1 = mapping.getClass().getDeclaredMethod("getMappingForMethod", Method.class, Class.class);
            method1.setAccessible(true);
            Method method = clazz.getMethod("aaa");
            RequestMappingInfo info = (RequestMappingInfo)method1.invoke(mapping, method, String.class);
            mapping.registerMapping(info,RegistController.class.newInstance(),method);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "aaaa";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        testService.beanTest();
        return "success";
    }
}
