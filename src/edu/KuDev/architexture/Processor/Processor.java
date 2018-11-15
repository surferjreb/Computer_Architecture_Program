package edu.KuDev.architexture.Processor;

import edu.KuDev.architexture.Messaging.Signal;
import edu.KuDev.architexture.Messaging.Subscriber;
import edu.KuDev.architexture.Processor.ISA.Instruction;
import edu.KuDev.architexture.SystemBus;
import jdk.jshell.spi.ExecutionControl;
import edu.KuDev.architexture.structures.*;

import java.util.List;

public abstract class Processor implements Subscriber, iProcessor {
    private String family;
    private String brand;
    private String clockSpeed;
    private ControlUnit controlUnit;
    protected SystemBus bus;
    private ALU alu;
    protected List<Register> register;
    protected Queue<Instruction> instructions;


    public Processor(String family, String brand, String clockSpeed, SystemBus bus) {
        this.family = family;
        this.brand = brand;
        this.clockSpeed = clockSpeed;
        this.controlUnit = new ControlUnit("ControlUnit");
        this.bus = bus;
        this.alu = new ALU("ALU");
        this.register = createRegister();
        this.instructions = new Queue<>(1000);
        this.bus.subscribe(Signal.SignalType.INSTRUCTION.toString(), this);
    }

    public abstract List<Register> createRegister();

    @Override
    public void receive(Signal signal) throws ExecutionControl.NotImplementedException {

        byte[] data = signal.getData().getBytes();

        Instruction instruction = new Instruction(data);

        try {
            this.instructions.enqueue(instruction);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public abstract void fetch();
    public abstract void decode();
    public abstract void execute(Instruction instruction);


}
