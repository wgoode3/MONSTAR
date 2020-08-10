<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:_layout> 
	<c:forEach items="${drinks}" var="drink">
	    <div class="card mb-3">
	       <div class="card-header bg-dark text-light">${drink.brand} ${drink.name}</div>
	       <div class="card-body">	           
		      <p>${drink.calories} Calories</p>
		      <p>${drink.description}</p>
		      <a href="/drinks/${drink.id}" class="btn btn-outline-info">View</a>
		      <a href="/drinks/${drink.id}/edit" class="btn btn-outline-info">Edit</a>
	       </div>
	    </div>
	</c:forEach>
</t:_layout>
