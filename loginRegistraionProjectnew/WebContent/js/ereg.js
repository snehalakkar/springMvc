function email1() {
	var a = document.getElementById("usremail").value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (a.match(mailformat)) {
		document.getElementById("p7").innerHTML = "";
		return true;
	} else {
		document.getElementById("p7").innerHTML = "Enter valid email !";
		return false;
	}
}

function name1() {
	var fname = document.getElementById("fnm").value;
	var letters = /^[A-Za-z]+$/;
	if (fname.match(letters)) {
		document.getElementById("p1").innerHTML = "";
		return true;
	} else {
		document.getElementById("p1").innerHTML = "Enter valid Firstname !";
		return false;

	}
}

function name2() {
	var lname = document.getElementById("lnm").value;
	var letters = /^[A-Za-z]+$/;
	if (lname.match(letters)) {
		document.getElementById("p2").innerHTML = "";
		return true;
	} else {
		document.getElementById("p2").innerHTML = "Enter valid Lastname !";
		return false;

	}
}

function address() {
	var add1 = document.getElementById("ad1").value;
	if (add1 != "") {
		document.getElementById("p3").innerHTML = "";
		return true;
	} else {
		document.getElementById("p3").innerHTML = "Enter address !";
		return false;

	}
}

function phone() {
	var phone1 = document.getElementById("pnum").value;
	var numbers = /^[0-9]+$/;
	if (phone1.match(numbers) && (phone1.length == 10)) {
		document.getElementById("p6").innerHTML = "";
		return true;

	} else {
		document.getElementById("p6").innerHTML = "Enter 10 digit contact !";
		return false;
	}
}

function age1() {
	var newage = document.getElementById("agelimit").value;
	console.log("newage1" + newage);
	var min = 17;
	var max = 66;
	if (newage == "") {
		document.getElementById("p8").innerHTML = "Enter age !";
		return false;
	} else if (newage.value > min || newage < max) {
		document.getElementById("p8").innerHTML = "";
		return true;
	} else {
		document.getElementById("p8").innerHTML = "age must be between 18 to 65 !";
		return false;

	}
}

function comp() {
	var comp1 = document.getElementById("cmp").value;
	if (comp1 != "") {
		document.getElementById("p4").innerHTML = "";
		return true;
	} else {
		document.getElementById("p4").innerHTML = "Enter Company Name !";
		return false;
	}
}

function special() {
	var spl1 = document.getElementById("spl").value;
	console.log("special" + spl1);
	var checklang = spl1.selectedIndex;
	console.log("selected" + checklang);
	var a = "Default";
	if (!(spl1.match(a))) {
		document.getElementById("p9").innerHTML = "";
		return true;
	} else {
		document.getElementById("p9").innerHTML = "Enter Your Specialization !";
		return false;
	}
}

function gender_validation(gen1) {

	/*
	 * if ((gen1.checked == false) && (gen1.checked == false) && (gen1.checked ==
	 * false)) { alert("Please choose your Gender: Male or Female");
	 * document.getElementById("p10").innerHTML = "select Your gender !"; return
	 * false; } else { document.getElementById("p10").innerHTML = ""; return
	 * true; }
	 */

	if ((document.getElementById(gen1).checked) == true) {
		document.getElementById("p10").innerHTML = "";
		return true;
	} else {
		document.getElementById("p10").innerHTML = "select Your gender !";
		return false;
	}
}

function lang_validation() {
	var lang2 = document.getElementById("lang1").value;
	console.log("lang" + lang2);
	var b = "Default";
	if (!(lang2.match(b))) {
		document.getElementById("p11").innerHTML = "";
		return true;
	} else {
		document.getElementById("p11").innerHTML = "select Your language !";
		return false;
	}
}

function validateempreg1() {
	console.log("inguhuyhuygh");
	var fname = name1();
	var lname = name2();
	/* var gen_val=gender_validation(); */
	var spl11 = special();
	var lang_val = lang_validation();
	var comp1 = comp();
	var age2 = age1();
	var phone1 = phone();
	var address1 = address();
	var email2 = email1();
	if ((fname == true) && (lname == true) && (spl11 == true)
			&& (lang_val == true) && (comp1 == true) && (age2 == true)
			&& (phone1 == true) && (address1 == true) && (email2 == true)) {

		return true;
	} else {
		return false;
	}
}