/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Entrepot;
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
public class EntrepotService implements IService<Entrepot> {

    private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;

    public EntrepotService() {
        this.cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public boolean insert(Entrepot t) {
        String sql = "insert into product (address,nbrRangs,phone,phone_bis) values (?,?,?,?)";
        try {
            pst = cnx.prepareCall(sql);
            pst.setString(1, t.getAddress());
            pst.setInt(2, t.getNbrRangs());
            pst.setString(3, t.getPhone());
            pst.setString(4, t.getPhone_bis());
            pst.executeUpdate();
            System.out.println("warehouse added successfully");

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean update(Entrepot t) {
        String sql = "update product set address= ? , nbrRangs= ? , phone= ? , phone_bis = ?";
        try {
            pst = cnx.prepareCall(sql);
            pst.setString(1, t.getAddress());
            pst.setInt(2, t.getNbrRangs());
            pst.setString(3, t.getPhone());
            pst.setString(4, t.getPhone_bis());
            pst.executeUpdate();
            System.out.println("entrepot updated");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from entrepot where 	id_entrepot= ? ";

        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("entrepot deleted");
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public List<Entrepot> displayAll() {
        String sql = "Select* from entrepot";
        List<Entrepot> list = new ArrayList<>();
        try {
            stmt = cnx.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
                list.add(new Entrepot(res.getInt("id_entrepot"), res.getString("address"), res.getInt("nbrRangs"), res.getString("phone"), res.getString("phone_bis")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }

}
