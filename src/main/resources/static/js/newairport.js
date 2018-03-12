function addAirport(){
    // get values from the post button form
    var nameAirport = $("#name").val();
    var locationAirport = $("#location").val();


    var AirportObject = {
        name : nameAirport,
        location : locationAirport
	    };

	var airport = JSON.stringify(AirportObject);
        console.log(airport);
    $.ajax({
        url : "http://localhost:8080/api/airportcontroller/newairport", //url van de api waar de save functie staat in java
        type : "post",
        data : airport,
        contentType : "application/json",
        success  :function(data){

        $("#confirmation").text("You've successfully added airport: "+nameAirport);
        	console.log("post succesfull");
        	        }
    });

}