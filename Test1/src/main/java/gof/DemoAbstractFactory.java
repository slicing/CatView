package gof;

abstract class Cloud{
    public abstract String getRam();
    public abstract String getCpu();
    public abstract String getHdd();

    @Override
    public String toString() {
        return "Cpu= " + this.getCpu() + "   RAM= "  + this.getRam() + "   HDD= " + this.getHdd() ;
    }
}

class Ali extends Cloud{
    private String cpu;
    private String ram;
    private String hdd;

    public Ali(String cpu, String ram, String hdd) {
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


class Aws extends Cloud{
    private String cpu;
    private String ram;
    private String hdd;
    private final String type = "hight computer";

    public Aws(String cpu, String ram, String hdd) {
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

interface CloudAbstractFactory{
    Cloud createCloud();
}

class CloudFactory{
    static Cloud getCloud(CloudAbstractFactory cloudAbstractFactory){
        return cloudAbstractFactory.createCloud();
    }
}

class AwsFactory implements CloudAbstractFactory{
    private String cpu;
    private String ram;
    private String hdd;

    public AwsFactory(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public Cloud createCloud() {
        return new Aws(cpu,ram,hdd);
    }
}

class AliFactory implements CloudAbstractFactory{
    private String cpu;
    private String ram;
    private String hdd;

    public AliFactory(String cpu, String ram, String hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public Cloud createCloud() {
        return new Ali(cpu,ram,hdd);
    }
}
public class DemoAbstractFactory {
    public static void main(String[] args) {
        Cloud aws = CloudFactory.getCloud(new AwsFactory("2GHz","16GB","1T"));
        Cloud ali = CloudFactory.getCloud(new AliFactory("2GHz","16GB","1T"));
        Cloud aws1 = CloudFactory.getCloud(new AwsFactory("2GHz","16GB","1T"));
        Cloud aws2 = CloudFactory.getCloud(new AwsFactory("2GHz","16GB","1T"));
        System.out.println(aws);
        System.out.println(aws1);
        System.out.println(aws2);
        System.out.println(ali);
    }
}
