package com.codecool.marsexploration.mapexplorer;

import com.codecool.marsexploration.mapexplorer.logger.FileLogger;
import com.codecool.marsexploration.mapexplorer.logger.Logger;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoaderImpl;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

public class Application {
    private static final String workDir = "src/main";

    public static void main(String[] args) {
        String mapFile = workDir + "/resources/exploration-0.map";
        String logPath = workDir + "/resources/log/log.txt";
        Coordinate landingSpot = new Coordinate(6, 6);
        MapLoader mapLoader = new MapLoaderImpl();
        mapLoader.load(mapFile);
        Logger fileLogger = new FileLogger(logPath);
        fileLogger.log("This");
        // Add your code here
    }
}

