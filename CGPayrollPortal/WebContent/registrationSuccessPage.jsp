
<!DOCTYPE html>
<%@page import="com.cg.payroll.beans.Associate"%>
<%@page session="false" %>
<html>
<body>
	<div align="left">
		<font color="green" size="10">Associate Id :
			${sessionScope.associate.associateId} </font>
		<table>
			<tr>
				<td><a href="indexPage.jsp">Home Page</a></td>
			</tr>
		</table>
	</div>
</body>
</html>