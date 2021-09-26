package by.tms.service;


import by.tms.dao.OperationDao;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.util.MapOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    private OperationDao operationDao;

    public OperationService(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public Operation getResult(Operation operation, User user){
        Operation operation1 = MapOperations.OPERATION_MAP.get(operation.getTypeOfOperation()).getResult(operation, user);
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
