package com.converter;

public class Converter {

    private String[] numberTypes= {"Decimal" , "Binary" , "Octal" , "HexDecimal"};
    public String[] getNumberTypes() {
        return numberTypes;
    }


    /**
     * to check if the given number is decimal.
     * @param inputnumberStr the number to be checked.
     * @return true if the number is decimal otherwise false.
     */
    public boolean checkDecimal(String inputnumberStr){
        boolean isDecimal = true;
        String[] numberStr = inputnumberStr.split("");

        String decimalArr = "0123456789";

        for(String s : numberStr){
            if(!decimalArr.contains(s)){
                isDecimal = false;
                break;
            }
        }
        return isDecimal;
    }

    /**
     * to check if the given number is binary.
     * @param inputnumberStr the number to be checked.
     * @return true if the number is binary otherwise false.
     */
    public  boolean checkBinary(String inputnumberStr){
        boolean isBinary = true;
        String[] numberStr = inputnumberStr.split("");

        String binaryArr = "012";

        for(String s : numberStr){
            if (!binaryArr.contains(s)){
                isBinary = false;
                break;
            }
        }
        return isBinary;
    }

    /**
     * to check if the given number is octal.
     * @param inputnumberStr the number to be checked.
     * @return true if the number is octal otherwise false.
     */
    public boolean checkOctal(String inputnumberStr){
        boolean isOctal = true;
        String[] numberStr = inputnumberStr.split("");

        String octalArr = "01234567";

        for (String s : numberStr){
            if (!octalArr.contains(s)){
                isOctal = false;
                break;
            }
        }

        return isOctal;
    }

    /**
     * to check if the given number is hexadecimal.
     * @param inputnumberStr the number to be checked.
     * @return true if the number is hexadecimal otherwise false.
     */
    public boolean checkHexDecimal(String inputnumberStr){
        boolean isHexDecimal = true;
        String[] numberStr = inputnumberStr.split("");

        String hexArr = "0123456789ABCDEF";

        for (String s : numberStr) {
            if (!hexArr.contains(s)) {
                isHexDecimal = false;
                break;
            }
        }
        return isHexDecimal;
    }


    /**
     * to convert a decimal number to binary number.
     * @param decimalNumber the number to be converted.
     * @return the binary number.
     */
    public String DecimalToBinary(String decimalNumber){
        long devResult, devRest;
        long decimalNumberL = Integer.parseInt(decimalNumber);
        String numToRevers ="";
        do {
            devResult = decimalNumberL / 2;
            devRest = decimalNumberL % 2;
            numToRevers += devRest;
            decimalNumberL = devResult;
        }while (devResult != 0);

        char[] ntr = numToRevers.toCharArray();
        String resultStr = "";
        for (int i = ntr.length;i > 0 ; i--){
            resultStr += ntr[i-1];
        }
        return resultStr;
    }

    /**
     * to convert a decimal number to octal number.
     * @param decimalNumber the number to be converted.
     * @return the octal number.
     */
    public String DecimalToOctal(String decimalNumber){
        long devResult, devRest;
        long decimalNumberL = Integer.parseInt(decimalNumber);
        String numToRevers ="";
        do {
            devResult = decimalNumberL / 8;
            devRest = decimalNumberL % 8;
            numToRevers += devRest;
            decimalNumberL = devResult;
        }while (devResult != 0);

        char[] ntr = numToRevers.toCharArray();
        String resultStr = "";
        for (int i = ntr.length;i > 0 ; i--){
            resultStr += ntr[i-1];
        }
        return resultStr;
    }

    /**
     * to convert a decimal number to hexadecimal number.
     * @param decimalNumber the number to be converted.
     * @return the hexadecimal number.
     */
    public String DecimalToHexDecimal(String decimalNumber){
        long devResult, devRest;
        long decimalNumberL = Integer.parseInt(decimalNumber);
        String[] hexArrLetters = {"A","B","C","D","E","F"};
        String numToRevers ="";
        do {
            devResult = decimalNumberL / 16;
            devRest = decimalNumberL % 16;
            if(devRest <= 9){
                numToRevers += devRest;
            }else{
                numToRevers += hexArrLetters[(int)devRest -10];
            }
            decimalNumberL = devResult;
        }while (devResult != 0);

        char[] ntr = numToRevers.toCharArray();
        String resultStr = "";
        for (int i = ntr.length;i > 0 ; i--){
            resultStr += ntr[i-1];
        }
        return resultStr;
    }

    /**
     * to convert a binary number to decimal number.
     * @param binaryNumber the number to be converted.
     * @return the decimal number.
     */
    public String BinaryToDecimal(String binaryNumber){
        String numStr = String.valueOf(binaryNumber);
        String[] numArr = numStr.split("");
        long decimalResult = 0;

        int x = 0;
        for (int i = numArr.length;i > 0 ; i--){
            decimalResult += Integer.parseInt( numArr[i-1]) * Math.pow(2,x);
            x++;
        }
        return String.valueOf(decimalResult);
    }

    /**
     * to convert an octal number to decimal number.
     * @param octalNumber the number to be converted.
     * @return the decimal number.
     */
    public String OctalToDecimal(String octalNumber){
        String numStr = String.valueOf(octalNumber);
        String[] numArr = numStr.split("");
        long decimalResult = 0;

        int x=0;
        for(int i = numArr.length; i > 0 ; i--){
            decimalResult += Integer.parseInt(numArr[i-1])* Math.pow(8,x);
            x++;
        }
        return String.valueOf(decimalResult);
    }

    /**
     * to convert a hexadecimal number to decimal number.
     * @param hexNumber the number to be converted.
     * @return the decimal number.
     */
    public String HexToDecimal(String hexNumber){
        String[] numArr = hexNumber.split("");
        long decimalResult = 0;
        int[] hexarr = {10,11,12,13,14,15};
        String hexarrStr = "ABCDEF";

        for(int i = 0 ; i < numArr.length;i++){
            if (hexarrStr.contains(numArr[i])){
                numArr[i] = String.valueOf(hexarr[hexarrStr.indexOf(numArr[i])]);
            }
        }

        int x = 0;
        for(int i = numArr.length; i > 0 ; i--){
            decimalResult += Double.parseDouble(numArr[i-1]) * Math.pow(16,x);
            x++;
        }
        return String.valueOf(decimalResult);
    }
}

