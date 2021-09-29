package by.tms.aspect;

import by.tms.dto.UserAllFields;
import by.tms.dto.UserDTOByLogin;
import by.tms.entity.User;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
public class TestAspect {
    private final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("execution(public * by.tms.controller.UserController.reg(..)) && args(userAllFields, bindingResult, .. )")
    public void test(UserAllFields userAllFields, BindingResult bindingResult) {}

    @Pointcut("execution(public * by.tms.controller.UserController.auth(..)) && args(userDTOByLogin, bindingResult, ..)")
    public void test2(UserDTOByLogin userDTOByLogin, BindingResult bindingResult) {}

    @After(value = "test(userAllFields, bindingResult)", argNames = "userAllFields,bindingResult")
    public void abc(UserAllFields userAllFields, BindingResult bindingResult){
        logger.info("User with login {} registered", userAllFields.getUser(userAllFields).getUsername());
    }

    @After(value = "test2(userDTOByLogin, bindingResult)", argNames = "userDTOByLogin,bindingResult")
    public void abc2(UserDTOByLogin userDTOByLogin, BindingResult bindingResult){
        logger.info("User with login {} authorized", userDTOByLogin.getUser(userDTOByLogin).getUsername());
    }

}
