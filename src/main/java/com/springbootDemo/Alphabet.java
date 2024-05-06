package com.springbootDemo;

public class Alphabet {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    private final StringBuilder pool;

   public Alphabet(boolean uppercaseInclude, boolean lowercaseIncluded, boolean numbersIncluded, boolean specialCharactersIncldued){
       pool = new StringBuilder();

       if(uppercaseInclude) pool.append(UPPERCASE_LETTERS);
       if(lowercaseIncluded) pool.append(LOWERCASE_LETTERS);
       if(numbersIncluded) pool.append(NUMBERS);
       if(specialCharactersIncldued) pool.append(SYMBOLS);
   }

   public String getAlphabet (){
       return pool.toString();
   }

}
