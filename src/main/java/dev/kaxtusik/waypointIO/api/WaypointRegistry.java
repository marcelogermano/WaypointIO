package dev.kaxtusik.waypointIO.api;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class WaypointRegistry {

    private final Map<UUID, Map<UUID, Waypoint>> playerWaypoints;

    public WaypointRegistry() {
        this.playerWaypoints = new ConcurrentHashMap<>();
    }

    public void add(Player player, Waypoint waypoint) {
        playerWaypoints
                .computeIfAbsent(player.getUniqueId(), k -> new ConcurrentHashMap<>())
                .put(waypoint.getID(), waypoint);
    }

    public void remove(Player player, UUID waypointID) {
        Map<UUID, Waypoint> waypoints = playerWaypoints.get(player.getUniqueId());
        if (waypoints != null) {
            waypoints.remove(waypointID);
        }
    }

    public Waypoint get(Player player, UUID waypointID) {
        Map<UUID, Waypoint> waypoints = playerWaypoints.get(player.getUniqueId());
        return waypoints != null ? waypoints.get(waypointID) : null;
    }

    public Collection<Waypoint> getAll(Player player) {
        Map<UUID, Waypoint> waypoints = playerWaypoints.get(player.getUniqueId());
        return waypoints != null ? waypoints.values() : Collections.emptyList();
    }

    public void clear(Player player) {
        playerWaypoints.remove(player.getUniqueId());
    }

}