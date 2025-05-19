<html>
<body>
    <h2>Student List</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Email</th></tr>
        <c:forEach var="s" items="${students}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>