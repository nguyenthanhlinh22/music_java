<%@ page import="java.util.List" %>
<%@ page import="com.example.music.entity.Category" %>
<%@ page import="com.example.music.entity.Artist" %>
<%@ page import="com.example.music.entity.Status" %>
<%@ page import="com.example.music.entity.Song" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% List<Song> songs = (List<Song>) request.getAttribute("songs");%>
<% List<Status> statuses = (List<Status>) request.getAttribute("statuses");%>
<% List<Artist> artists = (List<Artist>) request.getAttribute("artists"); %>
<%     List<Category> categories = (List<Category>) request.getAttribute("categories");%>

<html>
<head>
    <title>Update Song</title>
</head>
<body>
<h1>Update Song</h1>
<form method="post" action="/songs/update?id=${songs.id}">
    <label for="SongName">Name:</label><br>
    <input type="text" id="SongName" name="SongName" value="<c:out value="${songs.SongName}"/>"/><br>

    <label for="List_id">List:</label>
    <input type="number" id="List_id" name="List_id" value="${songs.List_id}"/><br>

    <label for="Status_id">Status:</label>
    <select id="Status_id" name="Status_id">
        <c:forEach var="status" items="${statuses}">
            <option value="${status.statusid}" ${status.statusid == songs.Status_id ? 'selected' : ''}>${status.statusname}</option>
        </c:forEach>
    </select><br>

    <label for="Category_id">Category:</label>
    <select id="Category_id" name="Category_id">
        <c:forEach var="category" items="${categories}">
            <option value="${category.categoryid}" ${category.categoryid == songs.Category_id ? 'selected' : ''}>${category.categoryname}</option>
        </c:forEach>
    </select><br>

    <label for="ReleaseDate">Release Date (dd/MM/yyyy):</label>
    <input type="text" id="ReleaseDate" name="ReleaseDate" value="${songs.ReleaseDate}"/><br>

    <label for="Artists_id">Artist:</label>
    <select id="Artists_id" name="Artists_id">
        <c:forEach var="artist" items="${artists}">
            <option value="${artist.artistsid}" ${artist.artistsid == songs.Artists_id ? 'selected' : ''}>${artist.artistname}</option>
        </c:forEach>
    </select><br>

    <button type="submit">Update Song</button>
</form>
</body>
</html>
