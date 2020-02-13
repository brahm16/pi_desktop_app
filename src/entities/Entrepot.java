/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.logging.Logger;

/**
 *
 * @author Ibrahim
 */
public class Entrepot {
    private int id_entrepot;	
    private String address;	
    private int nbrRangs;	
    private String phone;
    private String phone_bis;

    public int getId_entrepot() {
        return id_entrepot;
    }

    public String getAddress() {
        return address;
    }

    public int getNbrRangs() {
        return nbrRangs;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhone_bis() {
        return phone_bis;
    }

    public void setId_entrepot(int id_entrepot) {
        this.id_entrepot = id_entrepot;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNbrRangs(int nbrRangs) {
        this.nbrRangs = nbrRangs;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhone_bis(String phone_bis) {
        this.phone_bis = phone_bis;
    }

    public Entrepot(int id_entrepot, String address, int nbrRangs, String phone, String phone_bis) {
        this.id_entrepot = id_entrepot;
        this.address = address;
        this.nbrRangs = nbrRangs;
        this.phone = phone;
        this.phone_bis = phone_bis;
    }

    public Entrepot(String address, int nbrRangs, String phone, String phone_bis) {
        this.address = address;
        this.nbrRangs = nbrRangs;
        this.phone = phone;
        this.phone_bis = phone_bis;
    }

    @Override
    public String toString() {
        return "Entrepot{" + "id_entrepot=" + id_entrepot + ", address=" + address + ", nbrRangs=" + nbrRangs + ", phone=" + phone + ", phone_bis=" + phone_bis + '}';
    }
    
    
        
}
