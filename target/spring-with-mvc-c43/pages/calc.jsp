<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 22.09.2021
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="S" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
                <s:form method="post" action="/calculator/count" modelAttribute="newOperation">
                <fieldset>
                    <div class="mb-3">
                        <s:input path="num1" type="number" placeholder="Number 1" step="0.01"/>
                        <s:errors path="num1" cssClass="error"/>
                        <s:label path="num1">Number 1</s:label>
                    </div>
                    <div class="mb-3">
                        <s:input path="num2" type="number" placeholder="Number 2" step="0.01"/>
                        <s:errors path="num2" cssClass="error"/>
                        <s:label path="num2">Number 2</s:label>
                    </div>
                    <div class="mb-3">
                        <s:label path="typeOfOperation">Select function</s:label>
                        <s:select path="typeOfOperation" cssClass="form-select" items="${listOperations}"/>
                        <s:errors path="typeOfOperation" cssClass="error"/>
                    </div>
                    <div class="text-center">
                        <s:button class="btn btn-primary">Count</s:button>
                    </div>
                </fieldset>
                </s:form>
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
