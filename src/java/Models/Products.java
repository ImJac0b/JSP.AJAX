/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Jacob
 */
public class Products {
    //Modelo Products con encapsulamiento
    private String Name;
    private int ProductId;
    private Double Price;        
    private String Description;

    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    } 

    public Double getPrice() {
        return Price;
    }
    
     public void setPrice(Double Price) {
        this.Price = Price;
    }   
      

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
