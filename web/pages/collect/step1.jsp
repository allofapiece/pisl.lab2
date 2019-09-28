<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/ctags/util.tld" prefix="util" %>
<html>
<head>
    <title>Step 1</title>
</head>
<body>
<form action="/pages/collect/step2.jsp" method="post">
    <util:enum type="select" src="com.pisl.lab2.entity.ComputerName" name="name">
        Select computer name<br>
    </util:enum>
    <button type="submit">Next step</button>
</form>

</body>
</html>
