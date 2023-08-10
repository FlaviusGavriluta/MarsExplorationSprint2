package com.codecool.marsexploration.mapexplorer.simulation;

import com.codecool.marsexploration.mapexplorer.exploration.ExplorationOutcome;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;

import java.util.List;

public class Simulation {
    public int steps;
    public int stepsTimeout;
    public Rover rover;
    public Coordinate spaceshipLocation;
    public Map map;
    public List<String> symbols;
    public ExplorationOutcome outcome;

}
