<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3 style="color:red;">${message}</h3>
<div class="container">
  <h2>Pet List</h2>            
  <table class="table">
    <thead>
      <tr>
        <th>#</th>
        <th>Pet Name</th>
        <th>Pet Age</th>
        <th>Pet Place</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="list" items="${myPets}">
      <c:set var = "Owner" value = "${list.owner.getUserId()}"/>
      <c:set var = "User"  value = "${userId}"/>
      <c:if test="${Owner==User}">
			<tr>
				<td>${list.getPetId()}</td>
				<td> ${list.getPetName()} </td>
				<td>${list.getPetAge()} </td>
				<td>${list.getPetPlace()}</td>
			</tr>
		</c:if>
	</c:forEach>
    </tbody>
  </table>
</div>