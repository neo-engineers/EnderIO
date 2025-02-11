package crazypants.enderio.machine.slicensplice;

import crazypants.enderio.machine.gui.GuiPoweredMachineBase;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

public class GuiSliceAndSplice extends GuiPoweredMachineBase<TileSliceAndSplice> {

    public GuiSliceAndSplice(InventoryPlayer par1InventoryPlayer, TileSliceAndSplice te) {
        super(te, new ContainerSliceAndSplice(par1InventoryPlayer, te), "sliceAndSplice");

        addProgressTooltip(103, 49, 24, 16);
    }

    @Override
    public void initGui() {
        super.initGui();
        ((ContainerSliceAndSplice) inventorySlots).createGhostSlots(getGhostSlots());
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the
     * items)
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        bindGuiTexture();
        int k = guiLeft;
        int l = guiTop;

        drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

        if (shouldRenderProgress()) {
            int scaled = getProgressScaled(24);
            drawTexturedModalRect(k + 103, l + 49, 176, 14, scaled + 1, 16);
        }

        super.drawGuiContainerBackgroundLayer(par1, par2, par3);
    }
}
