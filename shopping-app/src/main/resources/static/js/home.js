/**
 * 
 */
function openLeftMenu(){
		document.getElementById("hamburger").classList.toggle("is-active");
		document.getElementById("menuBar").classList.toggle("open");

}




	let banners=["https://gudbasket-pictures.s3.ap-south-1.amazonaws.com/admin-banners/banner-3.jpg",
				"https://gudbasket-pictures.s3.ap-south-1.amazonaws.com/admin-banners/banner-2.jpg",
				"https://media.hearstapps.com/hmg-prod/images/shopping-bag-full-of-fresh-vegetables-and-fruits-royalty-free-image-1128687123-1564523576.jpg?crop=2122,1063.416,x0,y300,safe&width=980&auto=webp&optimize=medium"
				];
	let i=0;
	let bannerChanger=setInterval(()=>{
		document.getElementById("banner").style.backgroundImage=`url(${banners[i]})`;
		i++;
		if(i>=banners.length) i=0;
	},3000);
	
	function changeBanner(side){
		clearInterval(bannerChanger);
		if(side=="left"){
			i--;
			if(i<0) i=banners.length-1;
		}else{
			i++;
			if(i>=banners.length)i=0;
		}
		document.getElementById("banner").style.backgroundImage=`url(${banners[i]})`;
		bannerChanger=setInterval(()=>{
			document.getElementById("banner").style.backgroundImage=`url(${banners[i]})`;
			i++;
			if(i>=banners.length) i=0;
		},3000);
	}
	
	
	
	`
		INSERT INTO Item Values(0,"https://gudbasket-pictures.s3.ap-south-1.amazonaws.com/products/mushroom-box-freshproduceshoppe-600x600.jpg","Mushroom",200,"vegetables","Kg");
		INSERT INTO Item Values(1,"https://gudbasket-pictures.s3.ap-south-1.amazonaws.com/products/What_to_do_with_broccoli-1-500x375.jpg","Brocolli",150,"Vegetables","Kg");
		INSERT INTO Item Values(2,"https://c.ndtvimg.com/p5qg74v8_potato_625x300_01_August_18.jpg","Potato",50,"vegetables","Kg");
		INSERT INTO Item Values(3,"https://www.thermofisher.com/blog/wp-content/uploads/2014/08/tomatoes.jpg","Tomato",90,"vegetables","Kg");
		INSERT INTO Item Values(4,"https://i.ndtvimg.com/mt/cooks/2014-11/carrots.jpg","Carrot",45,"vegetables","Kg");

		INSERT INTO Item Values(5,"https://gudbasket-pictures.s3.ap-south-1.amazonaws.com/products/224898.jpg","Strawberry",350,"fruits","Kg");
		INSERT INTO Item Values(6,"https://gudbasket-pictures.s3.ap-south-1.amazonaws.com/products/0000000040303_a1c1_1200.png","Kiwi",70,"fruits","Kg");
		INSERT INTO Item Values(7,"https://plantogram.com/wa-data/public/shop/products/55/06/655/images/1256/1256.970.jpg","Mango",180,"fruits","Kg");
		INSERT INTO Item Values(8,"https://www.cmiapples.com/ecom_img/original-6-38-jonagold-apples.jpg","Apple",40,"fruits","Kg");
		INSERT INTO Item Values(9,"https://www.aicr.org/wp-content/uploads/2020/01/shutterstock_533487490-640x462.jpg.webp","Grapes",125,"fruits","Kg");

		INSERT INTO Item Values(0,"","Mushroom",200,"vegetables","Kg");
		INSERT INTO Item Values(0,"","Mushroom",200,"vegetables","Kg");
		INSERT INTO Item Values(0,"","Mushroom",200,"vegetables","Kg");
		INSERT INTO Item Values(0,"","Mushroom",200,"vegetables","Kg");
		INSERT INTO Item Values(0,"","Mushroom",200,"vegetables","Kg");


		
	`