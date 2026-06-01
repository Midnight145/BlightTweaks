package co.nidmight.blighttweaks.recipes.framework;

public enum Priority {

    LOWEST(-1000),
    LOW(-500),
    NORMAL(0),
    HIGH(500),
    HIGHEST(1000);

    private final int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
