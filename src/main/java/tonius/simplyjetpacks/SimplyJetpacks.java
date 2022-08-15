package tonius.simplyjetpacks;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazypants.enderio.EnderIO;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import org.apache.logging.log4j.Logger;
import tonius.simplyjetpacks.config.Config;
import tonius.simplyjetpacks.crafting.UpgradingRecipe;
import tonius.simplyjetpacks.handler.SyncHandler;
import tonius.simplyjetpacks.network.PacketHandler;
import tonius.simplyjetpacks.setup.ModEnchantments;
import tonius.simplyjetpacks.setup.ModItems;
import tonius.simplyjetpacks.setup.Packs;

public class SimplyJetpacks {

    public static final String PREFIX = EnderIO.MODID + ".";
    public static final String RESOURCE_PREFIX = EnderIO.MODID + ":";

    @SidedProxy(
            clientSide = "tonius.simplyjetpacks.client.ClientProxy",
            serverSide = "tonius.simplyjetpacks.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger;
    public static SyncHandler keyboard;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent evt) {
        logger = evt.getModLog();
        logger.info("Starting Simply Jetpacks");

        checkCoFHLib();

        Packs.preInit();
        Config.preInit(evt);
        ModItems.preInit();
    }

    @EventHandler
    public static void init(FMLInitializationEvent evt) {
        RecipeSorter.register(
                EnderIO.MODID + ":upgrading", UpgradingRecipe.class, Category.SHAPED, "after:minecraft:shaped");
        proxy.registerHandlers();
        PacketHandler.init();
        ModItems.init();
        ModEnchantments.init();
    }

    private static void checkCoFHLib() {
        try {
            Class.forName("cofh.lib.util.helpers.FireworksHelper$Explosion");
            logger.info("Successfully found CoFHLib");
            return;

        } catch (ClassNotFoundException e) {
            logger.error("Could not find CoFHLib!");
            proxy.throwCoFHLibException();
        }
    }
}
