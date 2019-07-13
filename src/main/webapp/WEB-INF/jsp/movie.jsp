<%-- 
    Document   : movie
    Created on : 13 Ιουλ 2019, 5:43:00 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>MovieInfo</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/movie.css">
  
</head>

<body>
    
    <div  hidden id="hidden">${mId}</div>
  <nav class="navbar navbar-default">
    <div class="container">
      <div class="navbar-header">
        <a class="navbar-brand" href="index.html">MENU</a>
      </div>
    </div>
  </nav>

  <div class="container">
    <div id="movie" class="well"></div>
  </div>
  <button id="favourite">Add to Favourites</button>
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/movie.js"></script>
</body>

</html>