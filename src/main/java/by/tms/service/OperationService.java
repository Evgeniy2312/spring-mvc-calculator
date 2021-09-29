package by.tms.service;


import by.tms.dao.OperationDao;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.mathoperations.MathOperation;
import by.tms.util.OperationManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    private OperationDao operationDao;
    private OperationManager operationManager;


    public OperationService(OperationDao operationDao, OperationManager operationManager) {
        this.operationDao = operationDao;
        this.operationManager = operationManager;
    }


    public OperationManager getOperationManager() {
        return operationManager;
    }

    public Operation getResult(Operation operation, User user){
        MathOperation mathOperation = operationManager.getOperationByName(operation.getTypeOfOperation());
        Operation operation1 = mathOperation.getResult(operation, user);
        operationDao.addOperation(operation1);
        return operation1;
    }

    public List<Operation> getOperationsByUser(User user){
        return operationDao.getOperationsByUser(user);
    }

    public List<Operation> getOperationsByOperation(User user, String type){
        return operationDao.getOperationsByOperations(user, type);
    }

}
