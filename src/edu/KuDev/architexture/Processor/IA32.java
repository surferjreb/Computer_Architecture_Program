package edu.KuDev.architexture.Processor;

import edu.KuDev.architexture.Messaging.Signal;
import edu.KuDev.architexture.Processor.ISA.Instruction;
import edu.KuDev.architexture.SystemBus;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;

public class IA32 extends Processor {

    public IA32(String family, String brand, String clockspeed, SystemBus bus) {
        super(family, brand, clockspeed, bus);

    }



    @Override
    public ArrayList createRegister() {
        ArrayList<Register> registers = new ArrayList<>();
        registers.add(new Register("EAX"));
        registers.add(new Register("EBX"));
        registers.add(new Register("ECX"));
        registers.add(new Register("EDX"));
        registers.add(new Register("ESP"));
        registers.add(new Register("EBP"));
        registers.add(new Register("ESI"));
        registers.add(new Register("EDI"));
        registers.add(new Register("CS"));
        registers.add(new Register("DS"));
        registers.add(new Register("ES"));
        registers.add(new Register("SS"));
        registers.add(new Register("FS"));
        registers.add(new Register("GS"));
        registers.add(new Register("EIP"));

        registers.add(new Register("EFLAGS"));



        return registers;
    }
    @Override
    public void fetch() {
        Register instructionPointer = find("EIP");
        Instruction nextInstruction = instructionPointer.read();

        Signal memoryReadSignal = new Signal(nextInstruction.toString(), "", Signal.SignalType.MEMORY_READ);

        try {
            this.bus.publish(memoryReadSignal);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decode() {
        while(true){
            if(this.instructions.isEmpty())
                continue;

            try{
                Instruction currentInstruction = this.instructions.dequeue();
                Instruction actual = currentInstruction.decode();
                execute(actual);
            }
            catch(Exception e){
                continue;
            }
        }
    }

    @Override
    public void execute(Instruction instruction) {

    }

    private Register find(String name){

        Register register = null;
        for(Register r: this.register){
            if(r.toString().equals("EIP")) {
                register = r;
            }
        }

        return register;
    }


}
