function addAirplane(){
    // get values from the post button form
    var nameAirplane = $("#name").val();
    var typeAirplane = $("#type").val();


    var AirportObject = {
        name : nameAirplane,
        location : typeAirplane
	    };

	var airport = JSON.stringify(AirportObject);
        console.log(airport);
    $.ajax({
        url : "http://localhost:8080/api/airportcontroller/newplane", //url van de api waar de save functie staat in java
        type : "post",
        data : airport,
        contentType : "application/json",
        success  :function(data){

        $("#confirmation").text("You've successfully added airplane: "+nameAirplane);
        	console.log("post succesfull");
        	        }
    });

}