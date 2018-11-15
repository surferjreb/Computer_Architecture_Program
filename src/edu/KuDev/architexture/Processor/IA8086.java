package edu.KuDev.architexture.Processor;

import edu.KuDev.architexture.Processor.ISA.Instruction;
import edu.KuDev.architexture.SystemBus;

import java.util.ArrayList;

public class IA8086 extends Processor {
    public IA8086(String family, String brand, String clockspeed, SystemBus bus) {

        super(family, brand, clockspeed, bus);
    }

    @Override
    public ArrayList createRegister() {
        ArrayList<Register> registers = new ArrayList<>();
        registers.add(new Register("AX"));
        registers.add(new Register("BX"));
        registers.add(new Register("CX"));
        registers.add(new Register("DX"));
        registers.add(new Register("SP"));
        registers.add(new Register("BP"));
        registers.add(new Register("SI"));
        registers.add(new Register("DI"));
        registers.add(new Register("CS"));
        registers.add(new Register("DS"));
        registers.add(new Register("ES"));
        registers.add(new Register("SS"));
        registers.add(new Register("IP"));
        registers.add(new Register("FLAGS"));

        return registers;
    }

    @Override
    public void fetch() {

    }

    @Override
    public void decode() {

    }

    @Override
    public void execute(Instruction instruction) {

    }
}
