package edu.KuDev;
//import edu.KuDev.architexture.Memory;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String family;
        String brand;
        String clockSpeed;
        String architecture;
        int size;
        String mbrand;
        int transferRate;
        int quantity;

        System.out.println("Enter processor family: ");
        family = input.nextLine();

        System.out.println("Enter processor brand: ");
        mbrand = input.nextLine();
        System.out.println("Enter clockSpeed: ");
        clockSpeed = input.nextLine();
        System.out.println("Enter architecture: ");
        architecture = input.nextLine();

        System.out.println("Enter size of Memory: ");
        size = input.nextInt();
        input.nextLine();
        System.out.println("Enter Memory brand: ");
        brand = input.nextLine();
        System.out.println("Enter Memory transfer rate: ");
        transferRate = input.nextInt();
        System.out.println("Enter quantity: ");
        quantity = input.nextInt();


        ProcessorInfo pInfo = new ProcessorInfo(family, brand, clockSpeed, architecture);
        MemoryInfo mInfo = new MemoryInfo(size, mbrand, transferRate, quantity);
	    Computer computer = Computer.build(pInfo, mInfo);

        System.out.println(Computer.build(pInfo, mInfo));

    }
}
