package com.example.tellyo;

public enum AllowedActionsEnum {

    ADD("Add","ADD"),
    DELETE("Delete","DELETE"),
    MODIFY("Modify","MODIFY"),
    CLEAR("Clear","CLEAR"),
    HIDE("Hide","HIDE");


    public String label;
    public String value;

    private AllowedActionsEnum(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static AllowedActionsEnum getByName(String name) {
        AllowedActionsEnum en = null;
        if(name!=null){
            for(AllowedActionsEnum ven: AllowedActionsEnum.values()){
                if(name.trim().equals(ven.name())){
                    en=ven;
                }
            }
        }
        return en;
    }
}
