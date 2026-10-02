function matchPassword() {  
    var pw1 = document.getElementById("newPassword");  
    var pw2 = document.getElementById("confirmPassword"); 
    if(pw1.value != pw2.value)  
    {   
      swal("Message NRIFT Canteen","Passwords did not match");  
      return false;
    } else {  
    var x = document.getElementsByTagName("form");
        console.log(x);
        x[0].submit();
      
    }  
  } 
  
  
  
  var msg=document.getElementById('passwordMsg');
  if(msg.innerText === "Password Updated Successfully"){
	
	
	msg.style.color = "green";
	msg.style.fontWeight = "bold";
	
	
}else if(msg.innerText === "Incorrect Old Password"){
	msg.style.color = "red";
	msg.style.fontWeight = "bold";
}