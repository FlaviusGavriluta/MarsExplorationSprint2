import com.codecool.marsexploration.mapexplorer.configuration.Configuration;
import com.codecool.marsexploration.mapexplorer.maploader.MapLoader;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;
import com.codecool.marsexploration.mapexplorer.rover.Rover;
import com.codecool.marsexploration.mapexplorer.rover.SpaceShipImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SpaceShipImplTest {
    private String WORK_DIR = "src/main/resources/exploration-0.map";
    private SpaceShipImpl spaceShip;
    private MapLoader mapLoader;
    private Map mockMap;

    @BeforeEach
    public void setUp() {

        spaceShip = new SpaceShipImpl();

//        mockMap = mock(Map.class);
//        when(mockMap.getDimension()).thenReturn(5);
//        when(mockMap.isEmpty(any(Coordinate.class))).thenReturn(true);
    }

    @Test
    public void testPlaceRoverWithEmptyAdjacentCoordinates() {
        List<String> symbols = new ArrayList<>();
        symbols.add("#");
        symbols.add("%");
        Configuration configuration = new Configuration(WORK_DIR, new Coordinate(2, 2), symbols, 5);
        List<Coordinate> emptyAdjacent = Arrays.asList(new Coordinate(1, 1), new Coordinate(3, 2));


        Rover rover = spaceShip.placeRover(configuration);

        assertNotNull(rover);
        assertEquals("rover-1", rover.getId());
        assertTrue(emptyAdjacent.contains(rover.getCurrentCoordinate()));
        assertEquals(2, rover.getSight());
        assertTrue(rover.getResources().isEmpty());
    }

    @Test
    public void testPlaceRoverWithNoEmptyAdjacentCoordinates() {
        List<String> symbols = new ArrayList<>();
        symbols.add("#");
        symbols.add("%");
        Configuration configuration = new Configuration(WORK_DIR, new Coordinate(4, 15), symbols, 5);
        assertEquals(null, spaceShip.placeRover(configuration));
    }
}
