<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vvdolgov
  Date: 20.09.2018
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer Form</title>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
    <div id = "wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id = "container">
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="POST">
            <form:hidden path="id"/>
            <table>
                <tbody>
                    <tr>
                        <td><label>First Name: </label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>
                    <tr>
                        <td><label>Last Name: </label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>
                    <tr>
                        <td><label>Email: </label></td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save"/></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
        <div style="clear; both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
        </p>
    </div>
</body>
</html>
