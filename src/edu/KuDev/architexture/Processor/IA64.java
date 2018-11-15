package edu.KuDev.architexture.Processor;

import edu.KuDev.architexture.Processor.ISA.Instruction;
import edu.KuDev.architexture.SystemBus;

import java.util.ArrayList;
import java.util.List;

public class IA64 extends Processor {
    public IA64(String family, String brand, String clockspeed, SystemBus bus) {

        super(family, brand, clockspeed, bus);
    }

    @Override
    public List<Register> createRegister(){
        ArrayList<Register> registers = new ArrayList<>();
        registers.add(new Register("RAX"));
        registers.add(new Register("RBX"));
        registers.add(new Register("RCX"));
        registers.add(new Register("RDX"));
        registers.add(new Register("RSP"));
        registers.add(new Register("RBP"));
        registers.add(new Register("RSI"));
        registers.add(new Register("RDI"));
        registers.add(new Register("CS"));
        registers.add(new Register("DS"));
        registers.add(new Register("ES"));
        registers.add(new Register("SS"));
        registers.add(new Register("FS"));
        registers.add(new Register("GS"));
        registers.add(new Register("R8"));
        registers.add(new Register("R9"));
        registers.add(new Register("R10"));
        registers.add(new Register("R11"));
        registers.add(new Register("R12"));
        registers.add(new Register("R13"));
        registers.add(new Register("R14"));
        registers.add(new Register("R15"));
        registers.add(new Register("RIP"));

        registers.add(new Register("RFLAGS"));

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
