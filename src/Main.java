
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KRC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CheckSumVirloc c = new CheckSumVirloc();
        String trama = ">ACK;ID=7524;#00A8;";
        String chk = c.obtieneCheck(trama);

        System.out.println(chk);
        System.out.println(Integer.toHexString(Integer.parseInt(chk, 2)));
//        String v1 = completeDigBin(decToBin(textoAscci(trama)[0]));
//        String v2 = completeDigBin(decToBin(textoAscci(trama)[1]));
//        String v3 = completeDigBin(decToBin(textoAscci(trama)[1]));
//        String v4 = completeDigBin(decToBin(textoAscci(trama)[1]));
//        System.out.println(v1);
//        System.out.println(v2);
//        System.out.println(v3);
//        System.out.println(v4);
//        String res = xorTwoDat(v1, v2);
//        res = xorTwoDat(res, v3);
//        res = xorTwoDat(res, v4);
//        System.out.println(res);

    }

}
