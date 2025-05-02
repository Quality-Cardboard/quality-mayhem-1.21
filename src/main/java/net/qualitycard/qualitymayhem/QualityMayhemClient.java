package net.qualitycard.qualitymayhem;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.BlockRenderContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.qualitycard.qualitymayhem.block.ModBlocks;
import net.qualitycard.qualitymayhem.entity.ModEntities;
import net.qualitycard.qualitymayhem.entity.client.AtomicBlastProjectileModel;
import net.qualitycard.qualitymayhem.entity.client.AtomicBlastProjectileRenderer;
import net.qualitycard.qualitymayhem.entity.client.ScutterBugModel;
import net.qualitycard.qualitymayhem.entity.client.ScutterBugRenderer;

public class QualityMayhemClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COBALT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COBALT_TRAPDOOR, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ScutterBugModel.SCUTTER_BUG, ScutterBugModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SCUTTER_BUG, ScutterBugRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(AtomicBlastProjectileModel.ATOMIC_BLAST, AtomicBlastProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ATOMIC_BLAST, AtomicBlastProjectileRenderer::new);
    }
}
