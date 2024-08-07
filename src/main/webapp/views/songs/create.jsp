<%@ page import="java.util.List" %>
<%@ page import="com.example.music.entity.Category" %>
<%@ page import="com.example.music.entity.Artist" %>
<%@ page import="com.example.music.entity.Status" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/08/2024
  Time: 6:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% List< Category> categories = (List<Category>) request.getAttribute("categories");%>
<% List<Artist> artists = (List<Artist>) request.getAttribute("artists");%>
<% List<Status> statuses = (List<Status>) request.getAttribute("statuses");%>

<html>
<head>
    <title>Create New Song</title>
</head>
<body>
<form method="post" action="/songs/create">
    <label for="SongName">Description:</label><br>
    <input id="SongName" name="SongName" /><br>
    <label for="List_id">List:</label>
    <input type="number" id="List_id" name="List_id"><br>
    <label for="status_id">status:</label>
    <select id="status_id" name="status_id">
        <c:forEach var="status" items="${statuses}">
            <option value="<c:out value="${status.Statusid}"/>"><c:out value="${status.Statusname}"/></option>
        </c:forEach>
    </select>
    <label for="Category_id">Category:</label>
    <select id="Category_id" name="Category_id">
        <c:forEach var="category" items="${categories}">
            <option value="<c:out value="${category.categoryid}"/>"><c:out value="${category.categoryname}"/></option>
        </c:forEach>
    </select>
    <label for="ReleaseDate">ReleaseDate</label>
    <input id="ReleaseDate" name="ReleaseDate">
    <label for="Artists_id">Artists:</label>
    <select id="Artists_id" name="Artists_id">
        <c:forEach var="artist" items="${artists}">
            <option value="<c:out value="${artist.Artistsid}"/>"><c:out value="${artist.Artistsname}"/></option>
        </c:forEach>
    </select>


</form>

</body>
</html>
