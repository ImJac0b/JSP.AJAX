/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Metodo para añadir un producto
function Add() {
    let Name = $("#Name").val();
    let Price = $("#Price").val();
    let Description = $("#Description").val();
    //Petición Ajax
    $.ajax({
        url: 'Main',
        data: {Add: true, Name: Name, Price: Price, Description: Description},
        type: 'POST',
        success: function (response) {
            if (response) {
                alert("Lo estás haciendo bien jeje")
                Clear();
                location.reload();
            } else {
                alert("Ocurrio algo malo")
            }
        },
        error: function (xhr, status) {
            alert('Aquí algo está mal, mmm -_-');
        }
    });
}

//Metodo para elimiar los datos por id de producto
function Delete(id) {
    //Petición Ajax
    $.ajax({
        type: 'GET',
        url: 'Main',
        data: 'Delete=' + id,
        success: function (response) {
            if (response) {
                $("#row" + id).remove();
                alert("Elimiado Exitosamente");
            } else {
                alert("Ocurrio un Error");
            }
        },
        error: function (xhr, status) {
            alert('Disculpe, existió un problema');
        }
    });
}

//Metodo para actualizar un producto
function Update(id) {
    //Se llama al Ajax
    $.ajax({
        type: 'GET',
        url: 'Edit',
        data: 'Edit=' + id,
        dataType: "json",
        success: function (response) {
            $("#bt-Update").val(response.ProductId);
            $("#Name").val(response.Name);
            $("#Price").val(response.Price);
            $("#Description").val(response.Description);
            $("#bt-Update").css({'display': 'block'});
            $("#bt-Add").css({'display': 'none'});
        },
        error: function (xhr, status) {
            alert('Disculpe, existió un problema');
        }
    });
}

//Metodo para actualizar los datos por id de producto
function UpdateLast(id) {
    let Name = $("#Name").val();
    let Price = $("#Price").val();
    let Description = $("#Description").val();
    //Se llama al Ajax
    $.ajax({
        url: 'Edit',
        data: {Update: true, Name: Name, Price: Price, Description: Description, ProductId: id},
        type: 'POST',
        success: function (response) {
            if (response) {
                alert("Actualizado con exito")
                Clear();
                location.reload();
            } else {
                alert("Ocurrio un error")
            }
        },
        error: function (xhr, status) {
            alert('Disculpe, existió un problema');
        }
    });
}

//Metodo para limpiar los campos
function Clear() {
    $("#Name").val(null);
    $("#Price").val(null);
    $("#Description").val(null);
}