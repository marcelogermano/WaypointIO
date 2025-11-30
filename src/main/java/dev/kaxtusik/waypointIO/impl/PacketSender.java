package dev.kaxtusik.waypointIO.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.color.Color;
import com.github.retrooper.packetevents.protocol.world.waypoint.TrackedWaypoint;
import com.github.retrooper.packetevents.protocol.world.waypoint.Vec3iWaypointInfo;
import com.github.retrooper.packetevents.protocol.world.waypoint.WaypointIcon;
import com.github.retrooper.packetevents.protocol.world.waypoint.WaypointInfo;
import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.util.Either;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerWaypoint;
import dev.kaxtusik.waypointIO.api.Waypoint;
import org.bukkit.entity.Player;

public class PacketSender {

    public void sendTrack(Player player, Waypoint waypoint) {
        TrackedWaypoint tracked = createTrackedWaypoint(waypoint);
        WrapperPlayServerWaypoint packet = new WrapperPlayServerWaypoint(
                WrapperPlayServerWaypoint.Operation.TRACK,
                tracked
        );
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }

    public void sendUntrack(Player player, Waypoint waypoint) {
        TrackedWaypoint tracked = createTrackedWaypoint(waypoint);
        WrapperPlayServerWaypoint packet = new WrapperPlayServerWaypoint(
                WrapperPlayServerWaypoint.Operation.UNTRACK,
                tracked
        );
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }

    public void sendUpdate(Player player, Waypoint waypoint) {
        TrackedWaypoint tracked = createTrackedWaypoint(waypoint);
        WrapperPlayServerWaypoint packet = new WrapperPlayServerWaypoint(
                WrapperPlayServerWaypoint.Operation.UPDATE,
                tracked
        );
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }

    private TrackedWaypoint createTrackedWaypoint(Waypoint waypoint) {
        ResourceLocation styleLocation;

        if (waypoint.getStyle() != null) {
            styleLocation = waypoint.getStyle().getResourceLocation();
        } else if (waypoint instanceof SimpleWaypoint simple && simple.getCustomStyle() != null) {
            styleLocation = simple.getCustomStyle();
        } else {
            styleLocation = new ResourceLocation("minecraft", "default");
        }

        WaypointIcon icon = new WaypointIcon(
                styleLocation,
                new Color(waypoint.getColor().getRed(), waypoint.getColor().getGreen(), waypoint.getColor().getBlue())
        );

        WaypointInfo info = new Vec3iWaypointInfo(
                new Vector3i(
                        waypoint.getLocation().getBlockX(),
                        waypoint.getLocation().getBlockY(),
                        waypoint.getLocation().getBlockZ()
                )
        );

        return new TrackedWaypoint(
                Either.createLeft(waypoint.getID()),
                icon,
                info
        );
    }
}