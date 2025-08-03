package net.qualitycard.qualitymayhem;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.BlockRenderContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.qualitycard.qualitymayhem.block.ModBlocks;
import net.qualitycard.qualitymayhem.entity.ModEntities;
import net.qualitycard.qualitymayhem.entity.client.*;
import net.qualitycard.qualitymayhem.item.custom.FalseSunItem;
import net.qualitycard.qualitymayhem.particle.AtomicBlastExplosionParticle;
import net.qualitycard.qualitymayhem.particle.LightParticle;
import net.qualitycard.qualitymayhem.particle.ModParticles;
import org.intellij.lang.annotations.Identifier;

public class QualityMayhemClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COBALT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COBALT_TRAPDOOR, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ScutterBugModel.SCUTTER_BUG, ScutterBugModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SCUTTER_BUG, ScutterBugRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(AtomicBlastProjectileModel.ATOMIC_BLAST, AtomicBlastProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ATOMIC_BLAST, AtomicBlastProjectileRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.ATOMIC_BLAST_EXPLOSION_PARTICLE, AtomicBlastExplosionParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.LIGHT_PARTICLE, LightParticle.Factory::new);

        EntityModelLayerRegistry.registerModelLayer(DraupnirProjectileModel.DRAUPNIR, DraupnirProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.DRAUPNIR, DraupnirProjectileRenderer::new);
    }

}
