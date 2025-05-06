package net.qualitycard.qualitymayhem.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum ScutterBugVariant {
    DEFAULT(0),
    MOSSY(1),
    DEEP(2);

    private static final ScutterBugVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ScutterBugVariant::getId)).toArray(ScutterBugVariant[]::new);
    private final int id;

    ScutterBugVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ScutterBugVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
