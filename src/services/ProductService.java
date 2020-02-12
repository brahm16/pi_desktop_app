/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ibrahim
 */
public class ProductService implements IService<Product> ,IServiceProduct<Product> {
    private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;
    
    public ProductService(){
        this.cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public boolean insert(Product p) {
        String sql ="insert into product (product_name,product_type,reference,marque,priceHT,priceTTC,TVA,weight) values (?,?,?,?,?,?,?,?)";
        try {
            pst=cnx.prepareCall(sql);
            pst.setString(1,p.getProduct_name());
            pst.setString(2,p.getProduct_type());
            pst.setString(3,p.getReference());
            pst.setString(4,p.getMarque());
            pst.setFloat(5,p.getPriceHT());
            pst.setFloat(6,p.getPriceTTC());
            pst.setFloat(7,p.getTVA());
            pst.setFloat(8,p.getWeight());
            pst.executeUpdate();
            System.out.println("product added successfully");

            return true;
        } catch (SQLException ex) {
            return false;
        }    }

    @Override
    public boolean update(Product p) {
    String sql="update product set product_name= ? , product_type= ? , reference= ? , marque = ? , priceHT= ? , TVA = ? , weight= ? where id_product= ?";    
        try {
            pst=cnx.prepareCall(sql);
            pst.setString(1,p.getProduct_name());
            pst.setString(2,p.getProduct_type());
            pst.setString(3,p.getReference());
            pst.setString(4,p.getMarque());
            pst.setFloat(5,p.getPriceHT());
            pst.setFloat(6,p.getTVA());
            pst.setFloat(7,p.getWeight());
            pst.setInt(8, p.getId_product());
            pst.executeUpdate();
            System.out.println("product updated");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
    
    }

    @Override
    public boolean delete(int id) {
        String sql="delete from product where id_product= ? ";
				
		try {
                    pst=cnx.prepareStatement(sql);
                    pst.setInt(1, id);
                    pst.execute();
                    System.out.println("product deleted");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			return false;
		}
    }
    
    @Override
    public List<Product> displayAll() {
       String sql="Select* from product";
        List<Product> list=new ArrayList<>();
        try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new Product(res.getInt("id_product"),res.getString("product_name"),res.getString("product_type"),res.getString("reference"),res.getString("marque"),res.getFloat("priceHT"),res.getFloat("priceTTC"),res.getFloat("TVA"),res.getFloat("weight")));
            }
            return list;
        } catch (SQLException ex) {
                        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list; 
          }

    @Override
    public List<Product> findByName(String name) {
String sql="Select* from product where product_name='"+name+"'";
         List<Product> list =new ArrayList<>();
         try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new Product(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(6),res.getFloat(7),res.getFloat(8),res.getFloat(9)));
            }
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        
        }    }

   

    @Override
    public Product findFirstOneByName(String name) {
        String sql="Select* from product where product_name='"+name+"'";
        Product p=null;
         try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            if(res.next()){
                p= new Product(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(6),res.getFloat(7),res.getFloat(8),res.getFloat(9));
            }
            return p; 
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Product findById(int id) {
        String sql="Select* from product where id_product="+id+";";
        Product p=null;
        try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            if(res.next()){
                p= new Product(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(6),res.getFloat(7),res.getFloat(8),res.getFloat(9));
            }
            return p; 
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Product findFirstOneByType(String type) {
        String sql="Select* from product where product_type='"+type+"'";
        Product p=null;
         try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            if(res.next()){
                p= new Product(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(6),res.getFloat(7),res.getFloat(8),res.getFloat(9));
            }
            return p; 
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    }

    @Override
    public List<Product> findByType(String type) {
         String sql="Select* from product where product_type='"+type+"'";
         List<Product> list =new ArrayList<>();
         try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new Product(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(6),res.getFloat(7),res.getFloat(8),res.getFloat(9)));
            }
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        
        }     }

    @Override
    public Product findByReference(String reference) {
        String sql="Select* from product where reference='"+reference+"'";
        Product p=null;
         try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            if(res.next()){
                p= new Product(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(6),res.getFloat(7),res.getFloat(8),res.getFloat(9));
            }
            return p; 
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    }

    @Override
    public Product findFirstByMarque(String marque) {
        String sql="Select* from product where marque='"+marque+"'";
        Product p=null;
         try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            if(res.next()){
                p= new Product(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(6),res.getFloat(7),res.getFloat(8),res.getFloat(9));
            }
            return p; 
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findByMarque(String marque) {
         String sql="Select* from product where marque='"+marque+"'";
         List<Product> list =new ArrayList<>();
         try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new Product(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getFloat(6),res.getFloat(7),res.getFloat(8),res.getFloat(9)));
            }
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        
        }    }
   
    
    
}
