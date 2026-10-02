var tbl = document.getElementById("table");

// Takes value for veg or nonveg
const selection = document.getElementById("category");

// Takes value for breakfast or lunch
const meal = document.getElementById("meal");

var tr = tbl.getElementsByTagName("tr");

var data;

selection.addEventListener('change', event => {
	console.log(selection.value);
	console.log(meal.value);
	if (meal.value === "default") {
		if (selection.value === "default") {
			for (let i = 2; i < tr.length; i++) {
				tr[i].style.display = "";
			}
		}
		else {
			for (let i = 2; i < tr.length; i++) {
				console.log(tr[i]);
				data = tr[i].getElementsByTagName("td")[2];
				console.log(data.innerText);
				if (data.innerText === selection.value) {
					tr[i].style.display = "";
				}
				else {
					tr[i].style.display = "none";
				}
			}
		}
	}
	else if (selection.value === "default" && meal.value !="default"){
		for (let i = 2; i < tr.length; i++) {
				console.log(tr[i]);
				data = tr[i].getElementsByTagName("td")[3];
				console.log(data.innerText);
				if (data.innerText === meal.value) {
					tr[i].style.display = "";
				}
				else {
					tr[i].style.display = "none";
				}
			}
	}
	else{
		for (let i = 2; i < tr.length; i++) {
				console.log(tr[i]);
				data = tr[i].getElementsByTagName("td");
				console.log(data[2].innerText);
				if (data[2].innerText === selection.value && data[3].innerText === meal.value) {
					tr[i].style.display = "";
				}
				else {
					tr[i].style.display = "none";
				}
			}
	}

})

meal.addEventListener("change",event =>{
	if(selection.value=="default"){
		if (meal.value === "default") {
			for (let i = 2; i < tr.length; i++) {
				tr[i].style.display = "";
			}
		}
		else {
			for (let i = 2; i < tr.length; i++) {
				console.log(tr[i]);
				data = tr[i].getElementsByTagName("td")[3];
				console.log(data.innerText);
				if (data.innerText === meal.value) {
					tr[i].style.display = "";
				}
				else {
					tr[i].style.display = "none";
				}
			}
		}
	}
	else if (meal.value === "default" && selection.value !="default"){
		for (let i = 2; i < tr.length; i++) {
				console.log(tr[i]);
				data = tr[i].getElementsByTagName("td")[2];
				console.log(data.innerText);
				if (data.innerText === selection.value) {
					tr[i].style.display = "";
				}
				else {
					tr[i].style.display = "none";
				}
			}
	}
	else{
		for (let i = 2; i < tr.length; i++) {
				console.log(tr[i]);
				data = tr[i].getElementsByTagName("td");
				console.log(data[2].innerText);
				if (data[2].innerText === selection.value && data[3].innerText === meal.value) {
					tr[i].style.display = "";
				}
				else {
					tr[i].style.display = "none";
				}
			}
	}
})