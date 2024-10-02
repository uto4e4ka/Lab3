import vehicles.Automobile;
import vehicles.Motorcycle;
import Exeptions.DuplicateModelNameException;
import Exeptions.NoSuchModelNameException;
import tools.TransportTests;

public class Main {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {
        Automobile automobile = new Automobile("BMW",4);
        new TransportTests(automobile).startNormal();
        new TransportTests(new Motorcycle("Suzuki",10)).startNormal();
    }
}