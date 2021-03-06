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
                "<td><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteAirportModal' onclick='openDeleteModal("+current.id+", "+current.name+")'>Delete</button></td></td>";

                airportList = airportList + airportString;

                });

                $("#airports").html(airportList);
            }
        });
    });

};

$(document).ready(getAirports());

function openDeleteModal(id, name){
    $("#deleteAirportModal").modal('show');
    var generateDeleteButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancel</button>"
                                +"<button type='button' class='btn btn-danger' data-dismiss='modal' onclick='deleteAirport("+id+");'>Delete</button>";
    var nameString = "Delete Airport "+ name;
    $("#deleteName").text(nameString);
    $("#deleteModalFooter").html(generateDeleteButtons);
}

function deleteAirport(id){

    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/airportcontroller/deleteairport?id=" + id,
            // type actie
            type : "delete",
            // als de actie lukt, voer deze functie uit
            success : function(id){
                getAirports();
            }
        });
}