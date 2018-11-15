package edu.KuDev.architexture;

import edu.KuDev.architexture.Messaging.Signal;
import edu.KuDev.architexture.Messaging.Subscriber;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemBus{
    private Map<String, List<Subscriber>> listeners = new HashMap<>();

    private static SystemBus instance = new SystemBus();


    private SystemBus(){}

    public static SystemBus getInstance(){
        return instance;
    }

    public void subscribe(String signalType, Subscriber componentSubscribing){
        if(listeners.containsKey(signalType)){
            listeners.get(signalType).add(componentSubscribing);

        }
        else{
            List<Subscriber> subscribers = new ArrayList<>();
            subscribers.add(componentSubscribing);
            listeners.put(signalType, subscribers);
        }
    }

    public void unSubscribe(String signalType, Subscriber componentSubscribing){
        if(listeners.containsKey(signalType)){
            listeners.get(signalType).remove(componentSubscribing);
        }

    }

    public void publish(Signal signal) throws ExecutionControl.NotImplementedException {
        String signalType = signal.getType();
        if(listeners.containsKey(signal.getType())){
            for(Subscriber subscriber : listeners.get(signalType)){
                subscriber.receive(signal);
            }
        }
    }
}
