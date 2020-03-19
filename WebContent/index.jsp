<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Data from url:</h2>


	<table border="1">

		<th>ID</th>
		<th>Body</th>
		<th>PostID</th>

		<c:forEach var="emp" items="${listEmp}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${emp.id}</td>
				<td>${emp.body}</td>
				<td>${emp.postId}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>
