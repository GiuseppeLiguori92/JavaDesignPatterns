package com.giuseppeliguori.designpattern.creational.prototype;

/**
 * Created by giuseppeliguori on 05/05/2017.
 */
public class Computer implements Cloneable {
    private int id;
    private String name;
    private int motherBoardId;
    private String motherBoardName;
    private int moterBoardYearRelease;
    private int cpuId;
    private String cpuName;
    private int cpuYearRelease;

    public Computer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMotherBoardId() {
        return motherBoardId;
    }

    public void setMotherBoardId(int motherBoardId) {
        this.motherBoardId = motherBoardId;
    }

    public String getMotherBoardName() {
        return motherBoardName;
    }

    public void setMotherBoardName(String motherBoardName) {
        this.motherBoardName = motherBoardName;
    }

    public int getMoterBoardYearRelease() {
        return moterBoardYearRelease;
    }

    public void setMoterBoardYearRelease(int moterBoardYearRelease) {
        this.moterBoardYearRelease = moterBoardYearRelease;
    }

    public int getCpuId() {
        return cpuId;
    }

    public void setCpuId(int cpuId) {
        this.cpuId = cpuId;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public int getCpuYearRelease() {
        return cpuYearRelease;
    }

    public void setCpuYearRelease(int cpuYearRelease) {
        this.cpuYearRelease = cpuYearRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", motherBoardId=" + motherBoardId +
                ", motherBoardName='" + motherBoardName + '\'' +
                ", moterBoardYearRelease=" + moterBoardYearRelease +
                ", cpuId=" + cpuId +
                ", cpuName='" + cpuName + '\'' +
                ", cpuYearRelease=" + cpuYearRelease +
                '}';
    }

    @Override
    protected Object clone() {
        System.out.println("*Computer.clone*");
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
