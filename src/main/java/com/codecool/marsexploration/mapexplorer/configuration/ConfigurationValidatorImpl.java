package com.codecool.marsexploration.mapexplorer.configuration;

import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoaderImpl;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationValidatorImpl implements ConfigurationValidator {
    private final MapLoader mapLoader = new MapLoaderImpl();
//    public ConfigurationValidatorImpl(MapLoader mapLoader) {
//        this.mapLoader = mapLoader;
//    }

    @Override
    public boolean validateConfiguration(Configuration configuration) {
        Map map = mapLoader.load(configuration.path());
        if (map == null || configuration.symbols().isEmpty() || configuration.steps() <= 0) {
            return false;
        }

        if (!map.isEmpty(configuration.coordinate())) {
            return false;
        }
        List<Coordinate> adjacentCoords = getAdjacentCoordinates(configuration.coordinate());
        return adjacentCoords.stream().noneMatch(coordinate -> !map.isEmpty(coordinate));
    }

    public static List<Coordinate> getAdjacentCoordinates(Coordinate coordinate) {

        List<Coordinate> adjacentCoordinates = new ArrayList<>();
        int x = coordinate.X();
        int y = coordinate.Y();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;  // Skip the center coordinate
                int newX = x + dx;
                int newY = y + dy;
                if (newX >= 0 && newX < 2 && newY >= 0 && newY < 2) {
                    adjacentCoordinates.add(new Coordinate(newX, newY));
                }
            }
        }
        return adjacentCoordinates;
    }
}
