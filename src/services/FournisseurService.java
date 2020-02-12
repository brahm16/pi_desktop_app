/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Entrepot;
import entities.Fournisseur;
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
public class FournisseurService implements IService<Fournisseur> {

    private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;

    public FournisseurService() {
        this.cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public boolean insert(Fournisseur t) {
        String sql = "insert into fournisseur (firstname,lastname,phoneNumber,type_product,address,email) values (?,?,?,?,?,?)";
        try {
            pst = cnx.prepareCall(sql);
            pst.setString(1, t.getFirstname());
            pst.setString(2, t.getLastname());
            pst.setString(3, t.getPhoneNumber());
            pst.setString(4, t.getType_product());
            pst.setString(5, t.getAddress());
            pst.setString(6, t.getEmail());

            pst.executeUpdate();
            System.out.println("Fournisseur added successfully");

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean update(Fournisseur t) {
        String sql = "update fournisseur set firstname= ? , lastname= ? , phoneNumber= ? , type_product = ? , address= ? , email= ? where id_fournisseur= ?  ";
        try {
            pst = cnx.prepareCall(sql);
            pst.setString(1, t.getFirstname());
            pst.setString(2, t.getLastname());
            pst.setString(3, t.getPhoneNumber());
            pst.setString(4, t.getType_product());
            pst.setString(4, t.getAddress());
            pst.setString(4, t.getEmail());
            pst.setInt(4, t.getId_fournisseur());

            pst.executeUpdate();
            System.out.println("fournisseur updated");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
String sql="delete from fournisseur where id_fournisseur= ? ";
				
		try {
                    pst=cnx.prepareStatement(sql);
                    pst.setInt(1, id);
                    pst.execute();
                    System.out.println("fournisseur deleted");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			return false;
		}     }

    @Override
    public List<Fournisseur> displayAll() {
String sql="Select* from fournisseur";
        List<Fournisseur> list=new ArrayList<>();
        try {
            stmt=cnx.createStatement();
            res=stmt.executeQuery(sql);
            while(res.next()){
                list.add(new Fournisseur(res.getInt("id_fournisseur"),res.getString("firstname"),res.getString("lastname"),res.getString("phoneNumber"),res.getString("type_product"),res.getString("address"),res.getString("email")));
            }
            return list;
        } catch (SQLException ex) {
                        Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;    }

}
