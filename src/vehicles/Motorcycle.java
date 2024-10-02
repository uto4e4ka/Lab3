package vehicles;

import Exeptions.DuplicateModelNameException;
import Exeptions.ModelPriceOutOfBoundsException;
import Exeptions.NoSuchModelNameException;
import interfaces.Vehicle;

import java.util.Date;

public class Motorcycle implements Vehicle {

    private String brand;
    private class Model{
        Model(String model_name,double price){
            this.model_name = model_name;
            if(price<0) throw new ModelPriceOutOfBoundsException();
            this.price = price;
        }
        private String model_name = null;
        private double price = Double.NaN;
        private Model next = null;
        private Model prev = null;
        void setModel_name(String name){
            model_name = name;
        }
        String getModel_name(){
            return model_name;
        }
        void setPrice(double price){
            if(price<0)throw new ModelPriceOutOfBoundsException();
            this.price = price;
        }
    }
    private int size =0;
    private Model head;//!!!!
    private long lastModified;///!!!
    public Motorcycle(String brand){//!!!!
        this.brand =brand;
        head = new Model(null,Double.NaN);
        head.next = head;
        head.prev = head;
        lastModified = new Date().getTime();
    }
    public Motorcycle(String brand,int size) {
        this.size = size;//!!!!
        this.brand = brand;
        head = new Model(null,Double.NaN);
        head.next = head;
        head.prev = head;
        lastModified = new Date().getTime();
        fillModels(size);

    }
    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }
    private Model[] getAll(){
        Model m=head;
        Model[] ms = new Model[length()];
        int i=0;
        while (m.next!=head){
            ms[i]=m.next;
            i++;
            m = m.next;
        }
        return ms;
    }
    void fillModels(int size){
            for (int i = 0; i < size; i++) {
                Model m;
                if(head!=null){
                    m = new Model("Unknown_" + brand + "_" + i,0);
                    m.next = head.next;
                    m.prev = head;
                    head.next.prev=m;
                    head.next = m;
                }
            }
    }
    @Override
    public String[] getNames() {
        String[] names = new String[length()];
        int i =0;
        for(Model m:getAll()){
            names[i]=m.model_name;
            i++;
        }
        return names;
    }

    @Override
    public double[] getPrices() {
        double[] prices = new double[length()];
        int i=0;
        for (Model m:getAll()){
            prices[i]=m.price;
            i++;
        }
        return prices;
    }

    @Override
    public double getPrice(String name) throws NoSuchModelNameException {
        for (Model m:getAll()){
            if(m.model_name.equals(name)) return m.price;
        }
        throw new NoSuchModelNameException(name);
    }

    @Override
    public void setPrice(String name, double price) throws NoSuchModelNameException {
        boolean flag = false;
        for (Model m:getAll()){
            if(m.model_name.equals(name)) {
                m.setPrice(price);
                flag = true;//!!!
            }
        }
        lastModified = new Date().getTime();
        if(!flag) throw new NoSuchModelNameException(name);
    }
    private Model getItem(String name) throws NoSuchModelNameException{
        Model m=head;
        while (m.next!=head){
            if(m.next.model_name.equals(name))return m.next;
            m = m.next;
        }
        throw new NoSuchModelNameException(name);
    }
    @Override
    public void addItem(String name, double price) throws DuplicateModelNameException {
        Model m;
        isUniq(name);
        if(head!=null){
            m = new Model(name,price);
            m.next = head.next;
            m.prev = head;
            head.next.prev=m;
            head.next = m;
            size++;
        }
    }
void isUniq(String name) throws DuplicateModelNameException{
        for (Model model:getAll()) if(model!=null&&model.model_name.equals(name)) throw new DuplicateModelNameException(name);
}
    @Override
    public int length() {//!!!size
        return size;
    }

    @Override
    public void delItem(String name) throws NoSuchModelNameException {
        Model item = getItem(name);
     if(head!=null&&head!=item){
         item.prev.next = item.next;
         item.next.prev=item.prev;
         size--;
         lastModified = new Date().getTime();
     }
    }

    @Override
    public void setItemName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        isUniq(newName);
        getItem(name).model_name = newName;
    }


}