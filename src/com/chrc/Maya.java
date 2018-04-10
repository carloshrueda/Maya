package com.chrc;

import java.util.Arrays;

public class Maya {
    public String[] dividirFrase(String fraseOriginal, int longMax) {
        String[] strdiv = null;
        int lfo = fraseOriginal.length();

        if (lfo > longMax){
            String[] vpal = fraseOriginal.split(" ");
            strdiv = new String[vpal.length];
            int pvfr = 0;

            strdiv[0]= vpal[0];
            for (int i = 1; i < vpal.length; i++)
                if (strdiv[pvfr].length() + vpal[i].length() + 1 <= longMax)
                    strdiv[pvfr] += " " + vpal[i];
                else
                    strdiv[++pvfr] = vpal[i];


            return Arrays.copyOfRange(strdiv, 0, pvfr + 1);


        } else if (lfo == longMax) {
            strdiv = new String[1];
            strdiv[0] = fraseOriginal;
        }

        return strdiv;
    }

    public static void main(String[] args) {
        Maya m = new Maya();
        String frase = "Esta es una frase de prueba con longitud mayor a 10";
        String[] resultado = m.dividirFrase(frase, 10);

        System.out.println(frase + "\n");
        if (resultado != null) {
            for (String s : resultado)
                System.out.println(s + " : [" + s.length() + "]");
        } else
            System.out.println("NO hay cadena con ese tamano");

        System.out.println("\n");

    }
}
