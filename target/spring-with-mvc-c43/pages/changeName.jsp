<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 22.09.2021
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Change Name</title>
</head>
<body class="text-center">
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <main class="form-signin">
                <s:form action="/user/changeName" method="post">
                    <i style="width:20px; height:22px" class="fas fa-calculator"></i>
                    <h1 class="h3 mb-3 fw-normal">Change Name</h1>
                    <div class="form-floating">
                        <input required name="newName" type="text" class="form-control" id="floatingInput"
                               placeholder="name@example.com">
                        <label for="floatingInput">New name</label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Change</button>
                </s:form>
            </main>
            <c:if test="${message != null}">
                <div class="alert alert-primary" role="alert">
                        ${message}
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
