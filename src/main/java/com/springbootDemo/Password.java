package com.springbootDemo;

public class Password {
    String value;
    int length;


    @Override
    public String toString() {
        return value;
    }



    public void checkPassword() {
        int val = 0;
        for (int i = 0; i < value.length(); i++) {
            char C = value.charAt(i);
            if ((int) C >= 65 && (int) C <= 90) {
                val = 1;
            } else if ((int) C >= 97 && (int) C <= 122) {
                val = 2;
            } else if ((int) C >= 48 && (int) C <= 57) {
                val = 3;
            } else {
                val = 4;
            }
        }
        generateRemarks(val);
    }


    private void generateRemarks(int val) {
        if(val == 1){
            System.out.println("Your password is very weak. It's highly recommended to use a stronger combination of characters to enhance security.");
            System.out.println("=== === \uD83D\uDE1E");
        } else if(val == 2){
            System.out.println("Your password is weak. Consider adding a mix of uppercase letters, lowercase letters, numbers, and symbols for better security.");
            System.out.println("=== === === === 💩");
        } else if(val == 3){
            System.out.println("Your password is strong. It includes a good mix of character types, making it difficult for attackers to guess or brute-force.");
            System.out.println("=== === === === === === 👍");
        } else if(val == 4){
            System.out.println("Your password is strong. It includes a good mix of character types, making it difficult for attackers to guess or brute-force.");
            System.out.println("=== === === === === === === ===  🤩");

        } else {
            System.out.println("Your password is very weak. Please change it soon.");
        }
    }


    public  Password(String s) {
    value = s;
    length = s.length();
}

}
