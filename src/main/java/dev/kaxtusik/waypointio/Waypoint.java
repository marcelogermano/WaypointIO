package dev.kaxtusik.waypointio;

import com.github.retrooper.packetevents.resources.ResourceLocation;
import org.bukkit.Location;
import java.awt.Color;
import java.util.UUID;

public final class Waypoint {

    private final UUID id;
    private final String name;
    private final Location location;
    private final Color color;
    private final ResourceLocation styleLocation;

    Waypoint(UUID id, String name, Location location, Color color, ResourceLocation styleLocation) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.color = color;
        this.styleLocation = styleLocation;
    }

    public UUID id() { return id; }
    public String name() { return name; }
    public Location location() { return location; }
    public Color color() { return color; }
    public ResourceLocation styleLocation() { return styleLocation; }
}