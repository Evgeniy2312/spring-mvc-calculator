<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 25.09.2021
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1 align="center" class="display-5 mb-3">Your history</h1>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-6">
<%--            <s:form action="/calculator/history" method="post" modelAttribute="type">--%>
                <form action="/calculator/history" method="post">
                <div class="mb-3">
                    <label for="selectOperation" class="form-label">Select function</label>
                    <select name="type" id="selectOperation" class="form-select">
                        <option value="add">Addition</option>
                        <option value="sub">Subtraction</option>
                        <option value="mul">Multiplication</option>
                        <option value="div">Division</option>
                    </select>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary my-3">Get</button>
                    </div>
                </div>
                </form>
<%--            </s:form>--%>
            <div class="list-group mb-5">
                <c:forEach items="${currentList}" var="operation">
                    <a href="#" class="list-group-item list-group-item-action list-group-item-primary">${operation}</a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>




<%--                    <s:label path="type">Select function</s:label>--%>
<%--                            <s:select path=""--%>
<%--                        <s:option value="sub">Subtraction</s:option>--%>
<%--                        <s:option value="mul">Multiplication</s:option>--%>
<%--                        <s:option value="div">Division</s:option>--%>
<%--                        <s:option value="add">Addition</s:option>--%>
<%--                    </s:select>--%>
<%--                    <s:errors path="typeOfOperation" cssClass="error"/>--%>