package net.qualitycard.qualitymayhem.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.entity.custom.ScutterBugEntity;

public class ScutterBugRenderer extends MobEntityRenderer<ScutterBugEntity, ScutterBugModel<ScutterBugEntity>> {
    public ScutterBugRenderer(EntityRendererFactory.Context context) {
        super(context, new ScutterBugModel<>(context.getPart(ScutterBugModel.SCUTTER_BUG)), 0.20f);
    }

    @Override
    public Identifier getTexture(ScutterBugEntity entity) {
        return Identifier.of(QualityMayhem.MOD_ID, "textures/entity/scutter_bug/scutter_bug.png");
    }

    @Override
    public void render(ScutterBugEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
