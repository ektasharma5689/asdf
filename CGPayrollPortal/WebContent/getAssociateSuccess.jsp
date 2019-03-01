<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<table>
		<tr>
			<td>First Name :</td>
			<td>${sessionScope.associate.firstName}</td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td>${sessionScope.associate.lastName}</td>
		</tr>
		<tr>
			<td>Department :</td>
			<td>${sessionScope.associate.department}</td>
		</tr>
		<tr>
			<td>Designation :</td>
			<td>${sessionScope.associate.designation}</td>
		</tr>
		<tr>
			<td>PanCard :</td>
			<td>${sessionScope.associate.pancard}</td>
		</tr>
		<tr>
			<td>EmailId :</td>
			<td>${sessionScope.associate.emailId}</td>
		</tr>
		<tr>
			<td>Yearly Investment :</td>
			<td>${sessionScope.associate.yearlyInvestmentUnder80C}</td>
		</tr>
	</table>
</body>
</html>