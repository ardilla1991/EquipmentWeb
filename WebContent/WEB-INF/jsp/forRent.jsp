<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/customTagLibrary" prefix="cg"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User page</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="styles/dashboard.css">
	</head>
	<body>  	
	  	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Sport Equipment</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="/EquipmentWeb">Exit</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="#">Rented</a></li>
            <li class="active"><a href="#">Available</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Available for rent</h1>
		  <div class="makeOrder">
		  	<div><span>Total price: </span><span id="totalCalc">0</span></div>
		  	<form action="MainServlet" method="GET">
		  		<input type="hidden" name="action" value="make_order" />
		  		<input id="equipments_ids" type="hidden" name="equipments_ids" value="" />
		  		<input type="submit" value="make order" onclick="return makeOrder();"/>
		  	</form>
		  </div>
          <div class="row placeholders">
            <div class="col-xs-6 placeholder">
              <div class="tab-rented-list tab-title active">Equipments</div>
            </div>
          </div>

          <!-- h2 class="sub-header">Rented Equipment</h2 -->
          <div class="table-responsive">
            <table class="table table-striped tab-content tab-active">
              <thead>
                <tr>
                  <th>Choose</th>
                  <th>#</th>
                  <th>Model</th>
                  <th>Price</th>
                  <th>Weight</th>
                  <th>Width</th>
                  <th>Height</th>
                  <th>PersonCategory</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${list_eq}" var="equip">
                	<c:choose>
	                	<c:when  test="${equip.getCategoryId()==1}">
					     	<tr> 
					     		<td> <input id="${equip.getId()}" class="eq_check" type="checkbox" name="choosedIds[]" value="${equip.getId()}"/></td>
					     		<td> <c:out value="${equip.getId()}"/> </td>
					    		<td> <c:out value="${equip.getModel()}" /> </td>
					     		<td id="price_${equip.getId()}"> <c:out value="${equip.getPrice()}" /> </td>
					     		<td> <c:out value="${equip.getWeight()}" /> </td>
					     		<td> <c:out value="${equip.getWidth()}" /> </td>
					     		<td> <c:out value="${equip.getHeight()}" /> </td>
					     		<td> <c:out value="${equip.getPersonCategory()}" /> </td>
					     	</tr>
				     	</c:when>
			     	</c:choose>
		  		</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
	  	
	 <script
			  src="http://code.jquery.com/jquery-2.2.4.min.js"
			  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
			  crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	</body>
</html>