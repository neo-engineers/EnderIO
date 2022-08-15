package goldenapple.rfdrills;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import goldenapple.rfdrills.compat.waila.WailaCompat;
import goldenapple.rfdrills.config.ConfigHandler;
import goldenapple.rfdrills.init.ModItems;
import goldenapple.rfdrills.init.ModRecipes;
import goldenapple.rfdrills.item.soulupgrade.SoulUpgradeRecipeHandler;
import goldenapple.rfdrills.reference.Reference;
import net.minecraftforge.common.MinecraftForge;

public class RFDrills {
    @SidedProxy(serverSide = Reference.COMMON_PROXY, clientSide = Reference.CLIENT_PROXY)
    public static CommonProxy proxy;

    public static boolean isXULoaded;
    public static boolean isWailaLoaded;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        isXULoaded = Loader.isModLoaded("ExtraUtilities");
        isWailaLoaded = Loader.isModLoaded("Waila");

        FMLCommonHandler.instance().bus().register(new ConfigHandler(event.getSuggestedConfigurationFile()));

        ModItems.init();
        proxy.preInit();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        if (isWailaLoaded) FMLInterModComms.sendMessage("Waila", "register", WailaCompat.class.getName() + ".init");
        ModRecipes.init();

        if (ConfigHandler.integrateEIO) MinecraftForge.EVENT_BUS.register(new SoulUpgradeRecipeHandler());
        proxy.init();
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}
