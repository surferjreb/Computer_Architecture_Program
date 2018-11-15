package edu.KuDev.architexture.Factories;

//import edu.KuDev.architexture.Factories.AbstractFactory;
import edu.KuDev.architexture.Processor.IA32;
import edu.KuDev.architexture.Processor.IA64;
import edu.KuDev.architexture.Processor.IA8086;
import edu.KuDev.architexture.Processor.iProcessor;
import edu.KuDev.architexture.SystemBus;

public class ProcessorFactory extends AbstractFactory {

    @Override
    public iProcessor getProcessor(String family, String brand, String clockSpeed, String architecture) {
        SystemBus bus = SystemBus.getInstance();
        if(architecture == null){
            return null;
        }

        if(architecture.equalsIgnoreCase("IA8086")){
            return new IA8086(family, brand, clockSpeed, bus);
        }
        else if(architecture.equalsIgnoreCase("IA32")){
            return new IA32(family, brand, clockSpeed, bus);
        }
        else if(architecture.equalsIgnoreCase("IA64")){
            return new IA64(family, brand, clockSpeed, bus);
        }

        return null;
    }
}
