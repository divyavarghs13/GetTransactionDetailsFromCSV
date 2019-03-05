    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <c:forEach var="listValue" items="${list}">
	<li>${listValue}</li>
    </c:forEach>