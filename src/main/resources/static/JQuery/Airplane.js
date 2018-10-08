// CRUD functions for the Airplane class 
$(document).ready(function () {
    console.log("Readyyy!!!")
    // table with values that correspond with backend fieldnames 
    $("#airplaneTable").DataTable({
        columns: [
            { "data": "id" },
            { "data": "currentAirport" },
            { "data": "currentFuel" },
            {
                data: function (data, type, row) {
                    return '<button class="btn btn-danger" type="button" data-toggle="modal" data-target="#editAirplaneModal" onclick="getSingleAirplane(' + data.id + ')">Edit/Delete</button>';
                }
            },
            {
                data: function (data, type, row) {
                    return '<button class="btn btn-danger" type="button" data-toggle="modal" data-target="#flyAirplaneModal" onclick="getSingleAirplane(' + data.id + ')">Fly</button>';
                }
            }
        ]
    });


    // post new Airplane
    $("#newAirplaneForm").on('submit', function (e) {
        console.log("Posting data")
        // Post the data from the form
        postData();
        console.log("Data posted")
        // Reset form
        $("#currentAirport").val("");
        $("#currentFuel").val("");
    });

    $("#deleteAirplaneForm").on('submit', function (e) {
        console.log("Data delete request")
        // delete the Airplane of which the id was entered
        deleteData();
        console.log("Data deleted")
    });

    // get single Airplane
    // $("#editAirplaneForm").on('submit', function (e) {

    //     // prefills form with Airplane info
    //     getSingleAirplane();

    //     // reset form
    //     $("#editAirplaneId").val("");
    // });

    // edit single Airplane
    $("#editAirplaneForm").on('submit', function (e) {
        console.log("Airplane edit request")
        // edit single Airplane
        editAirplane();
        console.log("Data edited")
    });
    $("#flyAirplaneForm").on('submit', function (e) {
        console.log("Fly airplane request")
        // edit single Airplane
        flyAirplane();
        console.log("Data edited")
    });
    getData();

});


// getdata
function getData() {
    // Get the data from endpoint.
    $.ajax({
        url: "http://localhost:8080/api/airplane/",
        type: "get",
        success: function (airplane) {
            // On successful get, reload the datatable with new data.
            $('#airplaneTable').DataTable().clear();
            $('#airplaneTable').DataTable().rows.add(airplane);
            $('#airplaneTable').DataTable().columns.adjust().draw();
        }
    });
}

//postdata
function postData() {

    // Get values from html.
    let id = $("#id").val();
    let currentAirport = $("#currentAirport").val();
    let currentFuel = $("#currentFuel").val();


    // Create JS object with data.
    let newAirplane = {
        id: id,
        currentAirport: currentAirport,
        currentFuel: currentFuel
    }

    // Convert JS object to JSON.
    let validJsonAirplane = JSON.stringify(newAirplane);

    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/api/airplane/",
        type: "post",
        data: validJsonAirplane,
        contentType: "application/json",
        success: function (result) {
            // On successful post, reload data to get the added one as well.
            console.log("Posting" + validJsonAirplane)
            getData();
        }
    });
}

// delete data
function deleteData() {

    // get values from html
    let id = $('#id1').val();
    console.log(id)
    // DELETE request to backend 
    $.ajax({
        url: "http://localhost:8080/api/airplane/" + id,
        type: "delete",
        data: id,
        contentType: "application/json",
        success: function () {
        getData()
        }
    });
}


function getSingleAirplane(id) {

    // GET data from backend
    $.ajax({
        url: "http://localhost:8080/api/airplane/" + id,
        type: "get",
        data: id,
        contentType: "application/json",
        success: function (airplane) {
            // prefill form with data from backend
            $("#id1").val(airplane.id);
            $("#newAirport").val(airplane.currentAirport);
            $("#newFuel").val(airplane.currentFuel);
            getData();
        }
    });
}


// EDIT Airplane data
function editAirplane() {
    // Get values from Html
    let id = $("#id1").val();
    let currentAirport = $("#newAirport").val();
    let currentFuel = $("#newFuel").val();


    // create JS object
    let editedAirplane = {
        id: id,
        currentAirport: currentAirport,
        currentFuel: currentFuel,
    }

    // create JSON object
    let validJsonEditedAirplane = JSON.stringify(editedAirplane);

    // PUT request to endpoint
    $.ajax({
        url: "http://localhost:8080/api/airplane/" + id,
        type: "put",
        data: validJsonEditedAirplane,
        contentType: "application/json",
        success: function () {
            // update table with new data
            getData();
        }
    })
}

// EDIT Airplane data
function flyAirplane() {
    // Get values from Html
    let id = $("#id1").val();
    let currentAirport = $("#newAirport").val();
    let currentFuel = $("#currentFuel1").val();

    // create JS object
    let editedAirplane = {
        id: id,
        currentAirport: currentAirport,
        currentFuel: currentFuel,
    }
    console.log (currentFuel)

    // create JSON object
    let validJsonEditedAirplane = JSON.stringify(editedAirplane);

    // PUT request to endpoint
    $.ajax({
        url: "http://localhost:8080/api/airplane/" + id,
        type: "put",
        data: validJsonEditedAirplane,
        contentType: "application/json",
        success: function () {
            // update table with new data
            getData();
        }
    })
}