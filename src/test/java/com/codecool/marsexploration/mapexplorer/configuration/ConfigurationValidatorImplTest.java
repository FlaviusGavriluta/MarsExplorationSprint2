package com.codecool.marsexploration.mapexplorer.configuration;

import com.codecool.marsexploration.mapexplorer.configuration.Configuration;
import com.codecool.marsexploration.mapexplorer.configuration.ConfigurationValidatorImpl;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoaderImpl;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConfigurationValidatorImplTest {

    private ConfigurationValidatorImpl configurationValidator;
   // private MapLoader mapLoader = new MapLoaderImpl();
    private String WORK_DIR = "src/main/resources/exploration-0.map";

    @BeforeEach
    public void setUp() {
        //mock(MapLoader.class);
        configurationValidator = new ConfigurationValidatorImpl();
    }

    @Test
    public void testValidConfiguration() {
        List<String> symbols = new ArrayList<>();
        symbols.add("#");
        symbols.add("%");
        Configuration configuration = new Configuration(WORK_DIR, new Coordinate(2, 2), symbols, 5);
        assertTrue(configurationValidator.validateConfiguration(configuration));
    }

    @Test
    public void testInvalidMapPath() {
        List<String> symbols = new ArrayList<>();
        symbols.add("#");
        symbols.add("%");
        Configuration configuration = new Configuration(WORK_DIR + "/testinvalid", new Coordinate(2, 2), symbols, 5);
        assertFalse(configurationValidator.validateConfiguration(configuration));
    }

    @Test
    public void testEmptySymbols() {
        List<String> symbols = new ArrayList<>();
        Configuration configuration = new Configuration(WORK_DIR, new Coordinate(2, 2), symbols, 5);
        assertFalse(configurationValidator.validateConfiguration(configuration));
    }

    @Test
    public void testNegativeSteps() {
        List<String> symbols = new ArrayList<>();
        symbols.add("#");
        symbols.add("%");
        Configuration configuration = new Configuration(WORK_DIR, new Coordinate(2, 2), symbols, -1);
        assertFalse(configurationValidator.validateConfiguration(configuration));
    }

    @Test
    public void testNonEmptyStartingCoordinate() {
        List<String> symbols = new ArrayList<>();
        symbols.add("#");
        symbols.add("%");
        Configuration configuration = new Configuration(WORK_DIR, new Coordinate(2, 16), symbols, -1);
        assertFalse(configurationValidator.validateConfiguration(configuration));
    }


}
