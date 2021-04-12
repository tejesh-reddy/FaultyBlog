package com.company.OCP;


// Here, the problem is that if we want to add a new prompt, we have to change an existing class (prompt)
// This violates the Open Close principle
// I've resolved this by using a prompt interface to create separate prompt classes for separate uses
// This ensures OCP is not violated.
public class Prompt {
    void showPrompt(String type)
    {
        if(type.equals("login"))
            System.out.println("login prompt: ");
        else if(type.equals("action"))
            System.out.println("Choose action: ");
        else
            System.out.println("default prompt: ");
    }
}
