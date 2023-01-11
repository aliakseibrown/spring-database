<%@ page language ="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
    <title>View </title>
</head>
<body>
    <form action="addPainting">
        <input type = "text" name="id"><br>
        <input type = "text" name="title"><br>
        <input type = "text" name="artist"><br>
        <input type = "text" name="year"><br>
        <input type = "submit"><br>
    </form>

    <form action="getPainting">
        <input type = "text" name="id"><br>
        <input type = "submit"><br>
    </form>

</body>
</html>