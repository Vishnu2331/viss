<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
  <h2>Pet List</h2>            
  <table class="table">
    <thead>
      <tr>
        <th>#</th>
        <th>Pet Name</th>
        <th>Pet Age</th>
        <th>Pet Place</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="list" items="${list1}">
			<tr>
				<td>${list.getPetId()}</td>
				<td> ${list.getPetName()} </td>
				<td>${list.getPetAge()} </td>
				<td>${list.getPetPlace()}</td>
				<td><c:choose>
						<c:when test="${list.getOwner()==NULL}">
						<form action="buy" method="post">
						 <input type="hidden" id="custId" name="petId" value="${list.getPetId()}" />
						  <input type="hidden" id="custId" name="userId" value="${userId}" />
						  <input type="submit" value="buy" />
						</form>
						</c:when>
						<c:otherwise>  
                          <button name="sold" value="sold" disabled="disabled">sold</button> 
                         </c:otherwise>
					</c:choose></td>
			</tr>
		
	</c:forEach>
    </tbody>
  </table>
</div>
