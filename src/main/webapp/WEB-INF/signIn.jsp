<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:_layout>
    
    <div class="row">
    
        <!-- Registration Form -->
        <div class="col-sm-6">
            <div class="card">
                <div class="card-header bg-dark text-light">Sign Up</div>
                <div class="card-body">
                    <form:form action="/sign_up" method="post" modelAttribute="user">
	                    <div class="form-group">
	                        <label>Username:</label>
	                        <form:input path="username" class="form-control" />
	                        <form:errors path="username" class="text-danger" />
	                    </div>
	                    <div class="form-group">
	                        <label>Email:</label>
	                        <form:input path="email" class="form-control" />
	                        <form:errors path="email" class="text-danger" />
	                    </div>
	                    <div class="form-group">
	                        <label>Password:</label>
	                        <form:password path="password" class="form-control" />
	                        <form:errors path="password" class="text-danger" />
	                    </div>
	                    <div class="form-group">
	                        <label>Confirm:</label>
	                        <form:password path="confirm" class="form-control" />
	                        <form:errors path="confirm" class="text-danger" />
	                    </div>
                        <input type="submit" value="Sign Up" class="btn btn-block btn-dark" />
                    </form:form>
                </div>
            </div>
        </div>
        
        <!-- Login Form -->
        <div class="col-sm-6">
            <div class="card">
                <div class="card-header bg-dark text-light">Sign In</div>
                <div class="card-body">
                    <c:if test="${ validLogin == false }">
                        <p class="text-danger">Invalid login attempt!</p>
                    </c:if>
                    <form action="/sign_in" method="post">
                        <div class="form-group">
                            <label>Email:</label>
                            <input type="text" name="email" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" name="password" class="form-control" />
                        </div>
                        <input type="submit" class="btn btn-block btn-dark" value="Sign In" />
                    </form>
                </div>
            </div>
        </div>
    
    </div>
</t:_layout>
