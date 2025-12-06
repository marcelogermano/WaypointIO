package dev.kaxtusik.waypointio;

import com.github.retrooper.packetevents.resources.ResourceLocation;

public enum WaypointStyle {
    DEFAULT("minecraft", "default"),
    BOWTIE("minecraft", "bowtie");

    private final ResourceLocation location;

    WaypointStyle(String namespace, String path) {
        this.location = new ResourceLocation(namespace, path);
    }

    public ResourceLocation getResourceLocation() {
        return location;
    }
}
