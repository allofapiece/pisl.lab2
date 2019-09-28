<%@ page import="com.pisl.lab2.entity.Computer" %>
<%@ page import="com.pisl.lab2.entity.RAMAmount" %>
<%@ page import="com.pisl.lab2.entity.Additional" %>
<%@ page import="com.pisl.lab2.entity.Garnitur" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Computer computer = (Computer) session.getAttribute("computer");
    String ram = request.getParameter("ram");
    String[] additionals = request.getParameterValues("additional");
    String[] garnitur = request.getParameterValues("garnitur");

    if (ram == null) {
        request.setAttribute("error", "Need ram value.");
        RequestDispatcher rd = request.getRequestDispatcher("/pages/collect/step2.jsp");
        rd.forward(request, response);
        return;
    }

    computer.setRAMAmount(RAMAmount.valueOf(ram));

    if (additionals != null) {
        computer.setAdditional(Arrays.stream(additionals)
                .map(Additional::valueOf)
                .collect(Collectors.toList()));
    }

    if (garnitur != null) {
        computer.setGarnitur(Arrays.stream(garnitur)
                .map(Garnitur::valueOf)
                .collect(Collectors.toList()));
    }

    session.setAttribute("computer", computer); %>

<form action="/pages/result.jsp" method="post">
    <input type="text" name="something"/>
    <button type="submit">Done</button>
</form>
</body>
</html>
