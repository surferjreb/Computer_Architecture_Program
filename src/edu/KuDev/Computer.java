package edu.KuDev;

import edu.KuDev.architexture.Factories.AbstractFactory;
import edu.KuDev.architexture.Factories.ProcessorFactory;
import edu.KuDev.architexture.Memory;
import edu.KuDev.architexture.Messaging.Signal;
import edu.KuDev.architexture.Processor.iProcessor;
import edu.KuDev.architexture.SystemBus;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private iProcessor processor;
    private List<Memory> memory;
    private SystemBus systemBus;

    private Computer(iProcessor processor, List<Memory> memory) {
        this.processor = processor;

        this.processor = processor;
        this.memory = memory;
        this.systemBus = SystemBus.getInstance();

    }
    public SystemBus getSystemBus(){
     return systemBus;
    }

    public static Computer build(ProcessorInfo pInfo, MemoryInfo mInfo) {

        iProcessor processor = createProcessor(pInfo);
        List<Memory> memory = createRam(mInfo);
        Computer computer = new Computer(processor, memory);
        createSystemBus(processor, memory, computer.getSystemBus());

        return computer;
    }



    public static iProcessor createProcessor(ProcessorInfo pInfo) {
        AbstractFactory factory = new ProcessorFactory();

        iProcessor processor = ((ProcessorFactory) factory).getProcessor(pInfo.getFamily(),
                pInfo.getBrand(), pInfo.getClockSpeed(), pInfo.getArchitecture());
        return processor;
    }



    private static List<Memory> createRam(MemoryInfo info){
        List<Memory> newMemory = new ArrayList<Memory>();

        for(int i=0; i < info.Quantity; i++){
            Memory ram = new Memory(info.size, info.brand, info.transferRate);

            newMemory.add(ram);
        }

        return newMemory;
    }

    private static void createSystemBus(iProcessor processor, List<Memory> ram, SystemBus bus){

        bus.subscribe(Signal.SignalType.IO_READ.toString(), processor );
        bus.subscribe(Signal.SignalType.IO_WRITE.toString(), processor );
        bus.subscribe(Signal.SignalType.CONTROL.toString(), processor );

        for(Memory r: ram){
            bus.subscribe(Signal.SignalType.MEMORY_READ.toString(), r);
            bus.subscribe(Signal.SignalType.MEMORY_WRITE.toString(), r);
        }
    }

//    @Override
//    public String toString() {
//        return "Computer = " + "\n" + build();
//    }
}


