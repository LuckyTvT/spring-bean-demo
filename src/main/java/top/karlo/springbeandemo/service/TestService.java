package top.karlo.springbeandemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/4/11 16:07
 */
@Service
public class TestService {
    @Autowired
    private ServiceTest1 bean1;
    @Autowired
    private ServiceTest2 bean2;


    public static void test(){
        System.out.println("这是一个测试方法");
    }

    public void beanTest(){
        bean1.test1();
        bean2.test2();
    }


}
