package edu.KuDev.architexture;

import edu.KuDev.architexture.Messaging.Signal;
import edu.KuDev.architexture.Messaging.Subscriber;
import jdk.jshell.spi.ExecutionControl;

public class Memory implements Subscriber {

    private int size;
    private String type;
    private int transferRate;

    public Memory(int size, String type, int transferRate){

        this.size = size;
        this.type = type;
        this.transferRate = transferRate;

    }

    @Override
    public String toString() {
        return "Memory " +
                "\nsize= " + size + "GB" +
                "\ntype= " + type +
                "\ntransferRate= " + transferRate + "Mhz";
    }

    @Override
    public void receive(Signal signal) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not Implemented");
    }
}
