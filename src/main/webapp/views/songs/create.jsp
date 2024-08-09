<%@ page import="java.util.List" %>
<%@ page import="com.example.music.entity.Category" %>
<%@ page import="com.example.music.entity.Artist" %>
<%@ page import="com.example.music.entity.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% List<Category> categories = (List<Category>) request.getAttribute("categories"); %>
<% List<Artist> artists = (List<Artist>) request.getAttribute("artists"); %>
<% List<Status> statuses = (List<Status>) request.getAttribute("statuses"); %>

<html>
<head>
    <title>Create New Song</title>
</head>
<body>
<form method="post" action="/songs/create">
    <label for="SongName">Name:</label><br>
    <input id="SongName" name="SongName" /><br>
    <label for="List_id">List:</label>
    <input type="number" id="List_id" name="List_id"><br>
    <label for="Status_id">Status:</label>
    <select id="Status_id" name="Status_id">
        <c:forEach var="status" items="${statuses}">
            <option value="<c:out value="${status.statusid}"/>"><c:out value="${status.statusname}"/></option>
        </c:forEach>
    </select><br>
    <label for="Category_id">Category:</label>
    <select id="Category_id" name="Category_id">
        <c:forEach var="category" items="${categories}">
            <option value="<c:out value="${category.categoryid}"/>"><c:out value="${category.categoryname}"/></option>
        </c:forEach>
    </select><br>
    <label for="ReleaseDate">Release Date (dd/MM/yyyy):</label>
    <input type="text" id="ReleaseDate" name="ReleaseDate">
    <label for="Artists_id">Artist:</label>
    <select id="Artists_id" name="Artists_id">
        <c:forEach var="artist" items="${artists}">
            <option value="<c:out value="${artist.artistsid}"/>"><c:out value="${artist.artistname}"/></option>
        </c:forEach>
    </select><br>
    <button type="submit">Create Song</button>
</form>
</body>
</html>
