package edu.KuDev.architexture.Messaging;

import jdk.jshell.spi.ExecutionControl;

public interface Subscriber {
    void receive(Signal signal) throws ExecutionControl.NotImplementedException;
}
