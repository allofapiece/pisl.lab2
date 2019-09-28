<%@ page import="com.pisl.lab2.entity.Computer" %>
<%@ page import="com.pisl.lab2.entity.ComputerName" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/ctags/util.tld" prefix="util" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if (request.getAttribute("error") != null) {
    out.print(request.getAttribute("error"));
} else {
    Computer computer = new Computer();
    computer.setName(ComputerName.valueOf(request.getParameter("name")));
    session.setAttribute("computer", computer);
} %>

<form action="/pages/collect/step3.jsp" method="post">
<util:enum type="radio" src="com.pisl.lab2.entity.RAMAmount" name="ram">
    Select RAM amount<br>
</util:enum>
<util:enum type="check" src="com.pisl.lab2.entity.Additional" name="additional">
    Select additional<br>
</util:enum>
<util:enum type="check" src="com.pisl.lab2.entity.Garnitur" name="garnitur">
    Select garnitur<br>
</util:enum>
<button type="submit">Next step</button>
</form>
</body>
</html>
