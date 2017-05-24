<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a onclick="getContent('categoryContent',  'MainServlet?action=equipment_list_by_category&category_id=${category_id}')" href="#">Go back</a>

<form >
	<table class="table table-striped">
              <thead>
                <tr>
                  <th>Param title</th>
                  <th>Param value</th>
                </tr>
              </thead>
              <tbody>
              		<tr>
              			<td>Model</td>
              			<td><input type="text" name="model" /></td>	
              		</tr>
              		<tr>
              			<td>Person category</td>
              			<td>
              				<select name="category_id">
              					<c:forEach items="${person_categories}" var="category">
              						<option value="${category}"><c:out value="${category}" /></option>
              					</c:forEach>
              				</select>
						</td>	
              		</tr>
              		              		
	                <c:forEach items="${equipment.getParameters()}" var="parameter">
						<tr> 
						     <td> <c:out value="${parameter.getTitle()}"/> </td>
						     <td><input type="text" name="param_${parameter.getId()}" /></td>
						</tr>
			  		</c:forEach>
              </tbody>
            </table>
</form>