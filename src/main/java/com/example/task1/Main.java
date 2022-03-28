package com.example.task1;

public class Main {

    public static void main(String[] args) {

        String networksOne = "twitter,facebook";
        String networksTwo = "facebook,youtube,blablabla";

        String andResult = new SocialMediaNetworks().and(networksOne, networksTwo);
        String orResult = new SocialMediaNetworks().or(networksOne, networksTwo);

        System.out.println(andResult + "|" + orResult);

        String actionsOne = "add,delete,qwerty";
        String actionsTwo = "delete,asdfg,update";

        andResult = new AllowedActions().and(actionsOne, actionsTwo);
        orResult = new AllowedActions().or(actionsOne, actionsTwo);
        
        System.out.println(andResult + "|" + orResult);
    }
}
