package com.codecool.marsexploration.mapexplorer.maploader;

import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MapLoaderImpl implements MapLoader{
    @Override
    public Map load(String mapFile) {
        String[][] representation = new String[mapFile.length()][];
        try {
            Path path = Paths.get(mapFile);
            BufferedReader reader = Files.newBufferedReader(path);

            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                representation[count] = line.split("");
                count++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.deepToString(representation));
        return null;
    }
}
