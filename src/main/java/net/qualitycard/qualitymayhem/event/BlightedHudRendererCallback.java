package net.qualitycard.qualitymayhem.event;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.effect.ModEffects;
import net.qualitycard.qualitymayhem.item.custom.FalseSunItem;

public class BlightedHudRendererCallback implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext context, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        assert client.player != null;

        if (client.player.getActiveStatusEffects().containsKey(ModEffects.BLIGHTED)) {
            Identifier texture = Identifier.of("qualitymayhem", "textures/screen/blighted.png");
            int alpha = 128;  //  This will make the texture 50% opaque (128/255 = 0.5)
            int red = 255; // Red component of the color (if you want to tint the texture)
            int green = 255; // Green component of the color
            int blue = 255; // Blue component of the color
            int color = (alpha << 24) | (red << 16) | (green << 8) | blue;

            context.drawTexture(texture, 0, 0, 0, 0, context.getScaledWindowWidth(), context.getScaledWindowHeight(), context.getScaledWindowWidth(), context.getScaledWindowHeight());
        }





        // Testing stuff
        // Check if the player is holding an item
        /*
        // Gets what the player is holding in their main and offhand
        ItemStack offHandStack = client.player.getOffHandStack();
        ItemStack mainHandStack = client.player.getMainHandStack();
        if (offHandStack.getItem() instanceof FalseSunItem || mainHandStack.getItem() instanceof FalseSunItem) {
            Identifier texture = Identifier.of("qualitymayhem", "textures/screen/blighted.png");
            // texture, x, y, u, v, width, height, textureWidth, textureHeight
            context.drawTexture(texture, 0, 0, 0, 0, context.getScaledWindowWidth(), context.getScaledWindowHeight(), context.getScaledWindowWidth(), context.getScaledWindowHeight());
            int color = 0xFFFF0000; // Red
            context.fill(0, 0, 10, 10, 0, color);
            context.fill(0, 0, 1, 1, 0xFFFF0000);
        }
        */
    }
}
