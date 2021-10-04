package by.tms.entity;

import by.tms.util.ErrorMessageManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class Operation {
    @NotNull(message = ErrorMessageManager.NUMBER_USER_ERROR)
    private double num1;
    @NotNull(message = ErrorMessageManager.NUMBER_USER_ERROR)
    private double num2;
    @NotBlank(message = ErrorMessageManager.TYPE_OF_OPERATION_USER_ERROR)
    @NotEmpty()
    private String typeOfOperation;
    private double result;
    private User user;

    @Override
    public String toString() {
        return "num1 = " +  num1 + " , num2 = " + num2 + " , typeOfOperation = " + typeOfOperation +
                " , result = " + result + " , name = " + user.getName();
    }
}
