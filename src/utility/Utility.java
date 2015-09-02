package utility;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
    
    public boolean isTotalSlotEqualSumOfEmptyAndFull(MyObject myObject, int sum){
        
        return myObject.getNumberOfSlots() == sum;
        
    }

    public Map<String, String> getPropertyValues(){
        Map<String, String> fileMap = new HashMap<String, String>();
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
                fileMap.put("INPUT_FILE_NAME", prop.getProperty("INPUT_FILE_NAME"));
                fileMap.put("OUTPUT_FILE_NAME", prop.getProperty("OUTPUT_FILE_NAME"));
                fileMap.put("LOG_FILE_NAME", prop.getProperty("LOG_FILE_NAME"));
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found");
            }
        }
        catch(Exception e){

        }
        
        return fileMap;
    }
}
