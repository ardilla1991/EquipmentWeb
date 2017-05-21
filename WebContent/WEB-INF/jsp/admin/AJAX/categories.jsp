<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		  		</c:forEach>
              </tbody>
            </table>