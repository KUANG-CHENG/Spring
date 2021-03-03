package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//这个也会被Spring容器托管，注册到容器中，因为它本来就算一个@Component
//Configuration代表这是一个配置类，就和我们之前看的bean.xml
@Configuration
@ComponentScan("com")
public class Config {

    //注册一个bean，就相当于我们之前写的一个bean标签
    //这个方法的名字，相当于bean标签中的 id 属性
    //这个方法的返回值，相当于bean标签中的 class 属性
    @Bean
    public User user(){
        return  new User();//就算返回要注入到bean的对象
    }


}
