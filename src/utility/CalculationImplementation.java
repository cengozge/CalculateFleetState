package utility;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import entity.FileOutputObject;
import entity.MyObject;
import enums.EInstanceType;

public class CalculationImplementation {

    // TODO inputtxt file parametre olsun
    private final static String INPUT_FILE_NAME = "D://FleetState.txt";
    private final static String OUTPUT_FILE_NAME = "D://Statistics.txt";
    private final static String LOG_FILE_NAME = "D://Log.txt";
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    private final static String FULL = "1";
    private final static String EMPTY = "0";

    Utility utility = new Utility();
    FileProcess fp = new FileProcess();

    public void start() throws IOException{
        List<MyObject> listOfObjects = new FileProcess().getListFromFile(INPUT_FILE_NAME);
        List<MyObject> calculatedList = calculateFullAndEmpty(listOfObjects);
        FileOutputObject outputEmpties = calculateEmptiesForInstanceTypes(calculatedList);
        FileOutputObject outputFullsAndEmpties = calculateFullsForInstanceTypes(calculatedList, outputEmpties);
        calculateMostFilled(calculatedList, outputFullsAndEmpties);
        fp.writeToFileValidOnes(outputFullsAndEmpties, OUTPUT_FILE_NAME);
    }


    public List<MyObject> calculateFullAndEmpty(List<MyObject> listOfObjects) throws IOException{

        if(!utility.isNullOrEmpty(listOfObjects)){
            for (MyObject myObject : listOfObjects) {
                int numberOfFull = (int) myObject.getSlotStates().stream().filter(p->p.equals(FULL)).count();
                myObject.setNumberOfFulls(numberOfFull);

                int numberOfEmpty = (int) myObject.getSlotStates().stream().filter(p->p.equals(EMPTY)).count();
                myObject.setNumberOfEmpties(numberOfEmpty);
            }
        }
        return listOfObjects;
    }

    public FileOutputObject calculateEmptiesForInstanceTypes(List<MyObject> listOfObjects) throws IOException{

        int sum = 0;

        //empties
        sum = (int)listOfObjects.parallelStream()
                .filter(b -> EInstanceType.M1.equals(b.getInstanceType()))
                .mapToInt(p -> p.getNumberOfEmpties()).sum();
        FileOutputObject output = new FileOutputObject();
        output.setNumberOfEmptiesM1(sum);

        sum = (int)listOfObjects.parallelStream()
                .filter(b -> EInstanceType.M2.equals(b.getInstanceType()))
                .mapToInt(p -> p.getNumberOfEmpties()).sum();
        output.setNumberOfEmptiesM2(sum);

        sum = (int)listOfObjects.parallelStream()
                .filter(b -> EInstanceType.M3.equals(b.getInstanceType()))
                .mapToInt(p -> p.getNumberOfEmpties()).sum();
        output.setNumberOfEmptiesM3(sum);

        return output;

    }

    public FileOutputObject calculateFullsForInstanceTypes(List<MyObject> listOfObjects, FileOutputObject output){
        //fulls

        int sum = 0;

        sum = (int)listOfObjects.parallelStream()
                .filter(b -> EInstanceType.M1.equals(b.getInstanceType()))
                .mapToInt(p -> p.getNumberOfFulls()).sum();
        output.setNumberOfFullM1(sum);

        sum = (int)listOfObjects.parallelStream()
                .filter(b -> EInstanceType.M2.equals(b.getInstanceType()))
                .mapToInt(p -> p.getNumberOfFulls()).sum();
        output.setNumberOfFullM2(sum);

        sum = (int)listOfObjects.parallelStream()
                .filter(b -> EInstanceType.M3.equals(b.getInstanceType()))
                .mapToInt(p -> p.getNumberOfFulls()).sum();
        output.setNumberOfFullM3(sum);

        return output;
    }

    public FileOutputObject calculateMostFilled(List<MyObject> listOfObjects, FileOutputObject output){
        Optional<MyObject> minM1empty = listOfObjects.parallelStream()
                .filter(b -> EInstanceType.M1.equals(b.getInstanceType())).min(Comparator.comparing(p -> p.getNumberOfEmpties()));

        Optional<MyObject> minM2empty = listOfObjects.parallelStream()
                .filter(b -> EInstanceType.M2.equals(b.getInstanceType())).min(Comparator.comparing(p -> p.getNumberOfEmpties()));

        Optional<MyObject> minM3empty = listOfObjects.parallelStream()
                .filter(b -> EInstanceType.M3.equals(b.getInstanceType())).min(Comparator.comparing(p -> p.getNumberOfEmpties()));

        output.setMinEmptyofM1(minM1empty);
        output.setMinEmptyofM2(minM2empty);
        output.setMinEmptyofM3(minM3empty);

        return output;
    }


}
