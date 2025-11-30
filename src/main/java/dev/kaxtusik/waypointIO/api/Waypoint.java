package dev.kaxtusik.waypointIO.api;

import java.awt.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface Waypoint {

    UUID getID();
    String getName();
    Location getLocation();
    Color getColor();
    WaypointStyle getStyle();

    void update(Location newLocation);
    void setColor(Color color);
    void setStyle(WaypointStyle style);

}
