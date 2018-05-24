<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="This is a sample description">
	    <meta name="author" content="Sandesh Pokhrel">
	    <title>Training</title>
	    <spring:url value="/resources/css" var="css" />
		<spring:url value="/resources/js" var="js" />
		<spring:url value="/resources/images" var="images" />
		<spring:url value="/resources/vendor" var="vendor" />
		<c:set var="root" value="${pageContext.request.contextPath}"/>
		<script>window.context = '${root}'</script>
	  
	    <!-- Bootstrap core CSS-->
	    <link href="${vendor }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <!-- Custom fonts for this template-->
	    <link href="${vendor }/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <!-- Page level plugin CSS-->
	    <link href="${vendor }/datatables/dataTables.bootstrap4.css" rel="stylesheet">
	    <!-- Custom styles for this template-->
	    <link href="${css }/sb-admin.css" rel="stylesheet">
	</head>

	<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	
		<!-- Navbar Goes Here -->
		<%@ include file="/WEB-INF/jsp/include/navbar.jsp" %>
		
		<div class="content-wrapper">
    		<div class="container-fluid">
    			<c:if test="${action eq null }">
    				<%@ include file="/WEB-INF/jsp/dashboard.jsp" %>
    			</c:if>
    			
    			<c:if test="${action eq 'addstudent' }">
    				<%@ include file="/WEB-INF/jsp/add_student.jsp" %>
    			</c:if>
    			
    			<c:if test="${action eq 'liststudent' }">
    				<%@ include file="/WEB-INF/jsp/list_student.jsp" %>
    			</c:if>
    			
    			<c:if test="${action eq 'viewstudent' }">
    				<%@ include file="/WEB-INF/jsp/view_student.jsp" %>
    			</c:if>
    			
    			<c:if test="${action eq 'updatestudent' }">
    				<%@ include file="/WEB-INF/jsp/update_student.jsp" %>
    			</c:if>
    			
    			<c:if test="${action eq 'addcourse' }">
    				<%@ include file="/WEB-INF/jsp/add_course.jsp" %>
    			</c:if>
    			
    			<c:if test="${action eq 'addcourseenroll' }">
    				<%@ include file="/WEB-INF/jsp/add_course_enroll.jsp" %>
    			</c:if>
    			
    			<c:if test="${action eq 'listcourse' }">
    				<%@ include file="/WEB-INF/jsp/list_course.jsp" %>
    			</c:if>
    			
    			<c:if test="${action eq 'updatecourse' }">
    				<%@ include file="/WEB-INF/jsp/update_course.jsp" %>
    			</c:if>
    			
    			<c:if test="${action eq 'listinstallment' }">
    				<%@ include file="/WEB-INF/jsp/list_installment.jsp" %>
    			</c:if>
    		</div>
    	</div>
    	
    	<!-- Footer Goes Here -->
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	
		<!-- Bootstrap core JavaScript-->
	    <script src="${vendor }/jquery/jquery.min.js"></script>
	    <script src="${vendor }/bootstrap/js/bootstrap.bundle.min.js"></script>
	    <!-- Core plugin JavaScript-->
	    <script src="${vendor }/jquery-easing/jquery.easing.min.js"></script>
	    <!-- Page level plugin JavaScript-->
	    <script src="${vendor }/chart.js/Chart.min.js"></script>
	    <script src="${vendor }/datatables/jquery.dataTables.js"></script>
	    <script src="${vendor }/datatables/dataTables.bootstrap4.js"></script>
	    <!-- Custom scripts for all pages-->
	    <script src="${js }/sb-admin.min.js"></script>
	    <!-- Custom scripts for this page-->
	    <script src="${js }/sb-admin-datatables.min.js"></script>
	    <script src="${js }/sb-admin-charts.min.js"></script>
	    
	    <!-- My JavaScript -->
	    <script src="${js }/app.js"></script>
	</body>
</html>