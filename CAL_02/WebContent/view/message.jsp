<%@ page import="com.mvcapp.model.Message" %>
<html>
<body>
    <h2>Message</h2>
    <%
        Message msg = (Message)request.getAttribute("message");
        out.println(msg.getText());
    %>
</body>
</html>