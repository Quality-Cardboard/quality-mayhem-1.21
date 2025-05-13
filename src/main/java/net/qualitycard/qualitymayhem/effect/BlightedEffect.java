package net.qualitycard.qualitymayhem.effect;

import net.minecraft.client.gui.screen.Overlay;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.Identifier;

import java.util.Random;

public class BlightedEffect extends StatusEffect {
    protected BlightedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        Random random = new Random();
        int min = -1; // Minimum value (inclusive)
        int max = 1;  // Maximum value (inclusive)

        // Generate a random number for x and z tilt screen
        int x = random.nextInt(max - min + 1) + min;
        int z = random.nextInt(max - min + 1) + min;
        entity.tiltScreen(x,z);

        return true;
    }

    @Override
    public StatusEffect addAttributeModifier(RegistryEntry<EntityAttribute> attribute, Identifier id, double amount, EntityAttributeModifier.Operation operation) {
        return super.addAttributeModifier(attribute, id, amount, operation);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
