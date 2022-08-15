package tonius.simplyjetpacks.integration;

import cpw.mods.fml.common.Loader;
import crazypants.enderio.EnderIO;

public enum ModType {
    SIMPLY_JETPACKS("", EnderIO.MODID),
    ENDER_IO(".eio", "EnderIO");

    public final String suffix;
    public final String[] modids;
    public final boolean loaded;

    private ModType(String suffix, String... modids) {
        this.suffix = suffix;
        this.modids = modids;

        for (String s : this.modids) {
            if (!Loader.isModLoaded(s)) {
                this.loaded = false;
                return;
            }
        }
        this.loaded = true;
    }
}
