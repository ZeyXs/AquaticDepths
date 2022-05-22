package fr.zeyx.aquaticdepths.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.zeyx.aquaticdepths.items.armor.ArmorMaterial;
import fr.zeyx.aquaticdepths.items.armor.ArmorUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.GuiUtils;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;

public class InGameOverlay {

    private static final ResourceLocation PRESSURE_GAUGE_TEXTURE = new ResourceLocation("minecraft", "textures/gui/recipe_book.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static final IIngameOverlay PRESSURE_GAUGE = (gui, mStack, partialTicks, width, height) -> {
        if (minecraft.getCameraEntity() instanceof Player player) {
            if (ArmorUtils.hasFullSuitOfArmor(player) && ArmorUtils.hasCorrectArmor(ArmorMaterial.DIVING, player)) {
                gui.setupOverlayRenderState(true, false, PRESSURE_GAUGE_TEXTURE);
                gui.setBlitOffset(-90);
                renderPressureGauge(mStack, width);
                player.getLevel().getProfiler();
            }
        }
    };

    private static void renderPressureGauge(PoseStack poseStack, int width) {
        int x = width / 2;
        GuiUtils.drawTexturedModalRect(poseStack, x, 0, 0, 0, 16, 16, 0);
    }

    public static void register() {
        OverlayRegistry.registerOverlayTop("PressureGauge", InGameOverlay.PRESSURE_GAUGE);
    }
}
