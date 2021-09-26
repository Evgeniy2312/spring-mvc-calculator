package by.tms.dao;

import by.tms.entity.Operation;
import by.tms.entity.User;

import java.util.List;

public interface OperationDao {

    void addOperation(Operation operation);
    List<Operation> getOperations();
    List<Operation> getOperationsByUser(User user);
    List<Operation> getOperationsByOperations(User user, String type);

}
