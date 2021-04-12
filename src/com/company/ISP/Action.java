package com.company.ISP;

public interface Action {
    public void doit();

    public Action nextAction();
}

// Here, the interface forces us to implement nextAction() which is invalid for certain cases such as below
// This also violates the LSP for interfaces.
// To remedy this, I've created two seperate interfaces so that they can be used according to need
// This is the reason for Action and FinalAction interfaces in BlogDemo
class deleteAccount implements Action
{
    public void doit()
    {
        // Delete Account code
    }

    public Action nextAction() throws Exception {
        // Can't implement this as there are no actions to be performed after
        throw new Exception("Delete is a final action, doesn't have a follow up action");
    }
}