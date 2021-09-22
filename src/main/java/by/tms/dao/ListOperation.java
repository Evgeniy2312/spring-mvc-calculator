package by.tms.dao;

import by.tms.entity.Operation;
import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListOperation implements OperationDao{

    private static final List<Operation> operations = new ArrayList<>();

    @Override
    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    @Override
    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public List<Operation> getOperationsByUser(User user) {
        List<Operation> operationList = new ArrayList<>();
        for (Operation operation: operations){
            if(operation.getUser().equals(user)){
             operationList.add(operation);
            }
        }
        return operationList;
    }

    @Override
    public List<Operation> getOperationByOperations(User user, String type) {
       List<Operation> operationList = new ArrayList<>();
        for (Operation operation: operations){
            if(operation.getTypeOfOperation().equals(type) && operation.getUser().equals(user)){
                operationList.add(operation);
            }
        }
        return operationList;
    }
}
