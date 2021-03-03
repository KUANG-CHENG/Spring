## 常用依赖
```xml
    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.0.RELEASE</version>
        </dependency>
        <!--junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
    </dependencies>
```
## 注解说明
- @Autowired ：自动装配通过类型，名字。可以与 @Qualifier(value="xxx")联合使用
- @Resource ：自动装配通过名字，类型
- @Component 组件
- @Value 属性注入