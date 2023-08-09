package com.codecool.marsexploration.mapexplorer.configuration;

import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoaderImpl;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConfigurationValidatorImpl implements ConfigurationValidator {
    private MapLoader mapLoader = new MapLoaderImpl();

    @Override
    public boolean validateConfiguration(Configuration configuration) {
        Map map = mapLoader.load(configuration.path());
        if (map == null) {
            return false;
        }
        if(configuration.symbols().isEmpty()) {
            return false;
        }
        if(configuration.steps() <= 0) {
            return false;
        }
        int dimension = map.getDimension();
        if (!map.isEmpty(configuration.coordinate())) {
            return false;
        }

        List<Coordinate> adjacentCoords = getAdjacentCoordinates(configuration.coordinate(), dimension);
        return adjacentCoords.stream()
                .filter(coordinate -> map.isEmpty(coordinate)).count() == 0;

    }

    public List<Coordinate> getAdjacentCoordinates(Coordinate coordinate, int dimension) {
        List<Coordinate> adjacentCoordinates = new ArrayList<>();

        int x = coordinate.X();
        int y = coordinate.Y();

        // Top
        if (x - 1 >= 0) {
            adjacentCoordinates.add(new Coordinate(x - 1, y));
        }
        // Bottom
        if (x + 1 < dimension) {
            adjacentCoordinates.add(new Coordinate(x + 1, y));
        }
        // Left
        if (y - 1 >= 0) {
            adjacentCoordinates.add(new Coordinate(x, y - 1));
        }
        // Right
        if (y + 1 < dimension) {
            adjacentCoordinates.add(new Coordinate(x, y + 1));
        }
        // Top Left
        if (x - 1 >= 0 && y - 1 >= 0) {
            adjacentCoordinates.add(new Coordinate(x - 1, y - 1));
        }
        // Top Right
        if (x - 1 >= 0 && y + 1 < dimension) {
            adjacentCoordinates.add(new Coordinate(x - 1, y + 1));
        }
        // Bottom Left
        if (x + 1 < dimension && y - 1 >= 0) {
            adjacentCoordinates.add(new Coordinate(x + 1, y - 1));
        }
        // Bottom Right
        if (x + 1 < dimension && y + 1 < dimension) {
            adjacentCoordinates.add(new Coordinate(x + 1, y + 1));
        }

        return adjacentCoordinates;
    }

}
