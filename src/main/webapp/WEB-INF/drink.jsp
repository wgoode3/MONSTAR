<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:_layout>
	<div class="row">
	   <div class="col-sm-8">
            <div class="card mb-3">
                <div class="card-header bg-dark text-light">${drink.brand} ${drink.name}</div>
                <div class="card-body">
                    <p>${drink.calories} Calories</p>
                    <p>${drink.description}</p>
                </div>
            </div>
            <ul class="list-group">
                <li class="list-group-item bg-dark text-light">Reviews</li>
                <c:forEach items="${drink.reviews}" var="review">
                    <li class="list-group-item">
                        ${review.rating} stars
                        ${review.content}
                    </li>
                </c:forEach>
            </ul>
	    </div>
        <div class="col-sm-4">
            <div class="card">
                <div class="card-header bg-dark text-light">Leave a Review</div>
                <div class="card-body">
                    <form:form action="/drink/${drink.id}/review" method="post" modelAttribute="review">
                        <input type="hidden" name="user" value="${user.id}" />
                        <input type="hidden" name="drink" value="${drink.id}" />
                        <div class="form-group">
                            <label>Rating:</label>
                            <select name="rating" class="form-control">
                                <option>5</option>
                                <option>4</option>
                                <option selected>3</option>
                                <option>2</option>
                                <option>1</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Review:</label>
                            <form:textarea path="content" class="form-control" />
                            <form:errors path="content" class="text-danger" />
                        </div>
                        <input type="submit" value="Leave a Review" class="btn btn-block btn-dark" />
                    </form:form>                           
                </div>
            </div>
        </div>
    </div>
</t:_layout>
