// UserSelectOrderPage Filter function

function filterFunc() {

	var search = document.getElementById("searchBar").value;
	console.log(search.toLowerCase());
	search = search.toLowerCase();
	tbl = document.getElementById("table");
	tr = tbl.getElementsByTagName("tr");
	for (let i = 2; i < tr.length - 1; i++) {

		data = tr[i].getElementsByTagName("td");

		if (data) {
			var txt = data[1].innerText;
			var text = txt.toLowerCase();
			console.log(text);
			if (text.indexOf(search) > -1) {
				tr[i].style.display = "";
			}
			else {
				txt = data[2].innerText;
				text = txt.toLowerCase();
				if (text.indexOf(search) > -1) {
					tr[i].style.display = "";
				}
				else {
					txt = data[3].innerText;
					text = txt.toLowerCase();
					if (text.indexOf(search) > -1) {
						tr[i].style.display = "";
					}
					else{
						tr[i].style.display = "none";
					}
				}
			}
		}



	}

}

//ViewUserorderpage Filter function

function filterFunc2() {

	var search = document.getElementById("searchBar").value;
	console.log(search.toLowerCase());
	search = search.toLowerCase();
	tbl = document.getElementById("table");
	tr = tbl.getElementsByTagName("tr");
	for (let i = 2; i < tr.length; i++) {

		data = tr[i].getElementsByTagName("td");

		if (data) {
			var txt = data[1].innerText;
			var text = txt.toLowerCase();
			console.log(text);
			if (text.indexOf(search) > -1) {
				tr[i].style.display = "";
			}
			else {
				txt = data[2].innerText;
				text = txt.toLowerCase();
				if (text.indexOf(search) > -1) {
					tr[i].style.display = "";
				}
				else {
					txt = data[3].innerText;
					text = txt.toLowerCase();
					if (text.indexOf(search) > -1) {
						tr[i].style.display = "";
					}
					else{
						tr[i].style.display = "none";
					}
				}
			}
		}



	}

}