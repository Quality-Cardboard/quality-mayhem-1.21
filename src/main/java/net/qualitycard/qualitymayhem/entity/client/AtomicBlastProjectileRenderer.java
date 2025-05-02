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

public class AtomicBlastProjectileRenderer extends EntityRenderer<AtomicBlastProjectileEntity> {
    protected AtomicBlastProjectileModel model;

    public AtomicBlastProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new AtomicBlastProjectileModel(ctx.getPart(AtomicBlastProjectileModel.ATOMIC_BLAST));
    }

    @Override
    public void render(AtomicBlastProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        if(entity.isGrounded()) {
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(MathHelper.lerp(tickDelta, 0, 0)));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.getRenderingRotation() * 5f));
            matrices.translate(0, -0.9f, 0);
        }

        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers,
                this.model.getLayer(Identifier.of(QualityMayhem.MOD_ID, "textures/entity/atomic_blast/atomic_blast.png")), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(AtomicBlastProjectileEntity entity) {
        return Identifier.of(QualityMayhem.MOD_ID, "textures/entity/atomic_blast/atomic_blast.png");
    }
}
