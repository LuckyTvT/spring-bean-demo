package top.karlo.springbeandemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/29 09:16
 */
public class RegistController {

    @RequestMapping("/aaa")
    @ResponseBody
    public String aaa(){
        return "aaa";
    }


}

