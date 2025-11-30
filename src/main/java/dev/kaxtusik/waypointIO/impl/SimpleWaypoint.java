package dev.kaxtusik.waypointIO.impl;

import com.github.retrooper.packetevents.resources.ResourceLocation;
import dev.kaxtusik.waypointIO.api.Waypoint;
import dev.kaxtusik.waypointIO.api.WaypointStyle;
import org.bukkit.Location;
import java.awt.Color;
import java.util.UUID;

public class SimpleWaypoint implements Waypoint {
    private final UUID id;
    private final String name;
    private Location location;
    private Color color;
    private WaypointStyle style;
    private ResourceLocation customStyle;

    public SimpleWaypoint(UUID id, String name, Location location, Color color, WaypointStyle style, ResourceLocation customStyle) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.color = color;
        this.style = style;
        this.customStyle = customStyle;
    }

    @Override
    public UUID getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public WaypointStyle getStyle() {
        return style;
    }

    public ResourceLocation getCustomStyle() {
        return customStyle;
    }

    @Override
    public void update(Location newLocation) {
        this.location = newLocation;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setStyle(WaypointStyle style) {
        this.style = style;
    }

    public void setCustomStyle(ResourceLocation customStyle) {
        this.customStyle = customStyle;
    }
}
