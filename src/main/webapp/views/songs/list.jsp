<%@ page import="java.util.List" %>
<%@ page import="com.example.music.entity.Song" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%
    List<Song> songs = (List<Song>) request.getAttribute("songs");

    // Set default values if attributes are missing
    Integer limitAttr = (Integer) request.getAttribute("limit");
    int limit = (limitAttr != null) ? limitAttr : 10; // Default to 10 if limit is not provided

    Integer pageAttr = (Integer) request.getAttribute("page");
    int currentPage = (pageAttr != null) ? pageAttr : 1; // Default to page 1 if not provided

    int totalSong = (songs != null) ? songs.size() : 0;
    int totalPages = (int) Math.ceil((double) totalSong / limit);
%>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>List Songs</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<h1>List of Songs</h1>
<p>Music to enjoy</p>

<a class="btn btn-success m-2" href="/songs/create">Create New Song</a>
<form action="/songs/search" method="get">
    <input class="input-key" type="text" name="keyword" placeholder="Search by name">
    <input class="btn btn-primary" type="submit" value="Search">
</form>

<table class="table table-hover">
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>List</th>
        <th>Category</th>
        <th>Artists</th>
        <th>Release Date</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:set var="index" value="${(currentPage - 1) * limit + 1}"/>
    <c:forEach items="${songs}" var="song">
        <tr>
            <td><c:out value="${index}"/></td>
            <td><c:out value="${song.songName}"/></td>
            <td><c:out value="${song.list_id}"/></td>
            <td><c:out value="${song.category.categoryname}"/></td>
            <td><c:out value="${song.artist.artistname}"/></td>
            <td><c:out value="${song.releaseDate}"/></td>
            <td><c:out value="${song.status.statusname}"/></td>
            <td>
                <a class="btn btn-danger" href="/songs/delete?id=<c:out value="${song.songid}"/>">Delete</a>
                <a class="btn btn-primary" href="/songs/update?id=<c:out value="${song.songid}"/>">Update</a>
            </td>
        </tr>
        <c:set var="index" value="${index + 1}"/>
    </c:forEach>
</table>

<!-- Pagination Controls -->
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item <c:if test='${currentPage == 1}'>disabled</c:if>'">
            <a class="page-link" href="?page=${currentPage - 1}&limit=${limit}">Previous</a>
        </li>
        <c:forEach var="i" begin="1" end="${totalPages}">
            <li class="page-item <c:if test='${currentPage == i}'>active</c:if>'">
                <a class="page-link" href="?page=${i}&limit=${limit}">${i}</a>
            </li>
        </c:forEach>
        <li class="page-item <c:if test='${currentPage == totalPages}'>disabled</c:if>'">
            <a class="page-link" href="?page=${currentPage + 1}&limit=${limit}">Next</a>
        </li>
    </ul>
</nav>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
