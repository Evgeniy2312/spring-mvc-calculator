package by.tms.util;

import by.tms.service.mathoperations.*;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {

    public static final Map<String, MathOperation> OPERATION_MAP = new HashMap<>();

    static {
        OPERATION_MAP.put("mul", new Multiplication());
        OPERATION_MAP.put("div", new Division());
        OPERATION_MAP.put("add", new Addition());
        OPERATION_MAP.put("sub", new Subtraction());
    }
}
