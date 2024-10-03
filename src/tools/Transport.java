package tools;

import Exeptions.NoSuchModelNameException;
import interfaces.Vehicle;

import java.util.Arrays;

public class Transport {
    public static void printNames(Vehicle vehicle){//!!!!;
       System.out.println(Arrays.toString(vehicle.getNames()));
    }
    public static double getAverage(Vehicle vehicle){
        double sum = 0;
        for (Double s:vehicle.getPrices()){
            sum+=s;
        }
        return sum/vehicle.length();
    }
    public static void printModels(Vehicle vehicle) {
        String [] names = vehicle.getNames();
        try {
        for (int i =0;i<names.length;i++){
            System.out.println(i+". "+names[i]+" Цена:"+vehicle.getPrice(names[i]));
        }}catch (NoSuchModelNameException e){
            System.out.println(e.toString());
        }
    }
}
