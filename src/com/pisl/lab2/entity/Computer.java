package com.pisl.lab2.entity;

import java.util.List;

public class Computer {
    private ComputerName name;

    private RAMAmount RAMAmount;

    private List<Additional> additional;

    private List<Garnitur> garnitur;

    private String somethingElse;

    public ComputerName getName() {
        return name;
    }

    public void setName(ComputerName name) {
        this.name = name;
    }

    public RAMAmount getRAMAmount() {
        return RAMAmount;
    }

    public void setRAMAmount(RAMAmount RAMAmount) {
        this.RAMAmount = RAMAmount;
    }

    public List<Additional> getAdditional() {
        return additional;
    }

    public void setAdditional(List<Additional> additional) {
        this.additional = additional;
    }

    public List<Garnitur> getGarnitur() {
        return garnitur;
    }

    public void setGarnitur(List<Garnitur> garnitur) {
        this.garnitur = garnitur;
    }

    public String getSomethingElse() {
        return somethingElse;
    }

    public void setSomethingElse(String somethingElse) {
        this.somethingElse = somethingElse;
    }
}
