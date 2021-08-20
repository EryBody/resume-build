/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FullName;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class fullname {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Full Name");

        String fullname = scanner.nextLine();
        System.out.println("My Name is: " + fullname);
    }
    
}
