package edu.KuDev.architexture.Processor;

import edu.KuDev.architexture.Processor.ISA.Instruction;

import java.util.Arrays;

public class Register {
    private byte[] data;
    private String name;

    public Register(String name){
        this.name = name;

    }

    public Instruction read(){

        return new Instruction(this.data);
    }

    public String write(byte[] data){
        this.data = data;
        return Arrays.toString(data);
   }

    @Override
    public String toString() {
        return this.name;
    }


}
