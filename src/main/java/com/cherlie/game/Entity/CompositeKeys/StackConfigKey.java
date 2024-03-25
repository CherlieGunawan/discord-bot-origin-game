package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class StackConfigKey implements Serializable {
    private String stackId;
    private int triggerOrder;

    public StackConfigKey() {}

    public StackConfigKey(String stackId, int triggerOrder) {
        this.stackId = stackId;
        this.triggerOrder = triggerOrder;
    }
}
