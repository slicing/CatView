class Benz implements IVehicle{
    @Override
    public void run(){
        System.out.println("BBB   run ...");
    }
}



interface IVehicle{
    public void run();
}

class Rr implements IVehicle{
    @Override
    public void run() {
        System.out.println(" Rr   run ....");
    }

}

interface IDriver{
    public void drive(IVehicle vehicle);
        }
class Driver implements IDriver{

    @Override
    public void drive(IVehicle vehicle) {
        vehicle.run();
    }
}




public class DIP {
    public static void main(String[] args) {
        IDriver driver = new Driver();
        Benz benz = new Benz();
        Rr rr = new Rr();
        driver.drive(benz);
        driver.drive(rr);
    }
}
