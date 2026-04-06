package ru.test.demonstrator.location;

public class SingleLocation {
    Integer line;
    Integer col;

    SingleLocation(Integer line, Integer col) {
        this.line = line;
        this.col = col;
    }

    @Override
    public String toString() {
        return line + ":" + col;
    }
}
