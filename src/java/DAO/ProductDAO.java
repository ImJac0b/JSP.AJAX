/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Conexion;
import Models.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class ProductDAO {

    //Creación de Objeto definido como null
    private Connection Connexion = null;
    //Sentencias SQL
    private String SELECT = "SELECT * FROM products";
    private String DELETE = "DELETE FROM products WHERE ProductId = ?";
    private String UPDATE = "UPDATE products SET Name = ?, Price = ?, Description = ? WHERE ProductId = ?";
    private String INSERT = "INSERT INTO products(Name,Price,Description) VALUES(?,?,?,?)";
    private String SELECTONE = "SELECT * FROM products WHERE ProductId = ?";

    
//Metodo Add(Añadir) para añadir un producto
    public boolean Add(Products product) {
        try {
            //Se crea la conexión
            Connexion = Conexion.GetConnection();
            //Se hace la parametrización 
            PreparedStatement stmt = Connexion.prepareStatement(INSERT);
            //Se ingresan los parametros
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(4, product.getDescription());
            //Se ejecuta la consulta
            stmt.executeUpdate();
            //se cierra la conexión
            Connexion.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    //Metodo para obtener un producto en especifico por el ProductId
    public Products GetProduct(String parameter) {
        try {
            //Se crea la conexión
            Connexion = Conexion.GetConnection();
            //Se hace la parametrización 
            PreparedStatement stmt = Connexion.prepareStatement(SELECTONE);
            //Se añaden los parametros
            stmt.setString(1, parameter);
            //Se ejecuta la consulta y se recibe el resultado en un objeto
            ResultSet result = stmt.executeQuery();
            //Se crea un objeto tipo Products
            Products product = new Products();
            //Validación
            if (result.next()) {
                //Se llenan los datos por medio del metodo SET del objeto de Products
                product.setProductId(result.getInt("ProductId"));
                product.setName(result.getString("Name"));
                product.setPrice(result.getDouble("Price"));
                product.setDescription(result.getString("Description"));
            }
            //Se cierra la Conexión
            Connexion.close();
            //Se retorna el objeto
            return product;
        } catch (Exception ex) {
            return null;
        }
    }

    //Metodo Delete(Eliminar) para añadir un producto
    public boolean Delete(String parameter) {
        try {
            Connexion = Conexion.GetConnection();
            PreparedStatement stmt = Connexion.prepareStatement(DELETE);
            stmt.setString(1, parameter);
            stmt.executeUpdate();
            Connexion.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }    

    //Metodo Update(Actualizar) para añadir un producto
    public boolean Update(Products product) {
        try {
            //Se prepara la conexión
            Connexion = Conexion.GetConnection();
            PreparedStatement stmt = Connexion.prepareStatement(UPDATE);
            //Se ingresan los parametros
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(4, product.getDescription());
            stmt.setInt(5, product.getProductId());
            //Se ejecuta la consulta
            stmt.executeUpdate();
            //se cierra la conexión
            Connexion.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    //Metodo List para obtener todos los productos y mandarlos en un array[] de productos
    public ArrayList<Products> List() {
        try {
            //Se prepara la conexion
            Connexion = Conexion.GetConnection();
            PreparedStatement stmt = Connexion.prepareStatement(SELECT);
            ResultSet result = stmt.executeQuery();
            ArrayList<Products> list = new ArrayList();
            //Se crea un array list de productos y se llena con el while
            while (result.next()) {
                Products product = new Products();
                product.setProductId(result.getInt("ProductId"));
                product.setName(result.getString("Name"));
                product.setPrice(result.getDouble("Price"));
                product.setDescription(result.getString("Description"));
                list.add(product);
            }
            Connexion.close();
            //Se retorna un arraylist de productos
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

}
