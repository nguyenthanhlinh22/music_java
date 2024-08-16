<%@ page import="com.example.music.entity.Artist" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/08/2024
  Time: 10:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% List<Artist> artists = (List<Artist>) request.getAttribute("artists");%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>list artists</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>

</head>
<body>
<h1>list artists</h1>

<table class="table table-hover">
    <tr>
       <th>
           #
       </th>
        <th>
            Name Artists
        </th>
        <th>
            AGE Artists
        </th>
        <th>
            gender Artists
        </th>
        <th>
            des Artists
        </th>
        <th>
            Action
        </th>
    </tr>

    <c:forEach items="${artists}" var="artist">
        <tr>
            <td></td>
            <td><c:out value="${artist.artistname}" /> </td>
            <td><c:out value="${artist.artistimage}" /> </td>
            <td><c:out value="${artist.gender}" /> </td>
            <td><c:out value="${artist.description}" /> </td>
            <td><a href="/artist/delete?id=<c:out value="${artist.artistsid}"/> ">delete</a></td>
        </tr>


    </c:forEach>

</table>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
