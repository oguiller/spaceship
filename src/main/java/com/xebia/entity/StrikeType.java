package com.xebia.entity;

public enum StrikeType {

    HIT("hit"), MISS("miss"), KILL("kill");

    private String desc;

    StrikeType(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
