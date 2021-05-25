/**
 * 
 */
 function selectAddress(value){
	if(value==""){
		document.getElementById("doorno").value="";
		document.getElementById("street").value="";
		document.getElementById("area").value="";
		document.getElementById("city").value="";
		document.getElementById("pincode").value="";
		return;
	}
	[doorno,street,area,city,pincode]=value.split(",");
	console.log(doorno,street,area,city,pincode);
	document.getElementById("doorno").value=doorno;
	document.getElementById("street").value=street;
	document.getElementById("area").value=area;
	document.getElementById("city").value=city;
	document.getElementById("pincode").value=pincode;
	
}