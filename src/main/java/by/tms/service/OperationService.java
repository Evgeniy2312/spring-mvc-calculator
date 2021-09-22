package by.tms.service;


import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.util.MapOperations;
import org.springframework.stereotype.Service;

@Service
public class OperationService {


    public Operation getResult(Operation operation, User user){
        return MapOperations.OPERATION_MAP.get(operation.getTypeOfOperation()).getResult(operation, user);
    }

}
