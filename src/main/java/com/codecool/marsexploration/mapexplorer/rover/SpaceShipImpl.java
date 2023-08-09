package com.codecool.marsexploration.mapexplorer.rover;

import com.codecool.marsexploration.mapexplorer.configuration.Configuration;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoaderImpl;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import static com.codecool.marsexploration.mapexplorer.configuration.ConfigurationValidatorImpl.getAdjacentCoordinates;

public class SpaceShipImpl implements SpaceShip {

    private final MapLoader mapLoader = new MapLoaderImpl();

    @Override
    public Rover placeRover(Configuration configuration) {
        Collection<Coordinate> resources = new ArrayList<>();
        List<Coordinate> adjacentCoordinates = getAdjacentCoordinates(configuration.coordinate());

        Map map = mapLoader.load(configuration.path());

        List<Coordinate> emptyAdjacent = adjacentCoordinates.stream()
                .filter(coordinate -> map.isEmpty(coordinate))
                .collect(Collectors.toList());
        if (emptyAdjacent.isEmpty()) {
            return null;
        } else return new Rover("rover-1", emptyAdjacent.get(0), 2, resources);
    }
}
