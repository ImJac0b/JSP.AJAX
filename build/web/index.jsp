<%-- 
    Document   : index
    Created on : 14-jun-2020, 19:53:37
    Author     : Jacob
--%>

<%@page import="DAO.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Products"%>
<%-- Creación de objeto del dao para listar los productos en la tabla --%>
<% ProductDAO ProductDAO = new ProductDAO(); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>CRUD JSP.AJAX-_-</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Last-Modified" content="0">
        <meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
        <meta http-equiv="Pragma" content="no-cache">
    </head>
    <body>
        <h1 class=" h1 text-center text-danger">CRUD PRODUCTOS</h1>
        <div class="container bg-light" style="margin-top:50px">
            <form action="" method="POST">
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="inputEmail4">Nombre</label>
                        <input type="text" id="Name" class="form-control">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="inputPassword4">Precio</label>
                        <input type="number" id="Price"  class="form-control">
                    </div>                    
                    <div class="form-group col-md-3">
                        <label for="inputZip">Descripción</label>
                        <input type="text" id="Description" class="form-control">
                    </div>
                </div>
                <div class="form-group col-md-3">          
                    <button type="button" id="bt-Add" class="btn btn-success" onclick="Add()">Agregar</button>
                    <button type="button" id="bt-Update" style="display:none" class="btn btn-primary" onclick="UpdateLast(this.value)">Actualizar</button>
                </div>
            </form>

            <table class="table table-striped" style="margin-top: 20px">
                <thead class="thead-ligth">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Descripción</th>
                        <th scope="col">Opción</th>
                    </tr>
                </thead>
                <tbody id="Table">
                    <%
                        //Ciclo foreach para llenar los datos de la tabla con el ArrayList de Productos
                        ArrayList<Products> list = ProductDAO.List();
                        if (list != null) {
                            for (Products product : list) {
                    %>
                    <tr id="row<%= product.getProductId()%>">
                        <th scope="row"><%= product.getProductId()%></th>
                        <td><%= product.getName()%></td>
                        <td><%= product.getPrice()%></td>
                        <td><%= product.getDescription()%></td>
                        <td> 
                            <button type="button" value="<%= product.getProductId()%>" class="btn btn-primary btn-sm" onclick="Update(this.value)">Actualizar</button>
                            <button type="button" value="<%= product.getProductId()%>" class="btn btn-danger btn-sm" onclick="Delete(this.value)">Eliminar</button>
                        </td>
                    </tr>
                    <%                                      }
                        }%>  
                </tbody>
            </table>
        </div>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="Resources/js/index.js"></script>
    </body>
</html>