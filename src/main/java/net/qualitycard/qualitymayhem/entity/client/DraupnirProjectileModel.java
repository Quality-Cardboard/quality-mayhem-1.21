package net.qualitycard.qualitymayhem.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.entity.custom.AtomicBlastProjectileEntity;
import net.qualitycard.qualitymayhem.entity.custom.DraupnirProjectileEntity;

public class DraupnirProjectileModel extends EntityModel<DraupnirProjectileEntity> {
    public static final EntityModelLayer DRAUPNIR = new EntityModelLayer(Identifier.of(QualityMayhem.MOD_ID, "draupnir"), "main");
    private final ModelPart draupnir;
    public DraupnirProjectileModel(ModelPart root) {
        this.draupnir = root.getChild("draupnir");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData draupnir = modelPartData.addChild("draupnir", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -1.0F, -4.0F, 1.0F, 1.0F, 36.0F, new Dilation(0.0F))
                .uv(0, 37).cuboid(-8.0F, -1.0F, -4.0F, 1.0F, 0.0F, 36.0F, new Dilation(0.0F))
                .uv(54, 73).cuboid(-8.5F, -1.5F, -3.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(60, 73).cuboid(-8.5F, -1.5F, 30.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(16, 73).cuboid(-9.0F, -1.0F, -9.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(44, 73).cuboid(-8.0F, -1.0F, -13.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 24.0F, -8.0F));

        ModelPartData cube_r1 = draupnir.addChild("cube_r1", ModelPartBuilder.create().uv(32, 73).cuboid(-2.9755F, -2.7075F, -6.75F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-7.4569F, -0.5777F, 9.75F, 0.0F, 0.0F, 0.7854F));

        ModelPartData cube_r2 = draupnir.addChild("cube_r2", ModelPartBuilder.create().uv(0, 73).cuboid(-3.6633F, -3.6824F, -9.75F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-7.4569F, -0.5777F, 9.75F, 0.0F, 0.0F, 0.3927F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(DraupnirProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        draupnir.render(matrices, vertexConsumer, light, overlay, color);
    }
}
