<%@page session="false"%>
<!DOCTYPE html>
<html>
<head><style type="text/css">
.form-1 {
    /* Size & position */
    width: 400px;
    margin: 80px auto 30px;
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
<body bgcolor="white">
	<div align="center">
		<p>
		<h1>WELCOME TO REGISTRATION PAGE</h1>
		</p>
	</div>
	<div align="center">
		<form name="registrationForm" action="registration" method="post"
			class="form-1">
			<table>
				<tr> 
					<td>First Name</td>
					
					<td><input type="text" name="firstName"></td>
				</tr>
			

				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"></td>
				</tr>

				<tr>
					<td>E-mail Id</td>
					<td><input type="text" name="emailId"></td>
				</tr>

				<tr>
					<td>Department</td>
					<td><input type="text" name="department"></td>
				</tr>

				<tr>
					<td>Designation</td>
					<td><input type="text" name="designation"></td>
				</tr>

				<tr>
					<td>Pancard</td>
					<td><input type="text" name="pancard"></td>
				</tr>

				<tr>
					<td>YearlyInvestmentUnder80C</td>
					<td><input type="text" name="yearlyInvestmentUnder80C"></td>
				</tr>

				<tr>
					<td>Basic Salary</td>
					<td><input type="text" name="basicSalary"></td>
				</tr>

				<tr>
					<td>EPF</td>
					<td><input type="text" name="epf"></td>
				</tr>

				<tr>
					<td>CompanyPF</td>
					<td><input type="text" name="companyPf"></td>
				</tr>

				<tr>
					<td>Account Number</td>
					<td><input type="text" name="accountNumber"></td>
				</tr>

				<tr>
					<td>Bank Name</td>
					<td><input type="text" name="bankName"></td>
				</tr>

				<tr>
					<td>IFSC Code</td>
					<td><input type="text" name="ifscCode"></td>
				</tr>

			</table>
			<br> <input type="submit" name="submit"> <input
				type="reset" name="reset">
		</form>
	</div>
</body>
</html>