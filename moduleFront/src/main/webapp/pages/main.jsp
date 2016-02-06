<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
    <a href="samplecontroller.do">Request to Server</a>
    <br/>
    <ul>
        <c:forEach items="${teamList}" var="tm" varStatus="loop">
            <li>${tm.nickName}</li>
        </c:forEach>
    </ul>
    <%--<p>And the first one is ${teammate.nickName} with sex: ${teammate.sex}</p>--%>
    <%--<p>And the first one is ${teammate.nickName}</p>--%>
    <p>And the first one is ${teammate} </p>
</body>
</html>
