<form action="signin" method="post">
	<div class="container">
		<h1>Login</h1>
		<p>Please fill in this form to Log into your Account</p>
	    <p style="color:red;"><b>${errorMessage}</b><p>
	    <p style="color:green;"><b>${Message}</b><p>
		<hr> 
		<label for="email"><b>Email</b></label> <input type="email"
			placeholder="Enter Email" name="userEmail" id="email" required>
		<label for="psw"><b>Password</b></label> <input type="password"
			placeholder="Enter Password" name="userPassword" id="psw" required>

		<button type="submit" class="registerbtn">login</button>
	</div>

	<div class="container signin">
		<p>
			Not a member? <a href="${pageContext.request.contextPath}/signup">Sign
				up</a>.
		</p>
	</div>
</form>