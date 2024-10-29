import Exeptions.UnknownClassExeption;
import interfaces.Vehicle;
import tools.Transport;
import vehicles.Automobile;
import vehicles.Motorcycle;
import Exeptions.DuplicateModelNameException;
import Exeptions.NoSuchModelNameException;
import tools.TransportTests;

import java.io.*;

public class Main {
    static final String PATH = "C:\\Users\\Uto4ka\\IdeaProjects\\lab3\\";
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException, IOException, UnknownClassExeption, ClassNotFoundException {
        Automobile automobile = new Automobile("BMW",4);
        automobile.addItem("Test",9999);
        Motorcycle motorcycle = new Motorcycle("Suzuki",10);
       // new TransportTests(automobile).startNormal();
        //new TransportTests(new Motorcycle("Suzuki",10)).startErr();
      new TransportTests(automobile).startIO(PATH+"test1.txt");
      new TransportTests(automobile).startWR(PATH+"test.txt");
        new TransportTests(motorcycle).startSerialize(PATH+"ser.bin");
        Vehicle res = Transport.readModel(new InputStreamReader(System.in));
        Transport.writeModel(res,new OutputStreamWriter(System.out));
    }
}