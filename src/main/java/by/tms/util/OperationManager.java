package by.tms.util;

import by.tms.service.mathoperations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class OperationManager {


    private List<MathOperation> mathOperations;

    public OperationManager(List<MathOperation> mathOperations) {
        this.mathOperations = mathOperations;
    }

    public List<String> getNameOperations(){
        List<String> names = new ArrayList<>();
        for (MathOperation maths: mathOperations){
            names.add(maths.getClass().getSimpleName());
        }
        return names;
    }

    public MathOperation getOperationByName(String name){
        return  mathOperations.stream().filter(math -> math.getClass().getSimpleName().equals(name)).findFirst().get();
    }

}



//    static {
//        OPERATION_MAP.put("mul", new Multiplication());
//        OPERATION_MAP.put("div", new Division());
//        OPERATION_MAP.put("add", new Addition());
//        OPERATION_MAP.put("sub", new Subtraction());
//    }
