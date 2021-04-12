package com.company.SRP;

import java.util.Scanner;


// Details class here provides storage and retrieval for user details and also has the support for user actions
// This clearly violates the single responsibility principle.
// To remedy this, i've created a seperate class for action support, seperating it from details
public class Details {
    private Username username;
    private Password password;
    private ActionInteractor actionInterface;


    // setters and getters
    public void setUser(Username username) {
        this.username = username;
        actionInterface = new ActionInteractor(new DetailsPrompt());
    }

    public Username getUser(){
        return this.username;
    }

    public void setPassword(Password password){
        this.password = password;
    }

    public Password getPassword(){
        return this.password;
    }

    // actions
    public Action getActionToDo() throws Exception {
        return actionInterface.getAction();
    }

    public void doAction(Action a) {
        a.doit(this);
    }

    private static Action action;
    private enum ActionOpt {CREATE, READ}


    public static void setAction(ActionOpt opt)
    {
        switch (opt) {
            case CREATE -> action = new CreateBlogAction();
            case READ -> action = new ReadNextBlog();
        }
    }

    public static Action getAction()
    {
        return action;
    }

    // showing options
    public static void showOptions()
    {
        int i = 0;
        for(ActionOpt op : ActionOpt.values()){
            i++;
            System.out.println(i+": "+op);
        }
    }

    // extracting options
    public static ActionOpt selectedOpt(int selection) throws Exception{
        int i = 1;
        for(ActionOpt op: ActionOpt.values()){
            if(i == selection)
                return op;
            i++;
        }

        throw new Exception("Invalid Option for Action -- ActionOpt (Details)");
    }
}

class ActionInteractor extends SimpleInteractor {

    public ActionInteractor(Prompt prompt) {
        super(prompt);
    }

    @Override
    public void showPrompt() {
        prompt.showPrompt();
        ActionSupport.showOptions();
    }

    public Action getAction() throws Exception{
        Scanner s = new Scanner(System.in);
        showPrompt();
        prompt.secondaryPrompt();
        ActionSupport.setAction(ActionSupport.selectedOpt(s.nextInt()));
        return ActionSupport.getAction();
    }
}