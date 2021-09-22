<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 22.09.2021
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <form action="/calculator/count" method="post">
                <fieldset>
                    <div class="mb-3">
                        <input required name="num1" type="number" class="form-control" placeholder="Number 1" step="0.01">
                    </div>
                    <div class="mb-3">
                        <input required name="num2" type="number" class="form-control" placeholder="Number 2" step="0.01">
                    </div>
                    <div class="mb-3">
                        <label for="selectOperation" class="form-label">Select function</label>
                        <select name="typeOfOperation" id="selectOperation" class="form-select">
                            <option value="add">Addition</option>
                            <option value="sub">Subtraction</option>
                            <option value="mul">Multiplication</option>
                            <option value="div">Division</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Count</button>
                </fieldset>
            </form>
            <c:if test="${message != null}">
                <div class="alert alert-primary" role="alert">
                        ${message}
                </div>
            </c:if>
            <c:if test="${result != null}">
                <div class="alert alert-info" role="alert" step="0.01">
                    Result: ${result}
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
