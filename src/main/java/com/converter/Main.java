package com.converter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String more = "x";
        Scanner sc = new Scanner(System.in);

        do {
            try {
                calcNumber();
            }catch (Exception e){
                System.out.println("the number is too big!!!");
            }
            System.out.println("\n\nc: continue \t other: exit");
            more = sc.nextLine();
            more = more.toLowerCase();
        }while (more.equals("c"));

    }

    private static void calcNumber() {
        Scanner sc = new Scanner(System.in);
        int type;
        String inputNumberStr;
        String dec="" , bin ="", oct="" , hex = "";


        Converter c = new Converter();

        int i = 0;
        for (String t : c.getNumberTypes()){
            i++;
            System.out.println((i) + "  --  " + t);
        }

        do {
            System.out.print("Chose the type of the number you want to convert[1-4]: ");
            String typeStr = sc.nextLine();
            try{
                type = Integer.parseInt(typeStr);
            }catch (NumberFormatException ex) {
                type = 5;
            }
        }while (type < 1 || type > 4);

        boolean isVaild = false;

        do {
            System.out.print("Enter the number now: ");
            inputNumberStr = sc.nextLine();

            switch (type){
                case 1:
                    isVaild = c.checkDecimal(inputNumberStr);
                    if (isVaild){
                        dec = inputNumberStr;
                        bin = c.DecimalToBinary(dec);
                        oct = c.DecimalToOctal(dec);
                        hex  = c.DecimalToHexDecimal(dec);
                    }
                    break;
                case 2:
                    isVaild = c.checkBinary(inputNumberStr);
                    if (isVaild){
                        bin = inputNumberStr;
                        dec = c.BinaryToDecimal(bin);
                        oct = c.DecimalToOctal(dec);
                        hex = c.DecimalToHexDecimal(dec);
                    }
                    break;
                case 3:
                    isVaild = c.checkOctal(inputNumberStr);
                    if (isVaild){
                        oct = inputNumberStr;
                        dec = c.OctalToDecimal(oct);
                        bin  = c.DecimalToBinary(dec);
                        hex = c.DecimalToHexDecimal(dec);
                    }
                    break;
                case 4:
                    isVaild = c.checkHexDecimal(inputNumberStr);
                    if (isVaild){
                        hex = inputNumberStr;
                        dec= c.HexToDecimal(hex);
                        bin = c.DecimalToBinary(dec);
                        oct = c.DecimalToOctal(dec);
                    }
                    break;
            }
        }while(!isVaild);

        System.out.println("Dec: " + dec + " - Bin: " + bin + " - Oct: " + oct  + " - Hex: " + hex);

    }


}