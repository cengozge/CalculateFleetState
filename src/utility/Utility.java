package utility;

import java.util.Collection;

import entity.MyObject;
import enums.EInstanceType;

public class Utility {
    
    public boolean isNullOrEmpty(Collection<?> collection){

        return collection == null || collection.size() == 0;
    }
    
    public boolean isValidInstanceType(String type){
        
        return (type.equals(EInstanceType.M1.getText()) || 
                type.equals(EInstanceType.M2.getText()) ||
                type.equals(EInstanceType.M3.getText()));
        
    }

}
