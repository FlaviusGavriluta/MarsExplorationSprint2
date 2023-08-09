package com.codecool.marsexploration.mapexplorer;

import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoaderImpl;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

public class Application {
    private static final String workDir = "src/main";

    public static void main(String[] args) {
        String mapFile = workDir + "/resources/exploration-0.map";
        Coordinate landingSpot = new Coordinate(6, 6);
        MapLoader mapLoader = new MapLoaderImpl();
        mapLoader.load(mapFile);
        // Add your code here
    }
}

