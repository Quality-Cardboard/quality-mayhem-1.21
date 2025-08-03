package net.qualitycard.qualitymayhem.entity.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.entity.custom.AtomicBlastProjectileEntity;
import net.qualitycard.qualitymayhem.entity.custom.DraupnirProjectileEntity;

public class DraupnirProjectileRenderer extends EntityRenderer<DraupnirProjectileEntity> {
    protected DraupnirProjectileModel model;
    public DraupnirProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new DraupnirProjectileModel(ctx.getPart(DraupnirProjectileModel.DRAUPNIR));
    }

    @Override
    public void render(DraupnirProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        VertexConsumer vertexconsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers,
                this.model.getLayer(Identifier.of(QualityMayhem.MOD_ID, "textures/entity/draupnir/draupnir.png")), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(DraupnirProjectileEntity entity) {
        return Identifier.of(QualityMayhem.MOD_ID, "textures/entity/draupnir/draupnir.png");
    }

}
