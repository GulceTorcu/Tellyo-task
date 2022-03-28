package com.example.task1;

public enum SocialMediaNetworksEnum {

    FACEBOOK("Facebook","FACEBOOK"),
    TWITTER("Twitter", "TWITTER"),
    YOUTUBE("Youtube","YOUTUBE"),
    INSTAGRAM("Instagram","INSTAGRAM"),
    SNAPCHAT("Snapchat","SNAPCHAT");

    public String label;
    public String value;

    private SocialMediaNetworksEnum(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static SocialMediaNetworksEnum getByName(String name) {
        SocialMediaNetworksEnum en = null;
        if(name!=null){
            for(SocialMediaNetworksEnum ven: SocialMediaNetworksEnum.values()){
                if(name.trim().equals(ven.name())){
                    en=ven;
                }
            }
        }
        return en;
    }
}
