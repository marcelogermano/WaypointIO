package dev.kaxtusik.waypointio;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.color.Color;
import com.github.retrooper.packetevents.protocol.world.waypoint.*;
import com.github.retrooper.packetevents.util.Either;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerWaypoint;
import org.bukkit.entity.Player;

final class PacketSender {

    public void send(Player player, Waypoint waypoint, WrapperPlayServerWaypoint.Operation operation) {
        TrackedWaypoint tracked = createTrackedWaypoint(waypoint);
        WrapperPlayServerWaypoint packet = new WrapperPlayServerWaypoint(operation, tracked);
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }

    private TrackedWaypoint createTrackedWaypoint(Waypoint waypoint) {
        WaypointIcon icon = new WaypointIcon(
                waypoint.styleLocation(),
                new Color(waypoint.color().getRed(), waypoint.color().getGreen(), waypoint.color().getBlue())
        );

        WaypointInfo info = new Vec3iWaypointInfo(
                new Vector3i(
                        waypoint.location().getBlockX(),
                        waypoint.location().getBlockY(),
                        waypoint.location().getBlockZ()
                )
        );

        return new TrackedWaypoint(
                Either.createLeft(waypoint.id()),
                icon,
                info
        );
    }

}