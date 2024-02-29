package coderadish.world;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stephan
 */
public class World {
    
    private List<Location> locations;
    
    private Location currentLocation;

    public World(Location startingLocation) {
        this.currentLocation = startingLocation;
        this.locations = new ArrayList<>();
        this.locations.add(startingLocation);
    }
    
    public String getCurrentSituation() {
        String situation = "Aktueller Ort: " + this.currentLocation.getName() + "\n";
        if (!this.currentLocation.isVisited()) {
            situation += this.currentLocation.getDescription() + "\n";
            this.currentLocation.setVisited();
        }
        
        return situation;
    }
    
}
