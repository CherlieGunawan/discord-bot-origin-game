package com.cherlie.game.Entity.CompositeKeys;

import java.io.Serializable;

public class StackChangeConfigKey implements Serializable {
    private String stackId;
    private String event;

    public StackChangeConfigKey() {}

    public StackChangeConfigKey(String stackId, String event) {
        this.stackId = stackId;
        this.event = event;
    }
}
