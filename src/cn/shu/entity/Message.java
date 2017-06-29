package cn.shu.entity;

/**
 * Created by xc on 2017/6/29.
 */
public class Message {
    String id;
    String time; //发送时间
    String energy; // 发电量
    String power; //功率

    public Message() {
    }

    public Message(String id, String time, String energy, String power) {
        this.id = id;
        this.time = time;
        this.energy = energy;
        this.power = power;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
