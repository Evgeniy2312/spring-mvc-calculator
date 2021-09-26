<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 15.09.21
  Time: 7:44 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Auth</title>
</head>
<body class="text-center">
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <main class="form-signin">
                <s:form method="post" action="/user/auth" modelAttribute="existingUser">
                    <i style="width:20px; height:22px" class="fas fa-calculator"></i>
                    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                    <div class="form-floating">
                        <s:input path="username" type="email" class="form-control" placeholder="name@example.com"/>
                        <s:errors path="username" cssClass="error"/>
                        <s:label path="username">Email</s:label>
                    </div>
                    <div class="form-floating">
                        <s:password path="password" class="form-control" placeholder="Password"/>
                        <s:errors path="password" cssClass="error"/>
                        <s:label path="password">Password</s:label>
                    </div>
                   <s:hidden path="name" value=""/>
                    <s:errors path="name" cssClass="error"/>
                    <s:button class="w-100 btn btn-lg btn-primary">Sign in</s:button>
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
