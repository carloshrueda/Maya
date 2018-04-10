package com.chrc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Maya {
    public String[] dividirFrase(String fraseOriginal, int longMax) {
        String[] strdiv = null;
        int lfo = fraseOriginal.length();

        if (lfo > longMax) {
            String[] vpal = fraseOriginal.split(" ");
            strdiv = new String[vpal.length];
            int pvfr = 0;

            strdiv[0] = vpal[0];
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

    public Integer[] noRepetidos(Integer[] vnum) {
        Set<Integer> set = new HashSet<Integer>();

        if (vnum != null) {
            try {
                for (Integer num : vnum)
                    set.add(num);
                //set.addAll(Arrays.asList(vnum));

            } catch (Exception e) {
                System.out.printf("Error. " + e.getMessage());
            }

            return set.toArray(new Integer[set.size()]);

        } else
            return null;
    }

    public static void main(String[] args) {
        Maya m = new Maya();
        int tam = 10;
        String frase = "Esta es una frase de prueba con longitud mayor a " + tam;
        String[] resultado = m.dividirFrase(frase, tam);

        System.out.println(frase + "\n");
        if (resultado != null) {
            for (String s : resultado)
                System.out.println(s + " : [" + s.length() + "]");
        } else
            System.out.println("NO hay cadena con ese tamano");

        System.out.println("\n--------- EJERCICIO 2 ---------\n");

        // EJECICIO 2

        Integer[] numeros = {1, 2, 3, 1, 2, 3, 4, 6, 6, 5, 6, 4};

        if (numeros != null) {
            for (Integer n : numeros) {
                System.out.print(n.toString() + ", ");

            }
            System.out.println("");

            Integer[] resultint = m.noRepetidos(numeros);

            if (resultint != null)
                for (Integer n : resultint)
                    System.out.print(n.toString() + ", ");

            else
                System.out.println("NO hay cadena con ese tamano");

        } else
            System.out.println("NO hay numeros para evaluar");

        System.out.println("\n");
    }
}
