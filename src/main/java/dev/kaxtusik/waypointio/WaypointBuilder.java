package dev.kaxtusik.waypointio;

import com.github.retrooper.packetevents.resources.ResourceLocation;
import org.bukkit.Location;
import java.awt.Color;
import java.util.UUID;

public class WaypointBuilder {

    private UUID id = UUID.randomUUID();
    private String name;
    private Location location;
    private Color color = Color.WHITE;
    private ResourceLocation styleLocation = new ResourceLocation("default");

    public WaypointBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public WaypointBuilder name(String name) {
        this.name = name;
        return this;
    }

    public WaypointBuilder location(Location location) {
        this.location = location;
        return this;
    }

    public WaypointBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public WaypointBuilder style(WaypointStyle style) {
        this.styleLocation = style.getResourceLocation();
        return this;
    }

    public WaypointBuilder customStyle(String namespace, String path) {
        this.styleLocation = new ResourceLocation(namespace, path);
        return this;
    }

    public Waypoint build() {
        if (location == null) {
            throw new IllegalStateException("Location cannot be null");
        }
        return new Waypoint(id, name, location, color, styleLocation);
    }
}