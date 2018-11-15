package edu.KuDev.architexture.Processor.ISA;

import java.util.Arrays;

public class Instruction {

    private byte[] data;

    public Instruction(byte[] data){
        this.data = data;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public byte[] asBinary(){
        return this.data;
    }

    public Instruction decode(){
        if (this.toString().equals("00000001"))
            return new Add(this.data);

        return null;
    }
}
