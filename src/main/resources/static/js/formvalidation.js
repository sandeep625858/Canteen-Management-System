function validateForm() {
 
  var password = document.forms["registerForm"]["password"].value;
   var confirmpassword = document.forms["registerForm"]["confirmpassword"].value;
  var username = document.forms["registerForm"]["username"].value; 
       console.log(password);
        console.log(confirmpassword);
        console.log(username);
         
         
if(password != confirmpassword){
	alert("Password Doesnt Match");
	return false;
}else{
//alert("Registration Successful");
return true;
}
}


// Checking if a user already exists or not





