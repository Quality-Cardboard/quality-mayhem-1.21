package net.qualitycard.qualitymayhem.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.entity.custom.AtomicBlastProjectileEntity;

import javax.swing.text.html.parser.Entity;

public class AtomicBlastProjectileModel extends EntityModel<AtomicBlastProjectileEntity> {
    public static final EntityModelLayer ATOMIC_BLAST = new EntityModelLayer(Identifier.of(QualityMayhem.MOD_ID, "atomic_blast"), "main");
    private final ModelPart atomic_blast;
    public AtomicBlastProjectileModel(ModelPart root) {
        this.atomic_blast = root.getChild("atomic_blast");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData atomic_blast = modelPartData.addChild("atomic_blast", ModelPartBuilder.create(), ModelTransform.pivot(24.0F, 16.0F, -24.0F));

        ModelPartData top = atomic_blast.addChild("top", ModelPartBuilder.create().uv(-64, 0).cuboid(-32.0F, 8.0F, -32.0F, 64.0F, 0.0F, 64.0F, new Dilation(0.0F)), ModelTransform.pivot(-24.0F, 0.0F, 24.0F));

        ModelPartData middle = atomic_blast.addChild("middle", ModelPartBuilder.create().uv(-17, 80).cuboid(-24.0F, 12.0F, -24.0F, 48.0F, 0.0F, 48.0F, new Dilation(0.0F)), ModelTransform.pivot(-24.0F, -8.0F, 24.0F));

        ModelPartData bottom = atomic_blast.addChild("bottom", ModelPartBuilder.create().uv(113, 2).cuboid(-16.0F, -8.0F, -16.0F, 32.0F, 0.0F, 32.0F, new Dilation(0.0F)), ModelTransform.pivot(-24.0F, 8.0F, 24.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }
    @Override
    public void setAngles(AtomicBlastProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        atomic_blast.render(matrices, vertexConsumer, light, overlay, color);
    }

}
