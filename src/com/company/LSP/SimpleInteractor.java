package com.company.LSP;

import com.company.OCP.Prompt;

public class SimpleInteractor {
    public SimpleInteractor()
    {
    }

    public void interact()
    {

    }

    public void getDetails()
    {

    }
}


// Here, the action interactor doesn't provide all the functionality of the parent class
// This clearly violates the Liskov Substitution Principle
// I've resolved this by keeping only the methods that are common among interactors and encapsulating only them.
class ActionInteractor() extends SimpleInteractor
{
    public void interact()
    {
        throw new Exception("Action can't have normal interaction")
    }
}
