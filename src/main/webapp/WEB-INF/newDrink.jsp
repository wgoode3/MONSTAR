<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:_layout>  
    <div class="row">
        <div class="col-sm-8 offset-sm-2">
            <div class="card">
                <div class="card-header bg-dark text-light">Add a Drink</div>
                <div class="card-body">
                    <form:form action="/drinks" method="post" modelAttribute="drink">
                        <div class="form-group">
                            <label>Brand:</label>
                            <form:input path="brand" class="form-control" />
                            <form:errors path="brand" class="text-danger" />
                        </div>
                        <div class="form-group">
                            <label>Name:</label>
                            <form:input path="name" class="form-control" />
                            <form:errors path="name" class="text-danger" />
                        </div>
                        <div class="form-group">
                            <label>Description:</label>
                            <form:textarea path="description" class="form-control" />
                            <form:errors path="description" class="text-danger" />
                        </div>
                        <div class="form-group">
                            <label>Calories:</label>
                            <form:input path="calories" class="form-control" />
                            <form:errors path="calories" class="text-danger" />
                        </div>
                        <input type="submit" value="Add a Drink" class="btn btn-block btn-dark" />
                    </form:form>	       	               
                </div>
            </div>
        </div>
    </div>
</t:_layout>
