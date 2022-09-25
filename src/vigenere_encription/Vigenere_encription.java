/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vigenere_encription;

import java.util.Scanner;

/**
 *
 * @author alexd
 */
public class Vigenere_encription {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner rd = new Scanner (System.in);
        String [] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        //Variable para clave
        String k = "";
        
        System.out.print("Escriba la clave para encriptar: ");
        k = rd.next();
        //Array que contendrá la clave divido en caracteres
        String [] key = k.split("");
        
        //Variable para guardar la contraseña
        String p = "";
        System.out.print("Escriba la contraseña que será encriptada: ");
        p = rd.next();
        //Array que contendrá la contraseña divido en caracteres
        String [] password = p.split("");
        
        //Array para el mensaje encriptado
        String [] Ci = new String [password.length];
        
        //Array para el mensaje desencriptado
        String [] Mi = new String [password.length];
        
        //-------------- FORMULA: Ci = (Mi + Ki) mod longitud_alphabet --------------//
        //Desarrollo de algoritmo de encriptación
        
        for (int i = 0; i < password.length; i++) {
            String count_psswrd = password[i];
            String count_key = key[i];
            
            int j_D1 = 0; //<--- Contador para las posiciones de la contraseña
            int j_D2 = 0; //<--- Contador para las posiciones de la clave
            
            boolean Data1 = false; //identificador de finalizacion de ciclo de la contraseña
            boolean Data2 = false; //identificador de finalizacion de ciclo de la clave
            
            //Ciclo para calcular posiciones de Mi
            while(Data1 == false) {
                if(count_psswrd.equals(alphabet[j_D1])) {
                    Data1 = true;
                }else {
                    j_D1++;
                }
            }
            //Ciclo para calcular posiciones de Ki
            while(Data2 == false) {
                if(count_key.equals(alphabet[j_D2])) {
                    Data2 = true;
                }else {
                    j_D2++;
                }
            }
            //IMPLEMENTACIÓN DE FÓMULA Y ASIGNACIÓN DE CARACATER PARA EL MENSAJE ENCRIPTADO
            int position = (j_D1 + j_D2) % alphabet.length;
            Ci[i] = alphabet[position];
        }
        
        //IMPRESIÓN DE CONTRASEÑA ENCRIPTADA
        System.out.print("Contraseña encriptada: ");
        for (int i = 0; i < Ci.length; i++) {
            System.out.print(Ci[i]+" ");
        }
        System.out.println();
        
        /*------------------- DESCENCRIPTACIÓN ---------------------*/
        //-------------- FORMULA: Mi = (Ci + Ki) mod longitud_alphabet --------------//
        //Desarrollo de algoritmo de desencriptación
        
        for (int i = 0; i < Ci.length; i++) {
            String count_Ci = Ci[i];
            String count_key = key[i];
            
            int j_D1 = 0; //<--- Contador para las posiciones de la encriptación
            int j_D2 = 0; //<--- Contador para las posiciones de la clave
            
            boolean Data1 = false; //identificador de finalizacion de ciclo de la encriptación
            boolean Data2 = false; //identificador de finalizacion de ciclo de la clave
            
            //Ciclo para calcular posiciones de Ci
            while(Data1 == false) {
                if(count_Ci.equals(alphabet[j_D1])) {
                    Data1 = true;
                }else {
                    j_D1++;
                }
            }
            //Ciclo para calcular posiciones de Ki
            while(Data2 == false) {
                if(count_key.equals(alphabet[j_D2])) {
                    Data2 = true;
                }else {
                    j_D2++;
                }
            }
            //IMPLEMENTACIÓN DE FÓMULA Y ASIGNACIÓN DE CARACATER PARA EL MENSAJE ENCRIPTADO
            int position = (j_D1 - j_D2);
            int position_real;
            if((position*(-1)) < alphabet.length && position < 0) {
                position_real = position + alphabet.length;
                Mi[i] = alphabet[position_real];
            }else {
                Mi[i] = alphabet[position];
            }
        }
        //IMPRESIÓN DE CONTRASEÑA DESENCRIPTADA
        System.out.print("Contraseña desencriptada: ");
        for (int i = 0; i < Mi.length; i++) {
            System.out.print(Mi[i]+" ");
        }
        System.out.println();
    }
    
}
