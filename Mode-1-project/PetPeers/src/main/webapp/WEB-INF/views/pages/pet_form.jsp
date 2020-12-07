<form action="addpet" method="post" name="petForm" onsubmit="return validateform()">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to add Pet.</p>
    <p style="color:green;">${message}</p>
    <hr>

    <label for="Pet Name"><b>Pet Name</b></label>
    <input type="text" placeholder="Enter Pet Name" name="petName" id="petName" required>
   
   <label id="message" style="color:red;"></label><br/>
    <label for="pet Age"><b>Pet Age</b></label>
    <input type="text" placeholder="Enter Pet Age" name="petAge" id="petAge" required>

    <label for="pet Place"><b>Pet Place</b></label>
    <input type="text" placeholder="Enter Pet Place" name="petPlace" id="petPlace" required>

    <button type="submit" class="registerbtn">Register</button>
  </div>`
  

</form>