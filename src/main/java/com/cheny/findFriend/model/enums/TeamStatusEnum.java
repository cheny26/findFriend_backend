package com.cheny.findFriend.model.enums;

public enum TeamStatusEnum {
    PUBLIC(0,"公开"),
    PRIVATE(1,"私密"),
    SECRET(2, "加密");

    private int num;
    private String status;
     TeamStatusEnum(int num, String status) {
         this.num = num;
         this.status = status;
     }

    public static TeamStatusEnum getEnumByValue(Integer num) {
        if (num == null) {
            return null;
        }
        TeamStatusEnum[] values = TeamStatusEnum.values();
        for (TeamStatusEnum teamStatusEnum : values) {
            if (teamStatusEnum.getNum() == num) {
                return teamStatusEnum;
            }
        }
        return null;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
