public class TurnOnDevices {

    public static void main(String[] args) {

        turnOnDevice(new Lamp());
        turnOnDevice(new Computer());
        turnOnDevice(new Adapter(new CoffeMaker()));
    }

    private static void turnOnDevice(Connectable device) {
        device.turnOn();
        System.out.println(device.isOn());
    }

}

class Lamp extends Connectable{}
class Computer extends Connectable{}

abstract class Connectable {
    private boolean on;

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

}

class Adapter extends Connectable {
    protected boolean isOff(){
        return !isOn();
    }

    private CoffeMaker coffeMaker;

    public Adapter(CoffeMaker coffeMaker){
        this.coffeMaker = coffeMaker;

    }

    public void turnOn(){
        coffeMaker.on();
    }

    public void turnOff(){
        coffeMaker.off();
    }

    public boolean isOn(){
        return !coffeMaker.isOff();
    }
}

class CoffeMaker{
    protected boolean Off = true;


    public void on(){
        if(isOff()){
            Off = false;
        }
        else{
            System.out.println("CoffeMaker is already on");
        }
    }

    public void off(){
        if(!isOff()){
            Off = true;
        }
        else{
            System.out.println("CoffeMaker is already off");
        }
    }

    public boolean isOff(){
        return Off;
    }

}

