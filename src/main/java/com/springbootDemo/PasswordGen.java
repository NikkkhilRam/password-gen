package com.springbootDemo;

import java.util.Scanner;
import javax.swing.*;


public class PasswordGen {

    public void mainLoop() {
        Scanner keyboard  = new Scanner(System.in);
        Generator generator = new Generator(keyboard);
        generator.mainLoop();
        keyboard.close();
    }
}
