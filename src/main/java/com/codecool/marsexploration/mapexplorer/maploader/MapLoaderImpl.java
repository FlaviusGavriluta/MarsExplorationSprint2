package com.codecool.marsexploration.mapexplorer.maploader;

import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MapLoaderImpl implements MapLoader{
    @Override
    public Map load(String mapFile) {
        List<String[]> representationList = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(mapFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                representationList.add(line.split(""));
            }
        } catch (IOException e) {
            return null;
        }

        String[][] representation = new String[representationList.size()][];
        for (int i = 0; i < representationList.size(); i++) {
            representation[i] = representationList.get(i);
        }

        return new Map(representation, true);
    }
}
