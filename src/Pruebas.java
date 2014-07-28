/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KRCDIEGO
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String trama = ">ACK;ID=7524;#00A8;*";
        CheckSumVirloc ch= new CheckSumVirloc();
        int codAssc[]=ch.textoAscci(trama);
        for (int i =0;i<codAssc.length;i++) {
            System.out.println(ch.completeDigBin(ch.decToBin(codAssc[i])));
            
        }
        
        
        
    }
    
}
