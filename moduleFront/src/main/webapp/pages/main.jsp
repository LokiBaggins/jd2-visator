<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    td {
        padding: 5px 10px 5px 5px;
        border: 1px solid gray;
    }
</style>
<body>
<h2>Hello World!</h2>
    <a href="samplecontroller.do">Request to Server</a>
    <br/>
    <table>
        <tr>
            <td>#</td>
            <td>Name</td>
            <td>Passport</td>
            <td>Occupation</td>
            <td>Registration street</td>
        </tr>
        <c:forEach items="${teamList}" var="tm" varStatus="loop"  >
            <tr>
                <td>${loop.index + 1}</td>
                <td>${tm.nickName}</td>
                <td>${tm.passport.series} ${tm.passport.number}</td>
                <td>${tm.occupation.position} (${tm.occupation.employer.name})</td>
                <td>г. ${tm.passport.registryAddress.cityName}, ${tm.passport.registryAddress.streetType.streetTypeCode}. ${tm.passport.registryAddress.streetName}, д.${tm.passport.registryAddress.buildingNum}, кв.${tm.passport.registryAddress.flatNum}</td>
            </tr>
        </c:forEach>
    </table>
    <ul>

    </ul>
    <%--<p>And the first one is ${teammate.nickName} with sex: ${teammate.sex}</p>--%>
    <%--<p>And the first one is ${teammate.nickName}</p>--%>
    <%--<p>And the first one is ${teammate} </p>--%>
    <%--<p>With passport ${teammate.passport}</p>--%>
    <%--<p>Registred: ${teammate.passport.registryAddress}</p>--%>
</body>
</html>
