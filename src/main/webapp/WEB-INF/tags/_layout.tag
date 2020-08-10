<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MONST★R</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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
	        <% if (session.getAttribute("user") == null) { %>
	           <a class="btn btn-outline-info" href="/sign_in">Sign In</a>
		    <% } else {%>
    	        <form action="/sign_out" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" class="btn btn-outline-danger" value="Sign Out" />                        
                </form>
		    <% } %>
	    </div>
	</nav>
	
    <div class="container py-3">
        <jsp:doBody />
    </div>
    
    <script src="/js/nav.js"></script>

</body>
</html>
