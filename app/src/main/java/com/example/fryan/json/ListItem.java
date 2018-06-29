package com.example.fryan.json;

public class ListItem {

    private String head;
    private String desc;
    private String imageUrl;
    private  String Realname;
    private String Team;
    private  String Firstappearance;
    private  String Createdby;
    private String Publisher;




    public ListItem(String head, String desc, String imageUrl,String realname, String team, String firstappearance, String createdby, String Publisher) {
        this.head = head;
        this.desc = desc;
        this.imageUrl = imageUrl;
        Realname = realname;
        Team = team;
        Firstappearance = firstappearance;
        Createdby = createdby;
        this.Publisher = Publisher;

    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getRealname() {
        return Realname;
    }

    public String getTeam() {
        return Team;
    }

    public String getFirstappearance() {
        return Firstappearance;
    }

    public String getCreatedby() {
        return Createdby;
    }

    public String getPublisher() {
        return Publisher;
    }
}