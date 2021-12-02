/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;

/**
 *
 * @author Marisol
 */
public class GeneradorContraseñas {
   public static String getRandomString(int i) 
    { 
        String alfabeto;
        StringBuilder constructor;
        
        alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; 

        //create the StringBuffer
        constructor = new StringBuilder(i); 

        for (int m = 0; m < i; m++) { 
            // generate numeric
            int myindex 
                = (int)(alfabeto.length()* Math.random()); 

            // add the characters
            constructor.append(alfabeto.charAt(myindex)); 
        } 

        return constructor.toString(); 
    } 
   
}
