package com.pojo;

public class Log
{
    //id值
    private int id;
    //收款账号
    private String accIn;
    //转账账号
    private String accOut;
    //金额
    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccIn() {
        return accIn;
    }

    public void setAccIn(String accIn) {
        this.accIn = accIn;
    }

    public String getAccOut() {
        return accOut;
    }

    public void setAccOut(String accOut) {
        this.accOut = accOut;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
