package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String userInput;

        String[] inputs;
        Crypt crypt = new Crypt();
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        inputs = userInput.split(" ");
        if(inputs[0].equals("encrypt")){
          String encryptedData =  crypt.encrypt(inputs[1]);
            System.out.println("Result: "+encryptedData);
        }else if(inputs[0].equals("decrypt")){
          String decryptedData = crypt.decrypt(inputs[1]);
            System.out.println("Result: "+decryptedData);
        }else{
            System.out.println("Comando inválido: "+inputs[0]);
        }
    }


}
