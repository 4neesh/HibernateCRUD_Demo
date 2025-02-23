<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
</head>

<body>

<div id="wrapper">
	<div id="header">
	
	<h2>CRM - Customer Relationship Manager</h2>	
	</div>
</div>

<div id="container">

<div id="content">

<input type="button" class="add-button" value="Add Customer" 
		onclick="window.location.href='showFormForAdd';return false;"/>
	
<!--  add our html table -->

<table>
	<tr>
		<th>First name</th>
		<th>Last name</th>
		<th>Email</th>
		<th>Action</th>
	</tr>

	<!-- loop over and print the customers -->
	<c:forEach var="tempCustomer" items="${customer}">
	<c:url var="updateLink" value="/customer/showFormForUpdate">
		<c:param name="customerId" value="${tempCustomer.id}"/>
	</c:url>
	<c:url var ="deleteLink" value="/customer/delete">
		<c:param name="customerId" value="${tempCustomer.id }"/>
	</c:url>
		
		<tr>
			<td>${tempCustomer.firstName }</td>
			<td>${tempCustomer.lastName }</td>
			<td>${tempCustomer.email }</td>
			<td>
				<a href="${updateLink}">Update</a> | 
				
				<a onclick="if (!(confirm('Are you sure you would like to delete?')))return false" 
				href="${deleteLink}">Delete</a>
			</td>
		</tr>
	</c:forEach>


</table>


</div>

</div>

</body>

</html>

