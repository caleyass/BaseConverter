package com.company;

import java.io.IOException;

public class Converting {
    private int fromBase, toBase;
    private StringBuilder number = new StringBuilder();
    static String arr;

    Converting(){
        StringBuilder str = new StringBuilder("");
        char ch = 'A';
        do{
            str.append(ch);
            ch++;
        }while (ch<'Z');
        arr = str.toString();
    }

    public void getP(){
        do {
            System.out.println("Input number base from 1 to 36, in which your number is represented : ");
            fromBase = DataInput.getInt();
        } while(fromBase<=1 || fromBase>36);
    }
    public void getN(){
        System.out.println("Input number that you want to convert to another base" +
                    "If it has a fractional part, then separate it with a coma");
            try {
                number = new StringBuilder(DataInput.String());
                }
            catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void getQ(){
        do {
            System.out.println("Input number base from 1 to 36, in which you want to convert a number : ");
            toBase = DataInput.getInt();
        } while(toBase<=1 || toBase>36);
    }

    //firstly we're going to convert to decimal num system
    //from p-system to 10-system
    public void toDecimal() {
        String num = String.valueOf(number);
        String decimal_part = "";
        //find a comma and define a decimal part
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == ',') {
                num = number.substring(0, i);
                decimal_part = number.substring(i + 1);
                break;
            }
        }
        String converted_dec_part = null;

        //change letters to numbers
        if (!decimal_part.equals("")) {
            converted_dec_part = convertDecimalPart(decimal_part).substring(1);
            if(toBase!=10){
                converted_dec_part =","+fromDecimalSystem(converted_dec_part);
            }
        }

        String answer = Integer.toString(Integer.parseUnsignedInt(num, fromBase), toBase);
        answer = answer.toUpperCase();
        if(converted_dec_part== null)
            System.out.println(answer);
        else System.out.println(answer +converted_dec_part);
    }
    //returns converted decimal part
    public String convertDecimalPart(String dec_part){
        StringBuilder res = new StringBuilder();
        double final_num_for_appending = 0;
        int converted_num;
        for(int i=0; i < dec_part.length(); i++){
            //append number which located at i
            if(dec_part.charAt(i) > 'A')
                converted_num= charToInt(dec_part.charAt(i));
            else converted_num = (int) (dec_part.charAt(i)-'0');
            final_num_for_appending += converted_num*Math.pow(fromBase, -(i+1) );
        }
        res.append(final_num_for_appending);
        return res.toString();
    }

    //converts decimal part from dec system
    //@param String num - decimal part which we convert in toBase system
    private String fromDecimalSystem(String num){
        // num which we will multiply for defining num in toBase system
        double d_num = Double.parseDouble("0"+num);
        StringBuilder res = new StringBuilder();
        double num_to_multiply = d_num;
        for(int i=0; i<8; i++){
            //final num which we add
            int num_to_add = (int) (num_to_multiply * toBase);
            num_to_multiply = (num_to_multiply * toBase)-num_to_add;
            if(num_to_add>=10){
                char convertedNum = intToChar(num_to_add);
                res.append(convertedNum);
            }
            else res.append(num_to_add);
        }
        return res.toString();
    }

    // convert a character number to an integer number
    private int charToInt(char num) {
        int c_num = 0; // converted number

        for(int i=0; i< arr.length(); i++){
            if(Character.toUpperCase(num) == arr.charAt(i)) {
                c_num = i+10;
                break;
            }
        }
        return c_num;
    }
    //convert an int number to a char number
    private char intToChar(int num){
        char ch = arr.charAt(num-10);
        return ch;
    }
}
