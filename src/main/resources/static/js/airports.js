function getAirports(){
    // als de pagina geladen is, start deze functie
    $(document).ready(function(){

        // ajax is een methode voor get/post requests
        $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/airportcontroller/getairports",
            // type actie
            type : "get",
            // als de actie lukt, voer deze functie uit
            success: function(data){

                var airportList = "";

                $.each(data, function(index, current){


                var airportString = "<tr> <td>" + current.name + "</td> <td>  " + current.location + "</td> <td>  " + current.airplanes +"</td> <td> " +
                + "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateAirportModal' onclick='openUpdateModal("+current.id+")'>Edit</button></td>"
                + "<td><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteAirportModal' + onclick='openDeleteModal("+current.id+","+current.number+")'>Delete</button></td></td>";

                airportList = airportList + airportString;

                });

                $("#airports").html(airportList);
            }
        });
    });

};