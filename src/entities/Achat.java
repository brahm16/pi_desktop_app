/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ibrahim
 */
public class Achat {
    private int id_achat;	
    private int id_product;	
    private String client_name;	
    private String client_type;	
    private String client_address;	
    private float quantite;
    private int etat;
    private String unite;

    public int getId_achat() {
        return id_achat;
    }

   

    public String getClient_name() {
        return client_name;
    }

    public String getClient_type() {
        return client_type;
    }

    public String getClient_address() {
        return client_address;
    }

    public float getQuantite() {
        return quantite;
    }

    public int getEtat() {
        return etat;
    }

    public void setId_achat(int id_achat) {
        this.id_achat = id_achat;
    }

    public Achat(String client_name, String client_type, String client_address, float quantite, int etat,String unite) {
        this.client_name = client_name;
        this.client_type = client_type;
        this.client_address = client_address;
        this.quantite = quantite;
        this.etat = etat;
        this.unite=unite;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Achat(int id_achat, String client_name, String client_type, String client_address, float quantite, int etat,String unite) {
        this.id_achat = id_achat;
        this.client_name = client_name;
        this.client_type = client_type;
        this.client_address = client_address;
        this.quantite = quantite;
        this.etat = etat;
        this.unite=unite;

    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
  
    public Achat(String client_name, String client_type, String client_address) {
        this.client_name = client_name;
        this.client_type = client_type;
        this.client_address = client_address;
    }
    

    
    
}
