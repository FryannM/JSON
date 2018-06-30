package com.example.fryan.json;

import android.graphics.Bitmap;

public class ListItem {

    private String head;
    private String desc;
    private String Team;
    private  String image;




    public ListItem(String head,
                    String desc,
                    String Team,String image

                    ) {
        this.head = head;
        this.desc = desc;
        this.Team = Team;
        this.image = image;



    }

    public String getHead() {
        return head;
    }

    public String getDesc() { return desc;
    }

    public String getTeam() { return Team;
    }

    public String getImage() { return image;
    }







}