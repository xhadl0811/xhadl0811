<%@ page pageEncoding="utf-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
    <head>
    	<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
		<link rel="stylesheet"  href="/myapp/resources/css/tiles.css" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <c:url var="bootstrap" value="/css/bootstrap.min.css" />
        <link href="${ bootstrap }" rel="stylesheet">
    </head>
    <body>
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="content" />

      
    </body>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <Script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></Script>
    <Script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <Script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></Script>
</html>