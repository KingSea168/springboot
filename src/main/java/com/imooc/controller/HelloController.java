package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 廖师兄
 * 2016-10-30 23:36
 */
@RestController //@RestController = Controller + ResponseBoby
@RequestMapping("/hello") 
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    /**
     * 参数默认值
     * @param myId
     * @return
     */
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id: " + myId+" size: "+ girlProperties.getCupSize();
    }
    
    /**
     * @PathVariable传参
     * @param id
     * @return
     */
    @GetMapping(value = "/speak/{id}") //或 @GetMapping(value = "/{id}/speak")
    public String speak(@PathVariable(value="id") Integer id) {
        return "id: " + id;
    }
    
    /**
     * @RequestMapping + GET = @GetMapping
     * @return
     */
    @RequestMapping(value={"/hello","hi"},method = RequestMethod.GET) // @GetMapping(value={"/hello","hi"})
    public String hello(){
    	return "Hello Spring Boot!";
    }
}
