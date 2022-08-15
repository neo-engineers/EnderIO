package tonius.simplyjetpacks.setup;

import net.minecraft.item.EnumRarity;
import tonius.simplyjetpacks.config.PackDefaults;
import tonius.simplyjetpacks.integration.ModType;
import tonius.simplyjetpacks.item.meta.FluxPack;
import tonius.simplyjetpacks.item.meta.JetPlate;
import tonius.simplyjetpacks.item.meta.Jetpack;
import tonius.simplyjetpacks.item.meta.JetpackPotato;

/**
 * for default pack tuning refer to {@link PackDefaults}
 */
public class Packs {

    public static void preInit() {
        jetpackPotato = new JetpackPotato(0, EnumRarity.common, "jetpackPotato");

        if (ModType.ENDER_IO.loaded) {
            jetpackEIO1 = new Jetpack(1, EnumRarity.common, "jetpackEIO1");
            jetpackEIO1Armored = (Jetpack) new Jetpack(1, EnumRarity.common, "jetpackEIO1")
                    .setIsArmored(true)
                    .setPlatingMeta(11);
            jetpackEIO2 = new Jetpack(2, EnumRarity.common, "jetpackEIO2");
            jetpackEIO2Armored = (Jetpack) new Jetpack(2, EnumRarity.common, "jetpackEIO2")
                    .setIsArmored(true)
                    .setPlatingMeta(12);
            jetpackEIO3 = new Jetpack(3, EnumRarity.uncommon, "jetpackEIO3");
            jetpackEIO3Armored = (Jetpack) new Jetpack(3, EnumRarity.uncommon, "jetpackEIO3")
                    .setIsArmored(true)
                    .setPlatingMeta(13);
            jetpackEIO4 = new Jetpack(4, EnumRarity.rare, "jetpackEIO4");
            jetpackEIO4Armored = (Jetpack) new Jetpack(4, EnumRarity.rare, "jetpackEIO4")
                    .setIsArmored(true)
                    .setPlatingMeta(14);
            jetpackEIO5 = new JetPlate(5, EnumRarity.epic, "jetpackEIO5");
            fluxPackEIO1 = new FluxPack(1, EnumRarity.common, "fluxPackEIO1");
            fluxPackEIO2 = new FluxPack(2, EnumRarity.common, "fluxPackEIO2");
            fluxPackEIO2Armored = (FluxPack) new FluxPack(2, EnumRarity.common, "fluxPackEIO2")
                    .setIsArmored(true)
                    .setPlatingMeta(11);
            fluxPackEIO3 = new FluxPack(3, EnumRarity.uncommon, "fluxPackEIO3");
            fluxPackEIO3Armored = (FluxPack) new FluxPack(3, EnumRarity.uncommon, "fluxPackEIO3")
                    .setIsArmored(true)
                    .setPlatingMeta(12);
            fluxPackEIO4 = new FluxPack(4, EnumRarity.rare, "fluxPackEIO4");
            fluxPackEIO4Armored = (FluxPack) new FluxPack(4, EnumRarity.rare, "fluxPackEIO4")
                    .setIsArmored(true)
                    .setPlatingMeta(13);
        }
    }

    public static Jetpack jetpackPotato;
    public static Jetpack jetpackEIO1;
    public static Jetpack jetpackEIO1Armored;
    public static Jetpack jetpackEIO2;
    public static Jetpack jetpackEIO2Armored;
    public static Jetpack jetpackEIO3;
    public static Jetpack jetpackEIO3Armored;
    public static Jetpack jetpackEIO4;
    public static Jetpack jetpackEIO4Armored;
    public static Jetpack jetpackEIO5;
    public static FluxPack fluxPackEIO1;
    public static FluxPack fluxPackEIO2;
    public static FluxPack fluxPackEIO2Armored;
    public static FluxPack fluxPackEIO3;
    public static FluxPack fluxPackEIO3Armored;
    public static FluxPack fluxPackEIO4;
    public static FluxPack fluxPackEIO4Armored;
}
