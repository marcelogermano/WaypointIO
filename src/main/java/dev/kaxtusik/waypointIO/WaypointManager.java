package dev.kaxtusik.waypointIO;

import dev.kaxtusik.waypointIO.api.Waypoint;
import dev.kaxtusik.waypointIO.api.WaypointRegistry;
import dev.kaxtusik.waypointIO.impl.PacketSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

public class WaypointManager {

    private final WaypointRegistry registry;
    private final PacketSender packetSender;

    public WaypointManager() {
        this.registry = new WaypointRegistry();
        this.packetSender = new PacketSender();
    }

    public void showWaypoint(Player player, Waypoint waypoint) {
        this.registry.add(player, waypoint);
        this.packetSender.sendTrack(player, waypoint);
    }

    public void hideWaypoint(Player player, UUID waypointID) {
        Waypoint waypoint = this.registry.get(player, waypointID);
        if (waypoint != null) {
            this.packetSender.sendUntrack(player, waypoint);
            this.registry.remove(player, waypointID);
        }
    }

    public void updateWaypoint(Player player, Waypoint waypoint) {
        Waypoint existing = registry.get(player, waypoint.getID());
        if (existing != null) {
            registry.add(player, waypoint);
            packetSender.sendUpdate(player, waypoint);
        }
    }

    public void hideAllWaypoints(Player player) {
        this.registry.getAll(player).forEach(waypoint -> hideWaypoint(player, waypoint.getID()));
    }

    public Collection<Waypoint> getWaypoints(Player player) {
        return this.registry.getAll(player);
    }
}
