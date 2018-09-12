<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 18/9/12
  Time: 下午9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>

<html>
<head>
    <title>Form</title>
    <style>
        .error{
            color:#FF0000;
            font-style: italic;
        }
    </style>
</head>
<body>
    <h1>NEW PROJECT</h1>

    <springForm:form method="post" commandName="product" action="save.do">
        <table>
            <tr>
                <td>
                    PRODUCT ID:
                </td>
                <td>
                    <springForm:input path="id"/>
                </td>
                <td>
                    <springForm:errors path="id" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    PRODUCT NAME:
                </td>
                <td>
                    <springForm:input path="name"/>
                </td>
                <td>
                    <springForm:errors path="name" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    PRODUCT TYPE:
                </td>
                <td>
                    <springForm:select path="type">
                        <springForm:option value="" label="Select Type"/>
                        <springForm:option value="food" label="Food"/>
                        <springForm:option value="fruit" label="Fruit"/>
                        <springForm:option value="appliance" label="Appliance"/>
                        <springForm:option value="clother" label="Clother"/>
                    </springForm:select>

                </td>
                <td>
                    <springForm:errors path="type" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="save"/>
                </td>
            </tr>
        </table>
    </springForm:form>
</body>
</html>
