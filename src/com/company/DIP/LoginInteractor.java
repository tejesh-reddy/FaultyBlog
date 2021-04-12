package com.company.DIP;

import com.company.OCP.Prompt;


// Here the loginInteractor hardcodes it's own prompt type.
// This creates an inflexibility as it is depending upon the concrete class LoginPrompt and is violating DIP
// As DIP states that classes must depend on abstractions instead of lower level classes,
// I've create a Prompt interface and added it to interactor constructor as an argument.
// This ensures that we can vary prompt and interactor independently of each other, thereby inverting the dependency.
public class LoginInteractor {
    private Prompt loginPrompt;

    public LoginInteractor()
    {
        this.loginPrompt = new LoginPrompt();
    }
}
