package com.codecool.marsexploration.mapexplorer.simulation;

import com.codecool.marsexploration.mapexplorer.configuration.Configuration;
import com.codecool.marsexploration.mapexplorer.configuration.ConfigurationValidator;
import com.codecool.marsexploration.mapexplorer.exploration.ExplorationOutcome;
import com.codecool.marsexploration.mapexplorer.logger.Logger;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.rover.Rover;
import com.codecool.marsexploration.mapexplorer.rover.SpaceShip;
import com.codecool.marsexploration.mapexplorer.rover.SpaceShipImpl;

import java.util.ArrayList;
import java.util.List;

import static com.codecool.marsexploration.mapexplorer.configuration.ConfigurationValidatorImpl.getAdjacentCoordinates;

public class SimulationExplorer {
    public Configuration configuration;
    public ConfigurationValidator configurationValidator;
    public Logger fileLogger;
    public SimulationContext simulationContext;

    public SimulationExplorer(Configuration configuration, ConfigurationValidator configurationValidator, Logger fileLogger, SimulationContext simulationContext) {
        this.configuration = configuration;
        this.configurationValidator = configurationValidator;
        this.fileLogger = fileLogger;
        this.simulationContext = simulationContext;
    }

    public void runSimulation() {
        if (configurationValidator.validateConfiguration(configuration)) {
            List<Coordinate> visitedCoordinates = new ArrayList<>();
            while (simulationContext.steps < simulationContext.stepsTimeout && simulationContext.getOutcome() != ExplorationOutcome.COLONIZABLE) {
                List<Coordinate> adjacentCoordinates = getAdjacentCoordinates(simulationContext.rover.getCurrentCoordinate());
                // get adjacent coordinates, and explore it
                // move rover on one of the adjacent positions, but not on one of the previous positions
                // print step
                // check if found resources
                // if true, add to rover
                // check outcome
            }

        } else {
            fileLogger.log("Invalid configuration");
        }
    }
}
