package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author LYJ
 * @create 2021-06-29 9:13
 * @Component注解等价于<bean id="user" class="pojo.User"/>
 */

@Component
@Scope
public class User {

    /**
     * 相当于 <property name="name" value="云小杰"/>
     */
    @Value("云小杰")
    public String name;

}
