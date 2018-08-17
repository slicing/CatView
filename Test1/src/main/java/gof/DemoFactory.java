package gof;
//工厂模式

abstract class Computer{
    public abstract String getRam();
    public abstract String getCpu();
    public abstract String getHdd();

    @Override
    public String toString() {
        return "Cpu= " + this.getCpu() + "   RAM= "  + this.getRam() + "   HDD= " + this.getHdd() ;
    }
}

class ComputerFactory{
    public static Computer getComputer(String type,String ram,String hdd,String cpu){
        if("PC".equalsIgnoreCase(type)){
            return new PC(cpu,ram,hdd);
        }else if("SERVER".equalsIgnoreCase(type)){
            return new Server(cpu,ram,hdd);
        }
        return null;
    }
}

class PC extends Computer{
    private String cpu;
    private String ram;
    private String hdd;

    public PC(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public String getRam() {
        return ram;
    }

    @Override
    public String getCpu() {
        return cpu;
    }

    @Override
    public String getHdd() {
        return hdd;
    }
}


class Server extends Computer{
    private String cpu;
    private String ram;
    private String hdd;
    private final String type = "hight computer";

    public Server(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public String getRam() {
        return ram;
    }

    @Override
    public String getCpu() {
        return cpu;
    }

    @Override
    public String getHdd() {
        return hdd;
    }
}

public class DemoFactory {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC","2GB","1T","2.4GHz");
        Computer server = ComputerFactory.getComputer("SERVER","2GB","1T","2.4GHz");
        System.out.println(pc);
        System.out.println(server);

    }


}
