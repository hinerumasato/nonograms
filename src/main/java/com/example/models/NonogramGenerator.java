package com.example.models;

public class NonogramGenerator {
    private GeneratorBehavior behavior;
    public NonogramGenerator(GeneratorBehavior behavior) {
        this.behavior = behavior;
    }

    public NonogramBoard generate() {
        return this.behavior.generate();
    }
}
