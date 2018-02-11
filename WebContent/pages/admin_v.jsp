<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>QCM APP | Admin</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="content/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="content/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="content/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="content/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
  <link rel="stylesheet" href="content/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-red sidebar-mini">
<c:if test="${sessionScope.user == null}">
	<logic:redirect forward="welcome"/>
</c:if>
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="#" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>Q</b>CM</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>QCM</b> MANAGER</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      	<jsp:include page="logout.jsp" />
      </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
     	<jsp:include page="userAside.jsp" />
      <!-- search form (Optional) -->
      <!--form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">OPTIONS</li>
        <!-- Optionally, you can add icons to the links -->
        <li class="treeview active">
          <a href="#"><i class="fa fa-cogs"></i> <span>Manage accounts</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
             </span>
          </a>
          <ul class="treeview-menu">
          	<li><a href="./admin.do">All the accounts</a></li>
            <li class="active"><a href="./admin_v.do">Validate a teacher account</a></li>
            <li><a href="./admin_d.do">Delete an account</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Home
        <small>The administrator Home Page</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Home</li>
        <li class="active">Validate</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
        <%int i = 0; %>
        <c:forEach items="${sessionScope.teachers}" var="teacher">  
        	<c:if test="${!teacher.isActivated()}">
	        	<div class="col-md-4">
		          <!-- Widget: user widget style 1 -->
		          <div class="box box-widget widget-user">
		            <!-- Add the bg color to the header using any of the bg-* classes -->
		            <c:if test="${teacher.getSex().equals('Man')}">
	   					 <div class="widget-user-header bg-aqua-active">
		   					 <h3 class="widget-user-username">${teacher.getFirstname()} ${teacher.getSurname()}</h3>
			                 <h5 class="widget-user-desc">Teacher</h5>
			             </div>
			  		</c:if>
	                <c:if test="${teacher.getSex().equals('Woman')}">
	   					 <div class="widget-user-header bg-black" style="background: url('./content/dist/img/photo1.png') center center;">
	           				 <h3 class="widget-user-username">${teacher.getFirstname()} ${teacher.getSurname()}</h3>
			                 <h5 class="widget-user-desc">Teacher</h5>
			             </div>
	           		</c:if> 
		            <div class="widget-user-image">
		            	<c:if test="${teacher.getSex().equals('Man')}">
		   					<img src="content/dist/img/user1-128x128.jpg" class="img-circle" alt="User Image">
				  		</c:if>
		                <c:if test="${teacher.getSex().equals('Woman')}">
		   					<img src="content/dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
				  		</c:if> 
		              </div>
		            <div class="box-footer">
		              <div class="row">
		                <div class="col-sm-4 border-right">     
	                		<c:if test="${teacher.isActivated()}">
								<a class="btn btn-app btn-success" href="./teacher_dea.do?teacherId=<% out.println(i);%>">
			                		<i class="fa fa-edit"></i>
					   					Deactivate
			   					</a>
					  		</c:if>
			                <c:if test="${!teacher.isActivated()}">
			                 	<a class="btn btn-app btn-success" href="./teacher_act.do?teacherId=<% out.println(i);%>">
			                		<i class="fa fa-edit"></i>
					   					Activate
			   					</a>
					  		</c:if>	
		                  <!-- /.description-block -->
		                </div>
		                <!-- /.col -->
		                <div class="col-sm-4 border-right">
		                </div>
		              </div>
		              <!-- /.row -->
		            </div>
		          </div>
		          <!-- /.widget-user -->
		        </div>
	        </c:if>	
	        <%i++; %>
		</c:forEach>        
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
	Practice makes perfect
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2018 <a href="#">UVSQ/Paris-Saclay#M2_Datascale</a>.</strong> All rights reserved.
  </footer>

  </div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="content/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="content/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="content/dist/js/adminlte.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>