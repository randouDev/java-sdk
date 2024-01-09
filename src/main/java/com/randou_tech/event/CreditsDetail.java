package com.randou_tech.event;

public class CreditsDetail {
    public String id;
    public String desc;
    public Integer amount;
    public Integer ts;

    public CreditsDetail(String id, String desc, Integer amount, Integer ts) {
        this.id = id;
        this.desc = desc;
        this.amount = amount;
        this.ts = ts;
    }
}
