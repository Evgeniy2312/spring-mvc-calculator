package by.tms.service.mathoperations;

import by.tms.entity.Operation;
import by.tms.entity.User;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface MathOperation {
    Operation getResult(Operation operation, User user);
    default double getDouble(double result){
        BigDecimal resultBD = new BigDecimal(result).setScale(2, RoundingMode.DOWN);
        return resultBD.doubleValue();
    }
}
