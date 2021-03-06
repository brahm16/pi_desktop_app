/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Entrepot;
import entities.Stocks;
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
 * @author hp
 */
public class StockService implements IService<Stocks> {

    private Connection cnx;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;

    public StockService() {
        this.cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public boolean insert(Stocks t) {
        String sql = "insert into stocks (quantity,id_product,id_entrepot,unity) values (?,?,?,?)";
        try {
            pst = cnx.prepareCall(sql);
            pst.setFloat(1, t.getQuantity());
            pst.setInt(2, t.getId_product());
            pst.setInt(3, t.getId_entrepot());
            pst.setString(4, t.getUnity());
            pst.executeUpdate();
            System.out.println("Stock added successfully");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean update(Stocks t) {
        String sql = "update stocks set quantity= ? , id_product= ? , id_entrepot= ? , 	unity = ? ";
        try {
            pst = cnx.prepareCall(sql);
            pst.setFloat(1, t.getQuantity());
            pst.setInt(2, t.getId_product());
            pst.setInt(3, t.getId_entrepot());
            pst.setString(4, t.getUnity());
            pst.executeUpdate();
            System.out.println("Stock updated");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from stocks where id_stocks= ? ";

        try {
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("Stock deleted");
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public List<Stocks> displayAll() {
        String sql = "Select * from stocks";
        List<Stocks> list = new ArrayList<>();
        try {
            stmt = cnx.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
                list.add(new Stocks(res.getFloat("quantity"), res.getInt("id_product"), res.getInt("id_entrepot"), res.getString("unity")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }

}
