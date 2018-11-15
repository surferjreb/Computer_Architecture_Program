package edu.KuDev.architexture.Messaging;

import java.util.Objects;

public class Signal {
    private String address;
    private String data;
    private SignalType type;

    public enum SignalType{

        MEMORY_READ("Read"),
        MEMORY_WRITE("Write"),
        IO_READ("IO READ"),
        IO_WRITE("IO WRITE"),
        CONTROL("Control"),
        INSTRUCTION("Instruction");

        private String signal;

        SignalType(String signal){
            this.signal = signal;
        }

        @Override
        public String toString(){
            return signal;
        }

    }

    public Signal(String address, String data, SignalType type) {
        this.address = address;
        this.data = data;
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public String getData() {
        return data;
    }

    public String getType() {
        return this.type.toString();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAddress(), getData(), getType());
    }

    @Override
    public boolean equals(Object o) {

        if(this == o) return true;
        if(!(o instanceof Signal)) return false;
        Signal signal = (Signal) o;

        return Objects.equals(getAddress(), signal.getAddress()) && Objects.equals(getData(), signal.getData())
                && Objects.equals(getType(), signal.getType());
    }
}
