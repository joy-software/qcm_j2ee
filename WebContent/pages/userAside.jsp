 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="user-panel">
        <div class="pull-left image">
         <c:choose> 
			<c:when test="${sessionScope.user.getType() == 0}">
		 			<img src="content/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
			</c:when>
			<c:otherwise>
		    	<c:if test="${sessionScope.user.getSex().equals('Man')}">
		 			<img src="content/dist/img/user1-128x128.jpg" class="img-circle" alt="User Image">
		  		</c:if>
		        <c:if test="${sessionScope.user.getSex().equals('Woman')}">
		 			<img src="content/dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
		  		</c:if>
		  	</c:otherwise>
		</c:choose>
        </div>
        <div class="pull-left info">
          <p>${sessionScope.user.getFirstname()} ${sessionScope.user.getSurname()}</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
 </div>
