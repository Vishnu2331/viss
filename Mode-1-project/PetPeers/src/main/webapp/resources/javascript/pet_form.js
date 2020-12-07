function validateform() 
{ 
	var age=document.forms["petForm"]["petAge"].value;  
	  

if(age>2 && age<100) 
{ 
	
return true;
}
else
{	
   document.getElementById("message").innerHTML ="Age should be between 2 and 100";
return false;
}
} 