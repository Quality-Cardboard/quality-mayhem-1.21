package net.qualitycard.qualitymayhem.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.qualitycard.qualitymayhem.item.ModItems;

public class CatastropheEffect extends StatusEffect {
    public CatastropheEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getHealth() > 1.0F) {
            if (entity.getMainHandStack().getItem() != ModItems.HEAVEN_PIERCER) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20, 3));
            } else if (entity.getMainHandStack().getItem() == ModItems.HEAVEN_PIERCER) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20, 3));
            }
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
