package me.ziomki.hardcoreplus;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class DifficultiesList {
    private static final HashMap<String, List<Object>> difficultiesList = new HashMap<>();
    private final String name;
    private final int category;
    private final Double chance;

    public DifficultiesList() {
        this.name = "";
        this.category = 0;
        this.chance = 0.0;
    }
    public DifficultiesList(String name, int category, Double chance) {
        this.name = name;
        this.category = category;
        this.chance = chance;
        addEntry();
    }

    public static HashMap<String, List<Object>> getDifficultiesList() {
        return difficultiesList;
    }

    private void addEntry() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(category);
        parameters.add(chance);
        getDifficultiesList().put(name, parameters);
    }

}
