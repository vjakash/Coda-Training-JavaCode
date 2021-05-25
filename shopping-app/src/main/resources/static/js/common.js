/**
 * 
 */

function openLeftMenu(){
		document.getElementById("hamburger").classList.toggle("is-active");
		document.getElementById("menuBar").classList.toggle("open");

}
	async function deleteAddress(event,id){
		console.log("address id :"+id);
		let result=await fetch(`http://localhost:8080/deleteAddress/${id}`, {
		    method: 'POST',
		    headers: {
		      'Accept': 'application/json',
		      'Content-Type': 'application/json'
		    },
		    body: String(id),
	  	});
		  result=await result.json();
		  if(result==200){
			window.location.replace("http://localhost:8080/account");
		  }
	}