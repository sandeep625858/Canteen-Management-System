function minus(element) {
	let qtyBox = element.nextElementSibling;
	if (qtyBox.value != 1) {
		qtyBox.value = parseInt(qtyBox.value) - 1;
	}
}
function plus(element) {
	let qtyBox = element.previousElementSibling;
	qtyBox.value = parseInt(qtyBox.value) + 1;
}
const formEL = document.querySelector('.form');

var tbl = document.getElementById("table");

const selection = document.getElementById("category");
var tr = tbl.getElementsByTagName("tr");
var data;

if(selection.value=="Veg" || selection.value=="Nonveg"){
	for (let i = 2; i < tr.length - 1; i++) {
				//console.log(tr[i]);
				data = tr[i].getElementsByTagName("td")[3];
				//console.log(data.innerText);
				if (data.innerText === selection.value) {
					tr[i].style.display = "";
				}
				else {
					tr[i].style.display = "none";
				}
		}
}

const meal = document.getElementById("meal");



selection.addEventListener('change', event => {
	//console.log(selection.value);
	//console.log(meal.value);
	if (meal.value === "default") {
		if (selection.value === "default") {
			for (let i = 0; i < tr.length - 1; i++) {
				tr[i].style.display = "";
			}
		}
		else {
			for (let i = 2; i < tr.length - 1; i++) {
				//console.log(tr[i]);
				data = tr[i].getElementsByTagName("td")[3];
				//console.log(data.innerText);
				if (data.innerText === selection.value) {
					tr[i].style.display = "";
				}
				else {
					tr[i].style.display = "none";
				}
			}
		}
	}
	else if (selection.value === "default" && meal.value != "default") {
		for (let i = 2; i < tr.length - 1; i++) {
			//console.log(tr[i]);
			data = tr[i].getElementsByTagName("td")[2];
			console.log(data.innerText);
			if (data.innerText === meal.value) {
				tr[i].style.display = "";
			}
			else {
				tr[i].style.display = "none";
			}
		}
	}
	else {
		for (let i = 2; i < tr.length - 1; i++) {
			//console.log(tr[i]);
			data = tr[i].getElementsByTagName("td");
			console.log(data[3].innerText);
			if (data[3].innerText === selection.value && data[2].innerText === meal.value) {
				tr[i].style.display = "";
			}
			else {
				tr[i].style.display = "none";
			}
		}
	}

})

meal.addEventListener("change", event => {
	if (selection.value == "default") {
		if (meal.value === "default") {
			for (let i = 0; i < tr.length - 1; i++) {
				tr[i].style.display = "";
			}
		}
		else {
			for (let i = 2; i < tr.length - 1; i++) {
				//console.log(tr[i]);
				data = tr[i].getElementsByTagName("td")[2];
				//console.log(data.innerText);
				if (data.innerText === meal.value) {
					tr[i].style.display = "";
				}
				else {
					tr[i].style.display = "none";
				}
			}
		}
	}
	else if (meal.value === "default" && selection.value != "default") {
		for (let i = 2; i < tr.length - 1; i++) {
			//console.log(tr[i]);
			data = tr[i].getElementsByTagName("td")[3];
			console.log(data.innerText);
			if (data.innerText === selection.value) {
				tr[i].style.display = "";
			}
			else {
				tr[i].style.display = "none";
			}
		}
	}
	else {
		for (let i = 2; i < tr.length - 1; i++) {
			//console.log(tr[i]);
			data = tr[i].getElementsByTagName("td");
			console.log(data[3].innerText);
			if (data[3].innerText === selection.value && data[2].innerText === meal.value) {
				tr[i].style.display = "";
			}
			else {
				tr[i].style.display = "none";
			}
		}
	}
})

formEL.addEventListener('submit', event => {
	event.preventDefault()
	console.log('ji');
	var foodId = [];
	var quantity = [];
	var price = [];
	var checklist = document.querySelectorAll('.select');
	var quan = document.querySelectorAll('.quantity');
	for (let i = 0; i < checklist.length; i++) {
		if (checklist[i].checked) {
			foodId.push(checklist[i].value);
			price.push(checklist[i].getAttribute("price"));
			quantity.push(quan[i].value);
		}
	}
	console.log(foodId);
	console.log(price);
	console.log(quantity);
	const date = document.getElementById('selectdate');
	console.log(date.value);
	const object1 = { "foodIdList": foodId, "date": date.value, "quantity": quantity, "orderPrice": price }
	console.log(object1);
	if (foodId.length == 0) {

		fetch('/user/menu/optOut', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(object1)
		});
		swal("Message from Canteen_MS", "You've Opted out for " + date.value)
			.then(function() {
				location.reload();
			});
		return;
	}
	fetch('/user/menu/selection', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(object1)
	});
	swal("Message from Canteen_MS", "You've Placed your order for " + date.value)
		.then(function() {
			location.reload();
		});
})
