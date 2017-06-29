function email(){
	var a = document.getElementById("usr").value;
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (a.match(mailformat)) {
		document.getElementById("p1").innerHTML = "";
	return true;
	} else {
	document.getElementById("p1").innerHTML = "Enter valid email !";
	return false;

	}
}

function pass1(){
	var pwd1 = document.getElementById("pwd").value;
    var regularExpression  = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
    if(pwd1.length< 6|| pwd1.length > 12){
	console.log("lenght prob");   
	document.getElementById("p2").innerHTML = "length must valid!";     
	return false;
    }
    else if(!regularExpression.test(pwd1)) {
	document.getElementById("p2").innerHTML = "contains atleast one char and special symbol !";
	console.log("format prob");
 	return false;
    }
    else{
    	document.getElementById("p2").innerHTML = "";
    	return true;
    }
}

function id1(){
var id = document.getElementById("usrid").value;
var numbers = /^[0-9]+$/;
	if (id.match(numbers)) {
		document.getElementById("p3").innerHTML = "";
	return true;
	} else {
	document.getElementById("p3").innerHTML = "Enter valid id !";
	return false;

	}
}

function name1(){
var name = document.getElementById("usrname").value;
var letters = /^[A-Za-z]+$/;
if (name.match(letters)) {
	document.getElementById("p4").innerHTML = "";
	return true;
	} else {
	document.getElementById("p4").innerHTML = "Enter valid name !";
	return false;

	}
}

function validateuserreg() {
	console.log("userreg");
	if ((name1() == true) && (id1() == true)
			&& (pass1() == true) && (email() == true)) {
		return true;
	}

	else {
		return false;
	}
}

function validateuserlogin() {
	if ((pass1() == true) && (email() == true)) {
		return true;
	}
	else {
		return false;
	}
}