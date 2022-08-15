package goldenapple.rfdrills.client.gui;

import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import crazypants.enderio.EnderIO;
import goldenapple.rfdrills.config.ConfigHandler;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class RFDrillsGuiConfig extends GuiConfig {
    public RFDrillsGuiConfig(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(), EnderIO.MODID, false, false, EnderIO.MOD_NAME);
    }

    /** Compiles a list of config elements */
    @SuppressWarnings("unchecked")
    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.addAll(new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL))
                .getChildElements()); // other things from the General category get a separate button
        // Add categories to config GUI
        list.add(getCategoryElement("drill_tier1", "config.drill_tier1"));
        list.add(getCategoryElement("drill_tier2", "config.drill_tier2"));
        list.add(getCategoryElement("drill_tier3", "config.drill_tier3"));
        list.add(getCategoryElement("drill_tier4", "config.drill_tier4"));

        list.add(getCategoryElement("chainsaw_tier1", "config.chainsaw_tier1"));
        list.add(getCategoryElement("chainsaw_tier2", "config.chainsaw_tier2"));
        list.add(getCategoryElement("chainsaw_tier3", "config.chainsaw_tier3"));
        list.add(getCategoryElement("chainsaw_tier4", "config.chainsaw_tier4"));

        list.add(getCategoryElement("soulcrusher", "config.soul_crusher"));
        list.add(getCategoryElement("hoe", "config.hoe"));
        return list;
    }

    /** Creates a button linking to another screen where all options of the category are available (author: ljfa)*/
    @SuppressWarnings("unchecked")
    private static IConfigElement getCategoryElement(String category, String name) {
        return new DummyConfigElement.DummyCategoryElement(
                StatCollector.translateToLocal(name),
                name,
                new ConfigElement(ConfigHandler.config.getCategory(category)).getChildElements());
    }
}
