<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta charset="utf-8">
	<title>Quiz | Authentification</title>
	<link rel="stylesheet" href="content/css/bootstrap.css">
			
</head>
<body>

  
  <div class="row" ><br><br><br>
  	<div class="col-md-4"></div>
    <div class="col-md-4">
      <section class="login-form">
        <form method="post" action="Login.do" role="login">
		  <img src="content/img/quizLogin.png" class="img-responsive" alt="" />
		  <c:if test="${not empty sessionScope.success}">
   				<label style="color: green;">${sessionScope.success}</label>
		  </c:if>
		  <c:if test="${not empty sessionScope.validate}">
   				<label style="color: red;">${sessionScope.validate}</label>
		  </c:if>
          <input  type="text" name="login" placeholder="Login"  class="form-control input-lg" required/>       
          	<c:choose>
     			<c:when test="${sessionScope.login == false}">
         			<label style="color: red;">Login or Password Incorrect</label>
     			</c:when>
     		</c:choose>
          <input type="password" class="form-control input-lg" name="password" placeholder="Password" required/>          
          <button type="submit" class="btn btn-lg btn-primary btn-block">Connect</button> 
        	<div>	
			<a href="./register.do">Create New Account</a>
         </div>
        </form>  
      </section>  
    </div>
      

  </div>
    
</body>
</html>