package tonius.simplyjetpacks.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemRegistered extends Item {

    public ItemRegistered(String registryName) {
        GameRegistry.registerItem(this, registryName);
    }
}
