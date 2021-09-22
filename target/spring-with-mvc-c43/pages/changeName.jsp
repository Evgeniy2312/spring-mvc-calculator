<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 22.09.2021
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change Name</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <main class="form-signin">
                <form action="/user/changeName " method="post">
                    <i style="width:20px; height:22px" class="fas fa-calculator"></i>
                    <h1 class="h3 mb-3 fw-normal">Change password</h1>
                    <div class="form-floating">
                        <input required name="newName" type="password" class="form-control" id="floatingInput"
                               placeholder="name@example.com">
                        <label for="floatingInput">Old password</label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                </form>
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
