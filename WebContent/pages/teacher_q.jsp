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
  <title>QCM APP | Teacher</title>
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
<body class="hold-transition skin-green sidebar-mini">
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
  		<c:choose> 
			<c:when test="${sessionScope.qcms.isEmpty()}">
		 		 <li class="active"><a href="./createqcm.do"><i class="fa fa-edit"></i> <span>Create a QCM</span></a></li>
		 	</c:when>
			<c:otherwise>
				 <li ><a href="./teacher.do"><i class="fa fa-home"></i> <span>All QCM</span></a></li>
        		 <li><a href="./createqcm.do"><i class="fa fa-edit"></i> <span>Create a QCM</span></a></li>
	        </c:otherwise>
	    </c:choose>
            
        <li class=""><a href="#"><i class="fa fa-refresh"></i> <span>Update a QCM</span></a></li>
        <li class="active"><a href="#"><i class="fa fa-link"></i> <span>Add some questions</span></a></li>
        <li class=""><a href="#"><i class="fa fa-trash"></i> <span>Delete a QCM</span></a></li>
        <!--li class="treeview active">
          <a href="#"><i class="fa fa-link"></i> <span>Manage accounts</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
             </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#">Validate a teacher account</a></li>
            <li><a href="#">Delete an account</a></li>
          </ul>
        </li!-->
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
        <small>Teacher Home</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Create a QCM</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
    <div class="box box-warning">
            <div class="box-header with-border">
              <h3 class="box-title">New Question</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <form role="form" method="post" action="createQuestion.do">
                <!-- text input -->
                <div class="form-group">
                  <label>Entitled</label>
                  <input type="text" class="form-control" placeholder="Enter ..." name="entitled">
                </div>
                
				<div class="box-footer">
                	<button type="submit" class="btn btn-info pull-right">Save</button>
             	</div>	
              </form>
            </div>
	            <!-- /.box-body -->
	</div> 					
    <c:choose> 
		<c:when test="${!sessionScope.selectedQcm.getQuestions().isEmpty()}">
		
   	<div class="box box-primary">
           <div class="box-header ui-sortable-handle" style="cursor: move;">
             <i class="ion ion-clipboard"></i>

             <h3 class="box-title">${sessionScope.selectedQcm.getName()}</h3>


			 <div class="box-body">
                <div class="form-group">
                  <label>Description</label>
                  <textarea class="form-control" rows="3" placeholder="${sessionScope.selectedQcm.getDescription()}" disabled></textarea>
                </div>
                <%int i = 0; %>
        		<c:forEach items="${sessionScope.quests}" var="question" varStatus="loop">  
	                <div class="form-group">
	                
	                  <label><%out.println(i+1); %>${"."} ${question.getEntitled()}</label>
	                  
	                   <c:forEach items="${sessionScope.questions.get(loop.index)}" var="answer">  
			                   <div class="checkbox">
			                    <label>
			                      <input type="checkbox">
			                      ${answer.getValue()}
			                    </label>
			                  </div>
		                  </c:forEach>
	                 
	                
	                  <div class="box box-warning">
			            <div class="box-header with-border">
			              <h3 class="box-title">New Answer</h3>
			            </div>
			            <!-- /.box-header -->
			            <div class="box-body">
			              <form role="form" method="post" action="createAnswer.do?questionId=<% out.println(i);%>">
			                <!-- text input -->
			                <div class="form-group">
			                  <label>Value</label>
			                  <input type="text" class="form-control" placeholder="Enter ..." name="value">
			                </div>
			                
							<div class="box-footer">
			                	<button type="submit" class="btn btn-info pull-right">Save</button>
			             	</div>	
			              </form>
			            </div>
				            <!-- /.box-body -->
					</div>
	                 
	                 </div>
	                <%i++; %>
                </c:forEach>
	          </div>

              
            </div>
            
          </div>
 		</c:when>
 	</c:choose>
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