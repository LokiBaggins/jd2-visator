<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
    <a href="samplecontroller.do">Request to Server</a>
    <br/>
    <ul>
        <c:forEach items="teammate" var="tm" varStatus="loop">
            <li>${tm.nickName}</li>
        </c:forEach>
    </ul>
</body>
</html>