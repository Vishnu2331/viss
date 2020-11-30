function validateform() {
	var password = document.forms["registration"]["userPassword"].value;
	var repeatpPassword = document.getElementById("psw-repeat").value;
	var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
	if (password.match(decimal)) {
		
		if (password!=repeatpPassword) {
			
			document.getElementById("message1").innerHTML = "Password and Repeat Password should be same";
			return false;
		} else {
			
			return true;
		}
	} else {
		document.getElementById("message").innerHTML = "Password should contain atleast one Uppercase and lower case and length should between 8 and 15";
		return false;
	}
}