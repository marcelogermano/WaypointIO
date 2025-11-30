package dev.kaxtusik.waypointIO.api;

import com.github.retrooper.packetevents.resources.ResourceLocation;
import dev.kaxtusik.waypointIO.impl.SimpleWaypoint;
import org.bukkit.Location;
import org.jetbrains.annotations.ApiStatus;

import java.awt.*;
import java.util.UUID;

public class WaypointBuilder {

    private UUID id = UUID.randomUUID();
    private String name;
    private Location location;
    private Color color = Color.WHITE;
    private WaypointStyle style;
    private ResourceLocation customStyle;

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
        this.style = style;
        return this;
    }

    @ApiStatus.Experimental
    public WaypointBuilder customStyle(String namespace, String path) {
        this.customStyle = new ResourceLocation(namespace, path);
        return this;
    }

    @ApiStatus.Experimental
    public WaypointBuilder customStyle(String path) {
        this.customStyle = new ResourceLocation(path);
        return this;
    }

    public Waypoint build() {
        if (location == null) {
            throw new IllegalStateException("Location is required");
        }
        return new SimpleWaypoint(id, name, location, color, style, customStyle);
    }
}