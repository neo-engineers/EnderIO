package goldenapple.rfdrills.init;

import cpw.mods.fml.common.registry.GameRegistry;
import goldenapple.rfdrills.item.*;
import goldenapple.rfdrills.reference.Metadata;
import goldenapple.rfdrills.reference.Names;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {
    public static Item fluxHoe = new ItemFluxHoe();
    public static ItemMultiMetadata componentEIO = new ItemMultiMetadata(Names.COMPONENTS_EIO, Names.COMPONENT_EIO);
    public static Item basicDrill = new ItemDrill(Names.BASIC_DRILL, ToolTier.DRILL1);
    public static Item advancedDrill = new ItemDrill(Names.ADVANCED_DRILL, ToolTier.DRILL3);
    public static Item soulCrusher = new ItemSoulCrusher();
    public static Item basicChainsaw = new ItemChainsaw(Names.BASIC_CHAINSAW, ToolTier.CHAINSAW1);
    public static Item advancedChainsaw = new ItemChainsaw(Names.ADVANCED_CHAINSAW, ToolTier.CHAINSAW3);

    public static void init() {
        componentEIO.setEffects(false, false, true, false, true, true, true);
        componentEIO.setRarities(
                EnumRarity.common,
                EnumRarity.uncommon,
                EnumRarity.uncommon,
                EnumRarity.common,
                EnumRarity.uncommon,
                EnumRarity.uncommon,
                EnumRarity.rare);
        componentEIO.setTooltips(
                null, null, null, null, null, new String[] {"rfdrills.soul_upgrade.tooltip"}, new String[] {
                    "rfdrills.soul_upgrade.tooltip"
                });

        GameRegistry.registerItem(componentEIO, Names.COMPONENT_EIO);
        OreDictionary.registerOre("nuggetSoularium", new ItemStack(componentEIO, 1, Metadata.SOULARIUM_NUGGET));
        OreDictionary.registerOre(
                "nuggetDarkSoularium", new ItemStack(componentEIO, 1, Metadata.DARK_SOULARIUM_NUGGET));

        GameRegistry.registerItem(basicDrill, Names.BASIC_DRILL);
        GameRegistry.registerItem(advancedDrill, Names.ADVANCED_DRILL);

        GameRegistry.registerItem(basicChainsaw, Names.BASIC_CHAINSAW);
        GameRegistry.registerItem(advancedChainsaw, Names.ADVANCED_CHAINSAW);

        GameRegistry.registerItem(soulCrusher, Names.SOUL_CRUSHER);
        GameRegistry.registerItem(fluxHoe, Names.FLUX_HOE);
    }
}
