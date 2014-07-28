

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KRC
 */
public class CheckSumVirloc {

    public int[] textoAscci(String text) {
        int val[] = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            val[i] = (int) text.charAt(i);
        }
        return val;
    }

    public int decToBin(int numero) {
        int exp = 0, digito, binario = 0;
        while (numero != 0) {
            digito = numero % 2;
            binario = binario + digito * (int) (Math.pow(10, exp));
            exp++;
            numero = numero / 2;
        }
        return binario;
    }

    public String completeDigBin(int bin) {
        String binCom = "" + bin;
        while (binCom.length() < 8) {
            binCom = "0" + binCom;
        }
        return binCom;
    }

    public boolean XOR(boolean x, boolean y) {
        return ((x || y) && !(x && y));
    }

    public String obtieneCheck(String data) {
        int ass[] = textoAscci(data);
        String bin = completeDigBin(decToBin(ass[0]));
        for (int i = 1; i < ass.length; i++) {
            bin = xorTwoDat(bin, completeDigBin(decToBin(ass[i])));
        }
        return bin;
    }

    public  String xorTwoDat(String valBin1, String valBin2) {
        String res = "";
        boolean x = false, y = false;
        for (int i = 0; i < valBin1.length(); i++) {
            if (valBin1.charAt(i) == '1') {
                x = true;
            }
            if (valBin2.charAt(i) == '1') {
                y = true;
            }
            if (XOR(x, y)) {
                res += "1";
            } else {
                res += "0";
            }
            x = false;
            y = false;
        }
        return res;
    }
}
