package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import enums.EInstanceType;

public class MyObject implements Serializable{

    private String hostId;
    private EInstanceType instanceType;
    private int numberOfSlots;
    private List<String> slotStates;
    private int numberOfEmpties;
    private int numberOfFulls;
    
    public MyObject(){
        this.setSlotStates(new ArrayList<String>());
    }
    
    public String getHostId() {
        return hostId;
    }
    public void setHostId(String hostId) {
        this.hostId = hostId;
    }
    public EInstanceType getInstanceType() {
        return instanceType;
    }
    public void setInstanceType(EInstanceType instanceType) {
        this.instanceType = instanceType;
    }
    public int getNumberOfSlots() {
        return numberOfSlots;
    }
    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }
    public List<String> getSlotStates() {
        return slotStates;
    }
    public void setSlotStates(List<String> slotStates) {
        this.slotStates = slotStates;
    }
    public int getNumberOfEmpties() {
        return numberOfEmpties;
    }
    public void setNumberOfEmpties(int numberOfEmpties) {
        this.numberOfEmpties = numberOfEmpties;
    }
    public int getNumberOfFulls() {
        return numberOfFulls;
    }
    public void setNumberOfFulls(int numberOfFulls) {
        this.numberOfFulls = numberOfFulls;
    }
    
    @Override
    public String toString(){
        return "Wrong type of insance: "+ this.getInstanceType().getText();
    }
    
}
