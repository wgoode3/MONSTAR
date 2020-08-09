<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MONST★R</title>
    <link rel="stylesheet" href="/node_modules/bootstrap/dist/css/bootstrap.min.css" />
</head>
<body>
    
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	    <a class="navbar-brand" href="">MONST★R</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
	    <div class="collapse navbar-collapse" id="navbarText">
	        <ul class="navbar-nav mr-auto">
	            <li class="nav-item">
	                <a class="nav-link" href="/">Home</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="/drinks/all">All Drinks</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="/drinks/new">New Drink</a>
	            </li>
	        </ul>
	        <a class="btn btn-info" href="/logout">Sign Out</a>
	    </div>
	</nav>
	
    <div class="container py-5">
        <jsp:doBody />
    </div>
    
    <script src="/js/nav.js"></script>

</body>
</html>
