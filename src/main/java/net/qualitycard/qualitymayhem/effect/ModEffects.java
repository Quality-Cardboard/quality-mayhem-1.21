package net.qualitycard.qualitymayhem.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> CATASTROPHE = registerStatusEffect("catastrophe",
            new CatastropheEffect(StatusEffectCategory.NEUTRAL, 0xFF0000)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            Identifier.of(QualityMayhem.MOD_ID, "catastrophe"), 0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(QualityMayhem.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        QualityMayhem.LOGGER.info("Registering Mod Effects for " + QualityMayhem.MOD_ID);
    }
}
