package by.tms.service.mathoperations;

import by.tms.entity.Operation;
import by.tms.entity.User;
import org.springframework.stereotype.Component;


@Component
public class Subtraction implements MathOperation{


    @Override
    public Operation getResult(Operation operation, User user) {
        double num1 = operation.getNum1();
        double num2 = operation.getNum2();
        return new Operation(num1,num2, operation.getTypeOfOperation(), getDouble(num1 - num2), user);
    }
}
