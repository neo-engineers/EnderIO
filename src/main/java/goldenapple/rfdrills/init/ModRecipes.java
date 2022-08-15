package goldenapple.rfdrills.init;

import cofh.lib.util.helpers.ItemHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import crazypants.enderio.EnderIO;
import goldenapple.rfdrills.crafting.ShapedUpgradeRecipe;
import goldenapple.rfdrills.crafting.ShapelessMuffleRecipe;
import goldenapple.rfdrills.crafting.ShapelessUnmuffleRecipe;
import goldenapple.rfdrills.reference.Metadata;
import goldenapple.rfdrills.util.OreHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tonius.simplyjetpacks.integration.EIORecipes;

public class ModRecipes {

    public static void init() {
        RecipeSorter.register(
                EnderIO.MODID + ":upgrading",
                ShapedUpgradeRecipe.class,
                RecipeSorter.Category.SHAPED,
                "after:minecraft:shaped before:minecraft:shapeless");
        RecipeSorter.register(
                EnderIO.MODID + ":muffle",
                ShapelessMuffleRecipe.class,
                RecipeSorter.Category.SHAPELESS,
                "after:minecraft:shapeless");
        RecipeSorter.register(
                EnderIO.MODID + ":unmuffle",
                ShapelessUnmuffleRecipe.class,
                RecipeSorter.Category.SHAPELESS,
                "after:minecraft:shapeless");

        ItemStack motorBasic = new ItemStack(ModItems.componentEIO, 1, Metadata.MOTOR_BASIC);
        ItemStack motorAdvanced = new ItemStack(ModItems.componentEIO, 1, Metadata.MOTOR_ADVANCED);
        ItemStack machineChassis = new ItemStack(GameRegistry.findItem("EnderIO", "itemMachinePart"), 1, 0);
        ItemStack pulsatingCrystal = new ItemStack(GameRegistry.findItem("EnderIO", "itemMaterial"), 1, 5);
        ItemStack capacitorBasic = new ItemStack(GameRegistry.findItem("EnderIO", "itemBasicCapacitor"), 1, 0);
        ItemStack capacitorAdvanced = new ItemStack(GameRegistry.findItem("EnderIO", "itemBasicCapacitor"), 1, 1);

        ItemStack resonatingCrystal = new ItemStack(ModItems.componentEIO, 1, Metadata.RESONATING_CRYSTAL);
        ItemStack destructiveCrystal = new ItemStack(ModItems.componentEIO, 1, Metadata.DESTRUCTIVE_CRYSTAL);
        ItemStack earthshakingCrystal = new ItemStack(ModItems.componentEIO, 1, Metadata.EARTHSHAKING_CRYSTAL);
        ItemStack ingotDarkSoularium = OreHelper.findFirstOre("ingotDarkSoularium");
        ItemStack nugggetDarkSoularium = OreHelper.findFirstOre("nuggetDarkSoularium");
        ItemStack ingotDarkSteel = OreHelper.findFirstOre("ingotDarkSteel");
        ItemStack ingotSoularium = OreHelper.findFirstOre("ingotSoularium");
        ItemStack nuggetSoularium = OreHelper.findFirstOre("nuggetSoularium");

        // Basic motor
        GameRegistry.addRecipe(new ShapedOreRecipe(
                motorBasic,
                "RGR",
                "iFi",
                "RCR",
                'i',
                "itemSilicon",
                'F',
                machineChassis,
                'G',
                "gearStone",
                'R',
                "dustRedstone",
                'C',
                capacitorBasic));

        // Advanced motor
        GameRegistry.addRecipe(new ShapedOreRecipe(
                motorAdvanced,
                "RPR",
                "iFi",
                "RCR",
                'i',
                "ingotEnergeticAlloy",
                'F',
                machineChassis,
                'P',
                pulsatingCrystal,
                'R',
                "ingotRedstoneAlloy",
                'C',
                capacitorAdvanced));

        // Basic drill
        GameRegistry.addRecipe(new ShapedUpgradeRecipe(
                ModItems.basicDrill,
                " i ",
                "iMi",
                "ICI",
                'I',
                "itemSilicon",
                'i',
                "ingotConductiveIron",
                'C',
                capacitorBasic,
                'M',
                motorBasic));
        GameRegistry.addRecipe(new ShapelessMuffleRecipe(ModItems.basicDrill));
        GameRegistry.addRecipe(new ShapelessUnmuffleRecipe(ModItems.basicDrill));

        // Basic chainsaw
        GameRegistry.addRecipe(new ShapedUpgradeRecipe(
                        ModItems.basicChainsaw,
                        " ii",
                        "IMi",
                        "CI ",
                        'I',
                        "itemSilicon",
                        'i',
                        "ingotConductiveIron",
                        'C',
                        capacitorBasic,
                        'M',
                        motorBasic)
                .setMirrored(true));
        GameRegistry.addRecipe(new ShapelessMuffleRecipe(ModItems.basicChainsaw));
        GameRegistry.addRecipe(new ShapelessUnmuffleRecipe(ModItems.basicChainsaw));

        // Advanced drill
        GameRegistry.addRecipe(new ShapedUpgradeRecipe(
                ModItems.advancedDrill,
                " D ",
                "iMi",
                "ICI",
                'I',
                "ingotEnergeticAlloy",
                'i',
                "ingotElectricalSteel",
                'C',
                capacitorAdvanced,
                'M',
                motorAdvanced,
                'D',
                ModItems.basicDrill));
        GameRegistry.addRecipe(new ShapelessMuffleRecipe(ModItems.advancedDrill));
        GameRegistry.addRecipe(new ShapelessUnmuffleRecipe(ModItems.advancedDrill));

        // Advanced chainsaw
        GameRegistry.addRecipe(new ShapedUpgradeRecipe(
                        ModItems.advancedChainsaw,
                        " iS",
                        "IMi",
                        "CI ",
                        'I',
                        "ingotEnergeticAlloy",
                        'i',
                        "ingotElectricalSteel",
                        'C',
                        capacitorAdvanced,
                        'M',
                        motorAdvanced,
                        'S',
                        ModItems.basicChainsaw)
                .setMirrored(true));
        GameRegistry.addRecipe(new ShapelessMuffleRecipe(ModItems.advancedChainsaw));
        GameRegistry.addRecipe(new ShapelessUnmuffleRecipe(ModItems.advancedChainsaw));

        // Soularium ingot <-> nuggets
        ItemHelper.addTwoWayStorageRecipe(ingotSoularium, "ingotSoularium", nuggetSoularium, "nuggetSoularium");

        // Dark Soularium ingot <-> nuggets
        ItemHelper.addTwoWayStorageRecipe(
                ingotDarkSoularium, "ingotDarkSoularium", nugggetDarkSoularium, "nuggetDarkSoularium");

        // Soul Crusher
        GameRegistry.addRecipe(new ShapedUpgradeRecipe(
                        ModItems.soulCrusher,
                        "iGi",
                        "DSC",
                        " S ",
                        'i',
                        "ingotDarkSoularium",
                        'G',
                        resonatingCrystal,
                        'S',
                        "itemDarkSteelRod",
                        'D',
                        ModItems.advancedDrill,
                        'C',
                        ModItems.advancedChainsaw)
                .setMirrored(true));
        GameRegistry.addRecipe(new ShapelessMuffleRecipe(ModItems.soulCrusher));
        GameRegistry.addRecipe(new ShapelessUnmuffleRecipe(ModItems.soulCrusher));

        // Resonating Crystal
        GameRegistry.addRecipe(new ShapedOreRecipe(
                resonatingCrystal, "nnn", "nGn", "nnn", 'n', "nuggetDarkSoularium", 'G', "gemDiamond"));

        // Destructive Crystal
        EIORecipes.addSoulBinderRecipe(
                "Destructive Crystal", 100000, 10, "Creeper", resonatingCrystal, destructiveCrystal);

        // Earthshaking Crystal
        EIORecipes.addSoulBinderRecipe(
                "Earthshaking Crystal", 200000, 15, "Ghast", destructiveCrystal, earthshakingCrystal);

        // Flux Hoe
        GameRegistry.addRecipe(new ShapedUpgradeRecipe(
                        ModItems.fluxHoe,
                        "iC",
                        " s",
                        " s",
                        'i',
                        "ingotElectricalSteel",
                        'C',
                        capacitorBasic,
                        's',
                        "itemSilicon")
                .setMirrored(true));
    }
}
