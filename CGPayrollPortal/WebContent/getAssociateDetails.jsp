<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
<head><style type="text/css">
.form-1 {
    /* Size & position */
    width: 300px;
    margin: 60px auto 30px;
    padding: 10px;
    position: relative; /* For the submit button positioning */

    /* Styles */
    box-shadow: 
        0 0 1px rgba(0, 0, 0, 0.3), 
        0 3px 7px rgba(0, 0, 0, 0.3), 
        inset 0 1px rgba(255,255,255,1),
        inset 0 -3px 2px rgba(0,0,0,0.25);
    border-radius: 5px;
    background: linear-gradient(#eeefef, #ffffff 10%);
}

.form-1 .field {
    position: relative; /* For the icon positioning */
}
</style></head>
<body>
	<div align="center">
		<p>
		<h1>WELCOME TO GetAssociateDetails PAGE</h1>
		</p>
	</div>
	<div align="center">
		<form name="associateDetailsForm" action="getAssociate" method="post" class="form-1">
			<table>
				<tr>
					<td>Enter Associate Id</td>
					<td><input type="text" name="associateId"></td>
				</tr>
			</table>
			<input type="submit" name="print">
		</form>
	</div>

</body>
</html>