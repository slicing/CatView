package gof;


class Volt{
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}

class Socket{
    Volt getVolt(){
        return new Volt(120);
    }
}

interface SocketAdapter{
    Volt get3Volt();
    Volt get12Volt();
    Volt get120Volt();
    //Volt get220Volt();
}

class SocketAdpterImpl extends Socket implements SocketAdapter{

    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(),40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(),10);
    }

    @Override
    public Volt get120Volt() {
        return get120Volt();
    }


    private Volt convertVolt(Volt v,int i){
        return new Volt(v.getVolts()/i);
    }
}

class SocketAdapterImpl implements SocketAdapter{
    Socket socket = new Socket();

    @Override
    public Volt get3Volt() {
        return convertVolt(socket.getVolt(),40);
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(socket.getVolt(),10);
    }

    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }


    private Volt convertVolt(Volt v,int i){
        return new Volt(v.getVolts()/i);
    }
}
public class DemoAdapter {
    public static void main(String[] args) {
        SocketAdapter adapter = new SocketAdapterImpl();
        Volt v3 = adapter.get3Volt();
        Volt v12 = adapter.get12Volt();
        Volt v120 = adapter.get120Volt();
        System.out.println(v3.getVolts());
        System.out.println(v12.getVolts());
        System.out.println(v120.getVolts());


        SocketAdapter adapter1 = new SocketAdpterImpl();
        Volt vv3 = adapter1.get3Volt();
        System.out.println(vv3.getVolts());
    }
}
