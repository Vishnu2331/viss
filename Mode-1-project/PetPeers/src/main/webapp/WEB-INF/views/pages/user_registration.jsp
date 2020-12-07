
<form action="insert" method="post" name="registration"
	onsubmit="return validateform()">
	<div class="container">
		<h1>Register</h1>
		<p>Please fill in this form to create an account.</p>
		<p style="color: red;">
			<b>${errorMessage}</b>
		<p>
		<hr>
		<label for="email"><b>Email</b></label> <input type="email"
			placeholder="Enter Email" name="userEmail" id="email" required>

		<label id="message" style="color: red;"></label> <br> <label
			for="psw"><b>Password</b></label> <input type="password"
			placeholder="Enter Password" name="userPassword" id="psw" required>
		<label id="message1" style="color: red;"></label> <br> <label
			for="psw-repeat"><b>Repeat Password</b></label> <input
			type="password" placeholder="Repeat Password" name="confirmPassword"
			id="psw-repeat" required>
		<hr>

		<button type="submit" class="registerbtn">Register</button>
	</div>
	`

	<div class="container signin">
		<p>
			Already have an account? <a
				href="${pageContext.request.contextPath}/login">Sign in</a>.
		</p>
	</div>
</form>