<%@ page language ="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
    <title>View </title>
</head>
<body>
    <a>add painting: </a><form action="addPainting">
        <a>id: </a><input type = "text" name="id"><br>
        <a>title: </a><input type = "text" name="title"><br>
        <a>artist: </a><input type = "text" name="artist"><br>
        <a>year: </a><input type = "text" name="year"><br>
        <input type = "submit"><br>
    </form>

    <form action="getPainting">
        <a>get painting: </a>
        <input type = "text" name="id"><br>
        <input type = "submit"><br>
    </form>

</body>
</html>