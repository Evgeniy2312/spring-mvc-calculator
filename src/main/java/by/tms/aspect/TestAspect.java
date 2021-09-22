package by.tms.aspect;

import by.tms.entity.User;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
    private final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("execution(public * by.tms.service.UserService.save(..)) && args(user, ..)")
    public void test(User user) {}

    @Pointcut("execution(public * by.tms.controller.UserController.auth(..)) && args(user, ..)")
    public void test2(User user) {}

    @After(value = "test(user)", argNames = "user")
    public void abc(User user){
        logger.info("User with name {} registered", user.getUsername());
    }

    @After(value = "test2(user)", argNames = "user")
    public void abc2(User user){
        logger.info("User with name {} authorized", user.getUsername());
    }

}
