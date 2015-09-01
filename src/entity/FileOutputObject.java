package entity;

import java.io.Serializable;
import java.util.Optional;

public class FileOutputObject implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -6532507903877851680L;
    private int numberOfEmptiesM1;
    private int numberOfEmptiesM2;
    private int numberOfEmptiesM3;
 
    private int numberOfFullM1;
    private int numberOfFullM2;
    private int numberOfFullM3;
    
    private  Optional<MyObject> minEmptyofM1;
    private  Optional<MyObject> minEmptyofM2;
    private  Optional<MyObject> minEmptyofM3;
    
    public int getNumberOfEmptiesM1() {
        return numberOfEmptiesM1;
    }
    public void setNumberOfEmptiesM1(int numberOfEmptiesM1) {
        this.numberOfEmptiesM1 = numberOfEmptiesM1;
    }
    public int getNumberOfEmptiesM2() {
        return numberOfEmptiesM2;
    }
    public void setNumberOfEmptiesM2(int numberOfEmptiesM2) {
        this.numberOfEmptiesM2 = numberOfEmptiesM2;
    }
    public int getNumberOfEmptiesM3() {
        return numberOfEmptiesM3;
    }
    public void setNumberOfEmptiesM3(int numberOfEmptiesM3) {
        this.numberOfEmptiesM3 = numberOfEmptiesM3;
    }
    public int getNumberOfFullM1() {
        return numberOfFullM1;
    }
    public void setNumberOfFullM1(int numberOfFullM1) {
        this.numberOfFullM1 = numberOfFullM1;
    }
    public int getNumberOfFullM2() {
        return numberOfFullM2;
    }
    public void setNumberOfFullM2(int numberOfFullM2) {
        this.numberOfFullM2 = numberOfFullM2;
    }
    public int getNumberOfFullM3() {
        return numberOfFullM3;
    }
    public void setNumberOfFullM3(int numberOfFullM3) {
        this.numberOfFullM3 = numberOfFullM3;
    }
    
    public  Optional<MyObject> getMinEmptyofM1() {
        return minEmptyofM1;
    }
    public void setMinEmptyofM1( Optional<MyObject> minEmptyofM1) {
        this.minEmptyofM1 = minEmptyofM1;
    }
    public  Optional<MyObject> getMinEmptyofM2() {
        return minEmptyofM2;
    }
    public void setMinEmptyofM2( Optional<MyObject> minEmptyofM2) {
        this.minEmptyofM2 = minEmptyofM2;
    }
    public  Optional<MyObject> getMinEmptyofM3() {
        return minEmptyofM3;
    }
    public void setMinEmptyofM3( Optional<MyObject> minEmptyofM3) {
        this.minEmptyofM3 = minEmptyofM3;
    }
    
    @Override
    public String toString() {
        return new StringBuffer("EMPTY: M1=").append(this.getNumberOfEmptiesM1()).append(";")
        .append("M2=").append(this.getNumberOfEmptiesM2()).append(";")
        .append("M3=").append(this.getNumberOfEmptiesM3())
        .append(System.getProperty("line.separator"))
        .append("FULL: M1=").append(this.getNumberOfFullM1()).append(";")
        .append("M2=").append(this.getNumberOfFullM2()).append(";")
        .append("M3=").append(this.getNumberOfFullM3())
        .append(System.getProperty("line.separator"))
        .append("MOST FILLED: M1=").append(this.getMinEmptyofM1().get().getNumberOfSlots()).append(",").append(this.getMinEmptyofM1().get().getNumberOfEmpties()).append(";")
        .append("M2=").append(this.getMinEmptyofM2().get().getNumberOfSlots()).append(",").append(this.getMinEmptyofM2().get().getNumberOfEmpties()).append(";")
        .append("M3=").append(this.getMinEmptyofM3().get().getNumberOfSlots()).append(",").append(this.getMinEmptyofM3().get().getNumberOfEmpties())
        .toString();
        }
}
