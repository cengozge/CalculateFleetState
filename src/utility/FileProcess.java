package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import entity.FileOutputObject;
import entity.MyObject;
import enums.EInstanceType;

public class FileProcess {

    public List<MyObject> getListFromFile(String file){

        Utility utility = new Utility();
                
        List<MyObject> listOfObjects = null;
        try {

            BufferedReader bufferedReader = new BufferedReader((new FileReader(file)));
            String line;
            listOfObjects = new ArrayList<MyObject>();
            while ((line = bufferedReader.readLine() ) != null) {
                String s[] = line.split(",");
                if(utility.isValidInstanceType(s[1])){
                    MyObject object = new MyObject();
                    object.setHostId(s[0]);
                    object.setInstanceType(EInstanceType.valueOf(s[1]));
                    object.setNumberOfSlots(Integer.parseInt(s[2]));
                    for (int i = 3; i < s.length; i++) {
                        object.getSlotStates().add(s[i]);
                    }
                    listOfObjects.add(object);
                }
                else{
                    // TODO
                    writeToLogFile("Invalid type " + s[1], "D://Log.txt");
                }
            }
            bufferedReader.close();
        } 

        catch(FileNotFoundException e){
        }
        catch (IOException e) {
        }
        return listOfObjects;
    }
    
    public void writeToFileValidOnes(FileOutputObject output, String file2) throws IOException{
        File file = new File(file2);
        OutputStreamWriter fos;
        try {
            fos = new OutputStreamWriter(new FileOutputStream(file));
            fos.write(output.toString());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    public void writeToLogFile(String string, String file2) throws IOException{
        File file = new File(file2);
        OutputStreamWriter fos;
        try {
            fos = new OutputStreamWriter(new FileOutputStream(file));
            fos.write(string.toString());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
