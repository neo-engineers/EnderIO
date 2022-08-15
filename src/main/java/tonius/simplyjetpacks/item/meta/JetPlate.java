package tonius.simplyjetpacks.item.meta;

import cofh.lib.util.helpers.StringHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import tonius.simplyjetpacks.SimplyJetpacks;
import tonius.simplyjetpacks.integration.ModType;
import tonius.simplyjetpacks.item.ItemPack;
import tonius.simplyjetpacks.setup.ModKey;
import tonius.simplyjetpacks.util.NBTHelper;
import tonius.simplyjetpacks.util.SJStringHelper;

public class JetPlate extends Jetpack {

    protected static final String TAG_CHARGER_ON = "JetPlateChargerOn";
    protected static final String TAG_ENDERIUM_UPGRADE = "JetPlateEnderiumUpgrade";

    public IIcon iconEnderium;

    public JetPlate(int tier, EnumRarity rarity, String defaultConfigKey) {
        super(tier, rarity, defaultConfigKey);
        this.setIsArmored(true);
        this.setShowArmored(false);
    }

    @Override
    public void tickArmor(World world, EntityPlayer player, ItemStack stack, ItemPack item) {
        super.tickArmor(world, player, stack, item);
        if (this.isChargerOn(stack)) {
            this.chargeInventory(player, stack, item);
        }
    }

    @Override
    public void toggleSecondary(ItemStack stack, EntityPlayer player, boolean showInChat) {
        this.toggleCharger(stack, player, showInChat);
    }

    public boolean isChargerOn(ItemStack stack) {
        return NBTHelper.getNBTBoolean(stack, TAG_CHARGER_ON, true);
    }

    public void toggleCharger(ItemStack stack, EntityPlayer player, boolean showInChat) {
        this.toggleState(this.isChargerOn(stack), stack, "jetplate.charger", TAG_CHARGER_ON, player, showInChat);
    }

    public boolean hasEnderiumUpgrade(ItemStack stack) {
        return NBTHelper.getNBTBoolean(stack, TAG_ENDERIUM_UPGRADE, false);
    }

    public void setEnderiumUpgrade(ItemStack stack, boolean enderUpgrade) {
        NBTHelper.getNBT(stack).setBoolean(TAG_ENDERIUM_UPGRADE, enderUpgrade);
    }

    @Override
    public ModKey[] getGuiControls() {
        if (this.emergencyHoverMode) {
            return new ModKey[] {
                ModKey.TOGGLE_PRIMARY, ModKey.MODE_PRIMARY, ModKey.TOGGLE_SECONDARY, ModKey.MODE_SECONDARY
            };
        } else {
            return new ModKey[] {ModKey.TOGGLE_PRIMARY, ModKey.MODE_PRIMARY, ModKey.TOGGLE_SECONDARY};
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register, ModType modType) {
        super.registerIcons(register, modType);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack) {
        if (this.iconEnderium != null && this.hasEnderiumUpgrade(stack)) {
            return this.iconEnderium;
        }
        return super.getIcon(stack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, ModType modType) {
        return super.getArmorTexture(stack, entity, slot, modType);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, ItemPack item, EntityPlayer player, List list) {
        super.addInformation(stack, item, player, list);
        if (StringHelper.isControlKeyDown()) {
            list.add(StringHelper.GRAY + SJStringHelper.localize("tooltip.jetplate.dank"));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addShiftInformation(ItemStack stack, ItemPack item, EntityPlayer player, List list) {
        list.add(SJStringHelper.getStateText(this.isOn(stack)));
        list.add(SJStringHelper.getHoverModeText(this.isHoverModeOn(stack)));
        list.add(SJStringHelper.getChargerStateText(this.isChargerOn(stack)));
        if (this.fuelUsage > 0) {
            list.add(SJStringHelper.getFuelUsageText(this.fuelType, this.getFuelUsage(stack)));
        }
        list.add(SJStringHelper.getChargerRateText(this.fuelPerTickOut));
        list.add(SJStringHelper.getParticlesText(this.getParticleType(stack)));
        SJStringHelper.addDescriptionLines(list, "jetplate", StringHelper.BRIGHT_GREEN);
        String key = SimplyJetpacks.proxy.getPackGUIKey();
        if (key != null) {
            list.add(SJStringHelper.getPackGUIText(key));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addSubItems(ItemPack item, int meta, List list) {
        super.addSubItems(item, meta, list);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getHUDStatesInfo(ItemStack stack, ItemPack item) {
        Boolean engine = this.isOn(stack);
        Boolean hover = this.isHoverModeOn(stack);
        Boolean charger = this.isChargerOn(stack);
        return SJStringHelper.getHUDStateText(engine, hover, charger);
    }
}
