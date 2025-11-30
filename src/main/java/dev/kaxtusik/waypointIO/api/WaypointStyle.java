package dev.kaxtusik.waypointIO.api;

import com.github.retrooper.packetevents.resources.ResourceLocation;

public enum WaypointStyle {
    DEFAULT("minecraft", "default"),
    BOWTIE("minecraft", "bowtie");

    private final String namespace;
    private final String path;

    WaypointStyle(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }

    public ResourceLocation getResourceLocation() {
        return new ResourceLocation(namespace, path);
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }
}