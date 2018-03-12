function getAirplanes(){
    // als de pagina geladen is, start deze functie
    $(document).ready(function(){

        // ajax is een methode voor get/post requests
        $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/airportcontroller/getairplanes",
            // type actie
            type : "get",
            // als de actie lukt, voer deze functie uit
            success: function(data){

                var airplaneList = "";

                $.each(data, function(index, current){

                var airportName = "";
                if(current.airport.name != null){
                    airportName = current.airport.name;
                }


                var airplaneString = "<tr> <td>" + current.name + "</td> <td>  " + current.type + "</td> <td>  " + current.fuel +"</td> <td> " + airportName +"</td> <td> " +
                "<td><button type='button' class='btn btn-primary' data-toggle='modal' data-target='#fuelAirplaneModal' onclick='openFuelModal("+current.id+")'>Fuel up</button></td></td>" +
                "<td><button type='button' class='btn btn-success' data-toggle='modal' data-target='#flyAirplaneModal' onclick='openFlyModal("+current.id+")'>Fly</button></td></td>" +
                "<td><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteAirplaneModal' onclick='openDeleteModal("+current.id+", "+current.name+")'>Delete</button></td></td>";

                airplaneList = airplaneList + airplaneString;

                });

                $("#airplanes").html(airplaneList);
            }
        });
    });

};

$(document).ready(getAirplanes());

function openDeleteModal(id, name){
    $("#deleteAirplaneModal").modal('show');
    var generateDeleteButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancel</button>"
                                +"<button type='button' class='btn btn-danger' data-dismiss='modal' onclick='deleteAirplane("+id+");'>Delete</button>";
    var nameString = "Delete Airplane "+ name;
    $("#deleteAirplane").text(nameString);
    $("#deleteModalFooter").html(generateDeleteButtons);
}

function deleteAirplane(id){

    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/airportcontroller/deleteairplane?id=" + id,
            // type actie
            type : "delete",
            // als de actie lukt, voer deze functie uit
            success : function(id){
                getAirplanes();
            }
        });
}

function openFuelModal(id, name){
    $("#fuelAirportModal").modal('show');
    var generateFuelButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancel</button>"
                                +"<button type='button' class='btn btn-success' data-dismiss='modal' onclick='fuelAirplane("+id+");'>Fuel up</button>";
    var nameString = "Fuel up airplane "+ name;
    $("#deleteAirplane").text(nameString);
    $("#fuelModalFooter").html(generateFuelButtons);
}

function fuelAirplane(id){

    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/airportcontroller/tankairplane?id=" + id,
            // type actie
            type : "put",
            // als de actie lukt, voer deze functie uit
            success : function(id){
                getAirplanes();
            }
        });
}

function openFlyModal(id, name){
    $("#fuelAirportModal").modal('show');
    var generateFlyButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancel</button>"
                                +"<button type='button' class='btn btn-success' data-dismiss='modal' onclick='flyAirplane("+id+");'>Fly</button>";
    var nameString = "Fuel up airplane "+ name;
    $("#deleteAirplane").text(nameString);
    $("#deleteModalFooter").html(generateFlyButtons);

    $.ajax({
        // waar moet hij de request op uitvoeren
        url : "http://localhost:8080/api/airportcontroller/getairports",
        // type actie
        type : "get",
        // als de actie lukt, voer deze functie uit
        success : function(data){
            var airportList = "";
            $.each(data, function(index, current){
                var airportOption = "<option value="+current.id+">"+current.name+"</option>";
                airportList = airportList + airportOption;
        });

        $("#airportOptions").html(airportList);

        }
    });
}

function flyAirplane(id){

    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/airportcontroller/flyairplane?id=" + id,
            // type actie
            type : "put",
            // als de actie lukt, voer deze functie uit
            success : function(id){
                getAirplanes();
            }
        });
}