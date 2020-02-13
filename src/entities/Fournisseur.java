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
public class Fournisseur {
    private int id_fournisseur;
    private String firstname;
    private String lastname;
    private String phoneNumber;private String type_product;
    private String address;
    private String email;

    public Fournisseur(String firstname, String lastname, String phoneNumber, String type_product, String address, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.type_product = type_product;
        this.address = address;
        this.email = email;
    }

    public Fournisseur(int id_fournisseur, String firstname, String lastname, String phoneNumber, String type_product, String address, String email) {
        this.id_fournisseur = id_fournisseur;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.type_product = type_product;
        this.address = address;
        this.email = email;
    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType_product() {
        return type_product;
    }

    public void setType_product(String type_product) {
        this.type_product = type_product;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "id_fournisseur=" + id_fournisseur + ", firstname=" + firstname + ", lastname=" + lastname + ", phoneNumber=" + phoneNumber + ", type_product=" + type_product + ", address=" + address + ", email=" + email + '}';
    }
    
    
}
