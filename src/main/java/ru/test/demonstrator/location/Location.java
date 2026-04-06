package ru.test.demonstrator.location;

import ru.test.demonstrator.location.SingleLocation;

public class Location {
    SingleLocation start;
    SingleLocation end;

    Location(Integer stl, Integer stc, Integer endl, Integer endc) {
        this.start = new SingleLocation(stl, stc);
        this.end = new SingleLocation(endl, endc);
    }

    @Override
    public String toString() {
        return start + " ; " + end;
    }
}
