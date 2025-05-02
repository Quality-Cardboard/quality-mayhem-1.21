package net.qualitycard.qualitymayhem.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.entity.custom.ScutterBugEntity;

public class ScutterBugModel <T extends ScutterBugEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer SCUTTER_BUG = new EntityModelLayer(Identifier.of(QualityMayhem.MOD_ID, "scutter_bug"), "main");
    private final ModelPart root;
    private final ModelPart scutter_bug;
    private final ModelPart head;
    public ScutterBugModel(ModelPart root) {
        this.root = root.getChild("root");
        this.scutter_bug = this.root.getChild("scutter_bug");
        this.head = this.scutter_bug.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 22.0F, 0.0F));

        ModelPartData scutter_bug = root.addChild("scutter_bug", ModelPartBuilder.create().uv(6, 13).cuboid(-2.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(10, 13).cuboid(-1.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(14, 13).cuboid(1.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 1.0F, 0.0F));

        ModelPartData body = scutter_bug.addChild("body", ModelPartBuilder.create().uv(0, 13).cuboid(-1.0F, -1.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = scutter_bug.addChild("head", ModelPartBuilder.create().uv(12, 11).cuboid(-1.0F, -3.1F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, -3.0F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(12, 8).cuboid(-0.5F, -0.1F, -1.5F, 0.5F, 0.0F, 3.0F, new Dilation(0.0F))
                .uv(12, 5).cuboid(-2.0F, -0.1F, -1.5F, 0.5F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -3.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData F1 = scutter_bug.addChild("F1", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, 0.0F, -1.0F));

        ModelPartData cube_r2 = F1.addChild("cube_r2", ModelPartBuilder.create().uv(6, 15).cuboid(-1.0F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData F2 = scutter_bug.addChild("F2", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 0.0F, -2.0F));

        ModelPartData cube_r3 = F2.addChild("cube_r3", ModelPartBuilder.create().uv(4, 15).cuboid(1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData M1 = scutter_bug.addChild("M1", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

        ModelPartData cube_r4 = M1.addChild("cube_r4", ModelPartBuilder.create().uv(8, 15).cuboid(-1.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData M2 = scutter_bug.addChild("M2", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

        ModelPartData cube_r5 = M2.addChild("cube_r5", ModelPartBuilder.create().uv(2, 15).cuboid(1.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData B1 = scutter_bug.addChild("B1", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, 0.0F, 2.0F));

        ModelPartData cube_r6 = B1.addChild("cube_r6", ModelPartBuilder.create().uv(10, 15).cuboid(-1.0F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData B2 = scutter_bug.addChild("B2", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, 0.0F, 2.0F));

        ModelPartData cube_r7 = B2.addChild("cube_r7", ModelPartBuilder.create().uv(0, 15).cuboid(1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.7854F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(ScutterBugEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ScutterBugAnimations.ANIM_SCUTTER_BUG_WALK, limbSwing, limbSwingAmount, 2.0f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ScutterBugAnimations.ANIM_SCUTTER_BUG_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}
