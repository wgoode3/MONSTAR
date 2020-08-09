<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:Layout> 
	<c:forEach items="${drinks}" var="drink">
	    <div class="card mb-5">
	       <div class="card-header bg-dark text-light">${drink.brand} ${drink.name}</div>
	       <div class="card-body">	           
		      <p>${drink.calories} Cal</p>
		      <p>${drink.description}</p>
	       </div>
	    </div>
	</c:forEach>
</t:Layout>