package tools;

import Exeptions.DuplicateModelNameException;
import Exeptions.NoSuchModelNameException;
import interfaces.Vehicle;

public class TransportTests {
    private Vehicle vehicle;
   public TransportTests(Vehicle vehicle) {
      this.vehicle = vehicle;
   }
   public void startNormal() throws DuplicateModelNameException, NoSuchModelNameException {
       System.out.println(">");
       vehicle.addItem("M1",1000);
       vehicle.addItem("M2",19090);
       vehicle.addItem("M5",90129);
       vehicle.addItem("M10",9019);
       vehicle.delItem("M10");
       vehicle.setItemName("M5","M33");
       vehicle.setPrice("M2",100);
       Transport.printModels(vehicle);
       System.out.println(String.format("%.2f",Transport.getAverage(vehicle)));
   }
   public void startErr() throws DuplicateModelNameException, NoSuchModelNameException {
       vehicle.addItem("M1",1000);
       vehicle.addItem("M2",19090);
       vehicle.addItem("M5",90129);
       vehicle.addItem("M10",9019);
       vehicle.delItem("M10");
       vehicle.setItemName("M0","M53");
       vehicle.setPrice("M2",-100);
       Transport.printModels(vehicle);
   }
}
