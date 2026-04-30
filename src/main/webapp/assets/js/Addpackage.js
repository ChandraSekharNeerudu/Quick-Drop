let weight = document.querySelector("#weight");
let distance = document.querySelector("#distance");
let mobile = document.querySelector("#recievermobile");
let ismobilevalid = true;
let isweightvalid = true;
let isdistancevalid = true;

mobile.addEventListener('blur', () => {
	let mobilespan = document.querySelector("#mobile-span");
	let mobileno = mobile.value.length;
	console.log(mobileno);

	if (mobileno !== 10) {
		ismobilevalid = false;
		mobilespan.style.color = "red";
		mobilespan.textContent = "* mobile Number must contain Exactly 10 digits";
	} else {
		ismobilevalid = true;
		// This is the "Clear" logic essential for good UX
		mobilespan.textContent = "";
	}
});

weight.addEventListener('blur', () => {
	let weightspan = document.querySelector("#weight-span");
	let value = weight.value;
	if (value > 15000 || value<1) {
		isweightvalid = false;
		weightspan.style.color = "red";
		weightspan.textContent = "* weight must be between 1 to 15000 kg";
	} else {
		isweightvalid = true;
		weightspan.textContent = "";
	}

});

distance.addEventListener('blur', () => {
	let distancespan = document.querySelector("#distance-span");
	let value = distance.value;
	if (value > 3500 || value<1) {
		isdistancevalid = false;
		distancespan.style.color = "red";
		distancespan.textContent = "* distance must be 1 to 3500 km";
	} else {
		isdistancevalid = true;
		distancespan.textContent = "";
	}
});

let form=document.querySelector("#Add");
form.addEventListener('submit',(e) => {
    if(!ismobilevalid || !isweightvalid || !isdistancevalid)
    {
        e.preventDefault(); // Stop submission
        alert("Correct the red errors first!");
    }
});