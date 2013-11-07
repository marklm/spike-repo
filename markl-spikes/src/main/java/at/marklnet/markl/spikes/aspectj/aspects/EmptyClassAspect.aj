package at.marklnet.markl.spikes.aspectj.aspects;

import at.marklnet.markl.spikes.aspectj.pojos.EmptyClass;

public aspect EmptyClassAspect {

    public String EmptyClass.toString() {
        return "Implementierung im Aspekt - toString() von EmptyClass";
    }

}
