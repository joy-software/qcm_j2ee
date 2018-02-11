<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<title>quiz | Create Account</title>
	<link rel="stylesheet" href="content/css/bootstrap.css">
	<link rel="stylesheet" href="content/select2/dist/css/select2.min.css">
			
</head>
<body>

  
  <div class="row" ><br><br><br>
    <div class="col-md-4"></div>
    <div class="col-md-4">
      <section class="login-form">
        <form method="post" action="s_Register.do" role="login">
		  <img src="content/img/quizLogin.png" class="img-responsive" alt="" />
		  <input type="text" name="numStudent" placeholder="NumStudent"  class="form-control input-lg" required/>       
          <input type="text" name="firstname" placeholder="FirstName"  class="form-control input-lg" pattern=".{3,}" required/>       
          <input type="text" name="surname" placeholder="LastName"  class="form-control input-lg" pattern=".{3,}" required/>       
		  <select class="form-control select2" style="width: 100%;" tabindex="-1" aria-hidden="true" name="sex">
                  <option selected="selected">Man</option>
                  <option>Woman</option>
		  </select>
		  <input type="text" name="login" placeholder="Login"  class="form-control input-lg" pattern=".{3,}" required/>       
		  <c:if test="${not empty sessionScope.badlogin}">
   				<label style="color: red;">${sessionScope.badlogin}</label>
		  </c:if>
		  <input type="password" name="password" class="form-control input-lg" id="password" placeholder="Password" pattern=".{8,}" required/>          
		  <button type="submit" name="save" class="btn btn-lg btn-primary btn-block">Save</button> 
		</form>
      </section>  
    </div>
      

  </div>
   
    <script src="content/jquery/dist/jquery.min.js"></script>
 	<script src="content/select2/dist/js/select2.full.min.js"></script>
 	<script src="content/js/app.js"></script>
</body>
</html>