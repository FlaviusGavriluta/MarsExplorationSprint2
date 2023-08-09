package com.codecool.marsexploration.mapexplorer.maploader;

import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MapLoaderImplTest {
    private static final String workDir = "src/main";

    @Test
    void testLoad() {
        MapLoader mapLoader = new MapLoaderImpl();
        Map loadedMap = mapLoader.load(workDir + "/resources/exploration-0.map");
        assertNotNull(loadedMap);
    }
}
