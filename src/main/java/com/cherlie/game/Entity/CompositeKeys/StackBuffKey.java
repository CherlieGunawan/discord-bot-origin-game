package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class StackBuffKey implements Serializable {
    private String stackId;
    private int triggerOrder;
    private String buffId;

    public StackBuffKey() {}

    public StackBuffKey(String stackId, int triggerOrder, String buffId) {
        this.stackId = stackId;
        this.triggerOrder = triggerOrder;
        this.buffId = buffId;
    }
}
