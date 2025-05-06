package net.qualitycard.qualitymayhem.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.entity.custom.ScutterBugEntity;
import net.qualitycard.qualitymayhem.entity.custom.ScutterBugVariant;

import java.util.Map;

public class ScutterBugRenderer extends MobEntityRenderer<ScutterBugEntity, ScutterBugModel<ScutterBugEntity>> {
    private static final Map<ScutterBugVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ScutterBugVariant.class), map -> {
                map.put(ScutterBugVariant.DEFAULT,
                        Identifier.of(QualityMayhem.MOD_ID, "textures/entity/scutter_bug/scutter_bug.png"));
                map.put(ScutterBugVariant.MOSSY,
                        Identifier.of(QualityMayhem.MOD_ID, "textures/entity/scutter_bug/scutter_bug_mossy.png"));
                map.put(ScutterBugVariant.DEEP,
                        Identifier.of(QualityMayhem.MOD_ID, "textures/entity/scutter_bug/scutter_bug_deep.png"));
            });

    public ScutterBugRenderer(EntityRendererFactory.Context context) {
        super(context, new ScutterBugModel<>(context.getPart(ScutterBugModel.SCUTTER_BUG)), 0.20f);
    }

    @Override
    public Identifier getTexture(ScutterBugEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
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
