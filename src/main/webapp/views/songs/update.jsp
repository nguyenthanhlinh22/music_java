<%@ page import="java.util.List" %>
<%@ page import="com.example.music.entity.Category" %>
<%@ page import="com.example.music.entity.Artist" %>
<%@ page import="com.example.music.entity.Status" %>
<%@ page import="com.example.music.entity.Song" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    Song song = (Song) request.getAttribute("song");
    List<Status> statuses = (List<Status>) request.getAttribute("statuses");
    List<Artist> artists = (List<Artist>) request.getAttribute("artists");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
%>

<html>
<head>
    <title>Update Song</title>
</head>
<body>
<h1>Update Song</h1>
<form action="/songs/update?id=${song.songid}" method="post">
    <label for="SongName">Name:</label><br>
    <input type="text" id="SongName" name="SongName" value="${song.songName}"/><br>

    <label for="List_id">List:</label>
    <input type="number" id="List_id" name="List_id" value="${song.list_id}"/><br>

    <label for="Status_id">Status:</label>
    <select id="Status_id" name="Status_id">
        <c:forEach var="status" items="${statuses}">
            <option value="${status.statusid}"
                    <c:if test="${status.statusid == song.status.statusid}">selected</c:if>>
                    ${status.statusname}
            </option>
        </c:forEach>
    </select><br>

    <label for="Category_id">Category:</label>
    <select id="Category_id" name="Category_id">
        <c:forEach var="category" items="${categories}">
            <option value="${category.categoryid}"
                    <c:if test="${category.categoryid == song.category.categoryid}">selected</c:if>>
                    ${category.categoryname}
            </option>
        </c:forEach>
    </select><br>

    <label for="ReleaseDate">Release Date (dd/MM/yyyy):</label>
    <input type="text" id="ReleaseDate" name="ReleaseDate" value="${song.releaseDate}"/><br>

    <label for="Artists_id">Artist:</label>
    <select id="Artists_id" name="Artists_id">
        <c:forEach var="artist" items="${artists}">
            <option value="${artist.artistsid}"
                    <c:if test="${artist.artistsid == song.artist.artistsid}">selected</c:if>>
                    ${artist.artistname}
            </option>
        </c:forEach>
    </select><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
