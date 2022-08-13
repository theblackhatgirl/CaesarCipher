package com.company;

import java.util.Random;

public class Crypt {
    String[] alphabet = new String[]{"A", "B", "C", "D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    public String encrypt (String data){
        int salt;
        String result = "";

        Random random = new Random();
        salt = random.nextInt(26);
        for(int i = 0; i < data.length(); i++){
            Character character = data.charAt(i);
            for(int j = 0; j < alphabet.length; j++){
                String letter = alphabet[j];
                if (letter.equals(character.toString().toUpperCase())){
                     result += alphabet[(j+salt) % 26];
                }
            }
        }
        if(salt <= 9){
          result = "0"+salt+result;
        }else{
            result = salt+result;
        }
        return result;
    }
    public String decrypt (String data){
        int salt;
        String result = "";
        String cut = data.substring(0,2);
        salt = Integer.parseInt(cut);
        String encryptedData = data.substring(2);
        for(int i = 0; i< encryptedData.length(); i++){
            Character character = encryptedData.charAt(i);
            for (int j = 0; j < alphabet.length; j++){
                String letter = alphabet[j];
                if (letter.equals(character.toString().toUpperCase())){

                    if(j - salt < 0){
                        result += alphabet[26 - Math.abs (j-salt)];
                    }else{
                        result += alphabet[(j-salt)%26];
                    }
                }
            }
        }
        return result;

    }

}
