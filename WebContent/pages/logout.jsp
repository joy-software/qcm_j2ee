 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
                    <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <c:choose> 
  					<c:when test="${sessionScope.user.getType() == 0}">
    		 			<img src="content/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
  					</c:when>
  					<c:otherwise>
				    	<c:if test="${sessionScope.user.getSex().equals('Man')}">
		   					<img src="content/dist/img/user1-128x128.jpg" class="user-image" alt="User Image">
				  		</c:if>
		                <c:if test="${sessionScope.user.getSex().equals('Woman')}">
		   					<img src="content/dist/img/user3-128x128.jpg" class="user-image" alt="User Image">
				  		</c:if>
				  	</c:otherwise>
			  </c:choose>
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">${sessionScope.user.getFirstname()} ${sessionScope.user.getSurname()}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
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
              	
                <p>
                  ${sessionScope.user.getFirstname()} ${sessionScope.user.getSurname()}
                 <c:if test="${sessionScope.user.getType() == 0}">
   					<small>Administrator</small>
		  		</c:if>
		  		<c:if test="${sessionScope.user.getType() == 1}">
   					<small>Teacher</small>
		  		</c:if>
                <c:if test="${sessionScope.user.getType() == 2}">
   					<small>Student</small>
		  		</c:if>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="./Logout.do" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
