package dev.kaxtusik.waypointio;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerWaypoint;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class WaypointManager {

    private final PacketSender packetSender;
    private final Map<UUID, Map<UUID, Waypoint>> activeWaypoints;

    public WaypointManager(JavaPlugin plugin) {
        if (PacketEvents.getAPI().getServerManager().getVersion().isOlderThan(ServerVersion.V_1_21_5)) {
            throw new UnsupportedOperationException("WaypointIO requires Minecraft 1.21.5 or newer.");
        }

        this.packetSender = new PacketSender();
        this.activeWaypoints = new ConcurrentHashMap<>();

        plugin.getLogger().info("WaypointManager initialized.");
    }

    public void showWaypoint(Player player, Waypoint waypoint) {
        this.activeWaypoints
                .computeIfAbsent(player.getUniqueId(), k -> new ConcurrentHashMap<>())
                .put(waypoint.id(), waypoint);

        this.packetSender.send(player, waypoint, WrapperPlayServerWaypoint.Operation.TRACK);
    }

    public void hideWaypoint(Player player, UUID waypointId) {
        var waypoints = this.activeWaypoints.get(player.getUniqueId());
        if (waypoints != null) {
            Waypoint wp = waypoints.remove(waypointId);
            if (wp != null) {
                this.packetSender.send(player, wp, WrapperPlayServerWaypoint.Operation.UNTRACK);
            }
        }
    }

    public void updateWaypoint(Player player, Waypoint waypoint) {
        var waypoints = activeWaypoints.get(player.getUniqueId());
        if (waypoints != null && waypoints.containsKey(waypoint.id())) {
            waypoints.put(waypoint.id(), waypoint);
            this.packetSender.send(player, waypoint, WrapperPlayServerWaypoint.Operation.UPDATE);
        }
    }

    public void hideAllWaypoints(Player player) {
        var waypoints = activeWaypoints.remove(player.getUniqueId());
        if (waypoints != null) {
            for (Waypoint wp : waypoints.values()) {
                this.packetSender.send(player, wp, WrapperPlayServerWaypoint.Operation.UNTRACK);
            }
        }
    }

    public Collection<Waypoint> getWaypoints(Player player) {
        var map = this.activeWaypoints.get(player.getUniqueId());
        return map == null ? Collections.emptyList() : new ArrayList<>(map.values());
    }
}