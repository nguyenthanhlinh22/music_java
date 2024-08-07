<%@ page import="java.util.List" %>
<%@ page import="com.example.music.entity.Song" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/08/2024
  Time: 2:02 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% List<Song> songs = (List<Song>) request.getAttribute("songs"); %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h1>List song</h1>
    <p>Music to enjoy</p>

    <a href="/songs/create"> Create New Song</a>

    <table class="table table-hover ">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>List</th>
            <th>Category</th>
            <th>Artists</th>
            <th>ReleaseDate</th>
            <th>Status</th>
            <th> Action </th>
        </tr>
        <c:forEach items="${songs}" var="song">
            <tr>

                <td></td>
                <td><c:out value="${song.songName}"/></td>
                <td><c:out value="${song.list_id}"/></td>
                <td><c:out value="${song.category_id}"/></td>
                <td><c:out value="${song.artists_id}"/></td>
                <td><c:out value="${song.releaseDate}"/></td>
                <td><c:out value="${song.status_id}"/></td>
                <td>
                    <a class="btn btn-danger" href="/songs/delete?id=<c:out value="${song.songid}"/>">Delete</a>
                    <a class="btn btn-primary">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
