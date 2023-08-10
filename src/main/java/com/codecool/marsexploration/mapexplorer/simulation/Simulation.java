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

    public Simulation(int steps, int stepsTimeout, Rover rover, Coordinate spaceshipLocation, Map map, List<String> symbols, ExplorationOutcome outcome) {
        this.steps = steps;
        this.stepsTimeout = stepsTimeout;
        this.rover = rover;
        this.spaceshipLocation = spaceshipLocation;
        this.map = map;
        this.symbols = symbols;
        this.outcome = outcome;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getStepsTimeout() {
        return stepsTimeout;
    }

    public void setStepsTimeout(int stepsTimeout) {
        this.stepsTimeout = stepsTimeout;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Coordinate getSpaceshipLocation() {
        return spaceshipLocation;
    }

    public void setSpaceshipLocation(Coordinate spaceshipLocation) {
        this.spaceshipLocation = spaceshipLocation;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }

    public ExplorationOutcome getOutcome() {
        return outcome;
    }

    public void setOutcome(ExplorationOutcome outcome) {
        this.outcome = outcome;
    }
}
