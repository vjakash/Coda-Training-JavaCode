/**
 * 
 */
 var options = {
    "key": "rzp_test_S4S8eULZMZ5Pyo", // Enter the Key ID generated from the Dashboard
    "amount": "50000", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "Coda Corp",
    "description": "Shopping Payment",
    "image": "https://d2q79iu7y748jz.cloudfront.net/s/_squarelogo/822bda268aadaf438425cc736cadf068",
    "order_id": "order_9A33XWu170gUtm", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    "handler": paymentSuccess,
    "prefill": {
        "name": "Gaurav Kumar",
        "email": "gaurav.kumar@example.com",
        "contact": "9999999999"
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#f1ffd5"
    }
};
var rzp1=new Razorpay(options);;
rzp1.on('payment.failed', function (response){
        //alert(response.error.code);
        alert(response.error.description);
        alert(response.error.reason);
        /*alert(response.error.source);
        alert(response.error.step);
        alert(response.error.metadata.order_id);
        alert(response.error.metadata.payment_id);*/
});
document.getElementById('payBtn').onclick =async function(e){
	let grandTotal=document.getElementById("grandTotal").innerHTML;
	console.log(grandTotal);
	let result=await fetch('http://localhost:8080/createOrder', {
	    method: 'POST',
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json'
	    },
	    body:grandTotal
	  });
	 result=await result.json();
	 console.log(result);
	 options['order_id']=result['id'];
	 options['amount']=result['amount'];
	 options['prefill']['name']=result['name'];
	 options['prefill']['email']=result['email'];
	 options['prefill']['contact']=result['phone'];
	rzp1 = new Razorpay(options);
    rzp1.open();
    e.preventDefault();
}

async function paymentSuccess(response){
	document.getElementById("overlayDiv").classList.remove("display-none");
	let result=await fetch('http://localhost:8080/paymentSuccess', {
	    method: 'POST',
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json'
	    },
	    body:`${response.razorpay_payment_id},${response.razorpay_order_id},${response.razorpay_signature}`
	  });
	  document.getElementById("overlayDiv").classList.add("display-none");
	  if(result.status==200){
		window.location.replace("/orderplaced");
	}
}

function stopPropagation(event){
	event.stopPropagation();
}



