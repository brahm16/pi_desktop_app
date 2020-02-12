/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Achat;
import entities.Entrepot;
import entities.Fournisseur;

/**
 *
 * @author Ibrahim
 */
public class Test {
    
    public static void main(String[] args) {
      /*  EntrepotService entrepotService=new EntrepotService();
        Entrepot entrepot=new Entrepot("address2", 20, "55558885", "88881118");
        entrepotService.insert(entrepot);
        Entrepot entrepot1=new Entrepot(1,"address2", 40, "55558885", "88881118");
        
        //entrepotService.delete(1);
        entrepotService.displayAll().forEach(System.out::println);*/
        FournisseurService fournisseurService=new FournisseurService();
        fournisseurService.insert(new Fournisseur("aaaa","rrrrrr","888888","ttttt","aaaaa","rrrrr@gmail.com"));
        fournisseurService.displayAll().forEach(System.out::println);
    }
    
}
