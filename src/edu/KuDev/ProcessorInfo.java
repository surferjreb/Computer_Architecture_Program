package edu.KuDev;

public class ProcessorInfo {
    private String family;
    private String brand;
    private String clockSpeed;
    private String architecture;

    public ProcessorInfo(String family, String brand, String clockSpeed, String architecture) {
        this.family = family;
        this.brand = brand;
        this.clockSpeed = clockSpeed;
        this.architecture = architecture;
    }

    public String getFamily() {
        return family;
    }

    public String getBrand() {
        return brand;
    }

    public String getClockSpeed() {
        return clockSpeed;
    }

    public String getArchitecture() {
        return architecture;
    }
}
