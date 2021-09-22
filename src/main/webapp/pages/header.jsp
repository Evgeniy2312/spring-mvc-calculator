<%--
  Created by IntelliJ IDEA.
  User: UserOk
  Date: 18.09.2021
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Header</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
</head>
<body>
<header class="p-3 bg-dark text-white mb-5">
    <div class="container">
        <ul class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/home" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <a class="navbar-brand" href="/">Calculator</a>
            </a>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <c:if test="${sessionScope.user == null}">
                    <li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Hello
                        guest!</a></li>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <li><a href="/calculator/count" class="nav-link px-2 text-white">Count</a></li>
                </c:if>
            </ul>
            <c:if test="${sessionScope.user == null}">
                <div class="text-end">
                    <button type="button" onClick="location.href='/user/reg'" class="btn btn-outline-light me-2">Sign-up
                    </button>
                    <button type="button" onClick="location.href='/user/auth'" class="btn btn-warning">Log in</button>
                </div>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <div class=" d-flex justify-content-end ">
                    <div class="dropdown text-end  ">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2"
                                data-bs-toggle="dropdown"
                                aria-expanded="false">
                                ${sessionScope.user.name}
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <li>
                                <button class="dropdown-item" type="button" onClick="location.href='/user/logout'">Exit
                                </button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="button" onClick="location.href='/user/changePassword'">Change
                                    password
                                </button>
                            </li>
                            <li>
                                <button class="dropdown-item" type="button" onClick="location.href='/user/changeName'">Change
                                    name
                                </button>
                            </li>
                        </ul>
                    </div>
                </div>
            </c:if>
        </ul>
    </div>
</header>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>


<%--<c:if test="${sessionScope.user != null}">--%>
<%--    <div class=" d-flex justify-content-end ">--%>
<%--        <div class="dropdown text-end  ">--%>
<%--            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2"--%>
<%--                    data-bs-toggle="dropdown"--%>
<%--                    aria-expanded="false">--%>
<%--                    ${sessionScope.user.name}--%>
<%--            </button>--%>
<%--            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">--%>
<%--                <li>--%>
<%--                    <button class="dropdown-item" type="button" onClick="location.href='/change'">Change--%>
<%--                        password--%>
<%--                    </button>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <button class="dropdown-item" type="button" onClick="location.href='/addresses'">Edit--%>
<%--                        address--%>
<%--                    </button>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <button class="dropdown-item" type="button" onClick="location.href='/telephones'">Edit--%>
<%--                        telephone--%>
<%--                    </button>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <hr class="dropdown-divider">--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <button class="dropdown-item" type="button" onClick="location.href='/logout'">Exit--%>
<%--                    </button>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</c:if>--%>