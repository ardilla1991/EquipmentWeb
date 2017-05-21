<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin page</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="styles/dashboard.css">
	</head>
	<body> 
	 	
	<%@include file="additional/header.jsp"%>

	    <div class="container-fluid">
	      <div class="row">
	      
	        <%@include file="additional/leftCol.jsp"%>
	        
	        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	          <h1 class="page-header">Rented Equipment</h1>
	
	          <div class="row placeholders">
	            <div class="col-xs-6 placeholder">
	              <div class="tab-rented-list tab-title active">By last hour</div>
	            </div>
	            <div class="col-xs-6 placeholder">
	              <div class="tab-rented-list tab-title">By last day</div>
	            </div>
	          </div>
	
	          <!-- h2 class="sub-header">Rented Equipment</h2 -->
	          <div class="table-responsive">
	            <table class="table table-striped tab-content tab-active">
	              <thead>
	                <tr>
	                  <th>#</th>
	                  <th>Model</th>
	                  <th>Price</th>
	                  <th>PersonCategory</th>
	                </tr>
	              </thead>
	              <tbody>
	                <c:forEach items="${list_eq}" var="i">
				     	<tr> 
				     		<td> <c:out value="${i.getId()}"/> </td>
				    		<td> <c:out value="${i.getModel()}" /> </td>
				     		<td> <c:out value="${i.getPrice()}" /> </td>
				     		<td> <c:out value="${i.getPersonCategory()}" /> </td>
				     	</tr>
			  		</c:forEach>
	              </tbody>
	            </table>
	            <table class="table table-striped tab-content">
	              <thead>
	                <tr>
	                  <th>#</th>
	                  <th>Model</th>
	                  <th>Price</th>
	                  <th>PersonCategory</th>
	                </tr>
	              </thead>
	              <tbody>
	                <c:forEach items="${list_eq}" var="i">
				     	<tr> 
				     		<td> <c:out value="${i.getId()}"/> </td>
				    		<td> <c:out value="${i.getModel()}" /> </td>
				     		<td> <c:out value="${i.getPrice()}" /> </td>
				     		<td> <c:out value="${i.getPersonCategory()}" /> </td>
				     	</tr>
			  		</c:forEach>
	              </tbody>
	            </table>
	          </div>
	        </div>
	      </div>
	    </div>
	  	
	   	<%@include file="additional/footer.jsp"%>
	  	
	</body>
</html>