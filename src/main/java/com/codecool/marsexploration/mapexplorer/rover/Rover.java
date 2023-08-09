package com.codecool.marsexploration.mapexplorer.rover;

import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;

import java.util.Collection;
import java.util.List;

public class Rover {
  public String id;
  public Coordinate currentCoordinate;
  public int sight;
  public Collection<Coordinate> resources;


    public Rover(String id, Coordinate currentCoordinate, int sight, Collection<Coordinate> resources) {
        this.id = id;
        this.currentCoordinate = currentCoordinate;
        this.sight = sight;
        this.resources = resources;
    }
}
