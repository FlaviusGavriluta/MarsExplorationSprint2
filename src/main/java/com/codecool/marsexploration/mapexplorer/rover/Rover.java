package com.codecool.marsexploration.mapexplorer.rover;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Rover {
  public String id;
  public Coordinate currentCoordinate;
  public int sight;
  public Map<String, Coordinate> resources;


    public String getId() {
        return id;
    }

    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    public int getSight() {
        return sight;
    }

    public Map<String, Coordinate> getResources() {
        return resources;
    }

    public Rover(String id, Coordinate currentCoordinate, int sight, Map<String, Coordinate> resources) {
        this.id = id;
        this.currentCoordinate = currentCoordinate;
        this.sight = sight;
        this.resources = resources;
    }
}
