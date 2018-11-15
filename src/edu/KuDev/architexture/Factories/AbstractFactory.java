package edu.KuDev.architexture.Factories;

import edu.KuDev.architexture.Processor.iProcessor;

public abstract class AbstractFactory {
    abstract iProcessor getProcessor(String family, String brand, String clockSpeed, String architecture);
}
