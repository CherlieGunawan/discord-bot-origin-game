package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class StackDebuffKey implements Serializable {
    private String stackId;
    private int triggerOrder;
    private String debuffId;

    public StackDebuffKey() {}

    public StackDebuffKey(String stackId, int triggerOrder, String debuffId) {
        this.stackId = stackId;
        this.triggerOrder = triggerOrder;
        this.debuffId = debuffId;
    }
}
