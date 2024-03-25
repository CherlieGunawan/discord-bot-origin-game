package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class StackStackTriggerKey implements Serializable {
    private String stackId;
    private int triggerOrder;
    private String triggerStackId;

    public StackStackTriggerKey() {}

    public StackStackTriggerKey(String stackId, int triggerOrder, String triggerStackId) {
        this.stackId = stackId;
        this.triggerOrder = triggerOrder;
        this.triggerStackId = triggerStackId;
    }
}
