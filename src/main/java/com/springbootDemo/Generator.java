package com.springbootDemo;

import java.util.Scanner;

public class Generator {

    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean includeSymbols, boolean includeNumbers, boolean includeLowerCase, boolean includeUpperCase, int length) {
    alphabet = new Alphabet(includeUpperCase,includeLowerCase,includeNumbers, includeSymbols);
    }


    public void mainLoop(){
        System.out.println("Welcome to PasswordGen :)");
        printOptions();
        String selectedOption = "-1";

        while(!selectedOption.equals("3")){
            selectedOption = keyboard.next();
            switch (selectedOption){
                case "1" -> {

                    requestNewPassword();
                    printOptions();
                }
                case "2" -> {

                    checkPasswordStrength();
                    printOptions();
                }
                case "3" -> System.out.println("Thank you !!");
                default -> System.out.println("Thank you");
            }
        }
    }

    private void checkPasswordStrength() {

        System.out.println("Enter the password to check the strength of it.");
        String input = keyboard.next();
        Password password = new Password(input);
        password.checkPassword();

    }

    private void requestNewPassword() {

        boolean includeUpperCase = false;
        boolean includeLowerCase = false;
        boolean includeSymbols = false;
        boolean includeNumbers = false;

        boolean optionsMode = true;

        String input;

        System.out.println();
        System.out.println("Please answer the following questions with Yes or No.");

        while(optionsMode){
            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
            input = keyboard.next();
            includeLowerCase = convertInputToBoolean(input);
            System.out.println("Do you want Lowercase letters \"ABCD...\" to be used? ");
            input = keyboard.next();
            includeUpperCase = convertInputToBoolean(input);
            System.out.println("Do you want Lowercase letters \"!@#$...\" to be used? ");
            input = keyboard.next();
            includeSymbols = convertInputToBoolean(input);
            System.out.println("Do you want Lowercase letters \"1234...\" to be used? ");
            input = keyboard.next();
            includeNumbers = convertInputToBoolean(input);


            if(includeSymbols || includeUpperCase || includeLowerCase || includeNumbers){
                optionsMode = false;
            } else{
                System.err.println("You have selected no characters to generate your password, at least one of your answers should be yes inorder to generate a secure password.");
            }

        }

        System.out.println("Enter the length of the password.");
        int length = keyboard.nextInt();

        final Generator generator = new Generator(includeSymbols, includeNumbers, includeLowerCase, includeUpperCase, length);
        final Password password = generator.generatePassword(length);

        System.err.println("Your generated password -> " + password);

    }

    private Password generatePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }

    private boolean isValidResponse(String input) {
        return (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no"));
    }

    private boolean convertInputToBoolean(String input){
        return input.equalsIgnoreCase("yes");
    }


    private void printOptions() {
        System.out.println("Please select one of the option below:");
        System.out.println("1  ----  Generate Password");
        System.out.println("2  ----  Check Password Strength");
        System.out.println("3  ----  Exit");
    }
}
