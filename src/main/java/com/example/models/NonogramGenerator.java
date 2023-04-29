package com.example.models;

public class NonogramGenerator {
    private NonogramGeneratorBehavior behavior;
    public NonogramGenerator(NonogramGeneratorBehavior behavior) {
        this.behavior = behavior;
    }

    public NonogramBoard generate() {
        return this.behavior.generate();
    }
}
