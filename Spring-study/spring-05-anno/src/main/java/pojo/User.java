package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component 组件
// 等价于<bean id="user" class="pojo.pojo.User">

@Component
@Scope("singleton")
public class User {

    // 相当于<property name="name" value="kuangcheng"/>
    @Value("kuangcheng")
    public String name;
}
