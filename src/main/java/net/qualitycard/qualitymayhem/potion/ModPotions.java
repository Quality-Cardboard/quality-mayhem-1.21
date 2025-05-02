package net.qualitycard.qualitymayhem.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.effect.ModEffects;

public class ModPotions {

    public static final RegistryEntry<Potion> CATASTROPHE_POTION = registerPotion("catastrophe_potion",
            new Potion(new StatusEffectInstance(ModEffects.CATASTROPHE, 1200, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(QualityMayhem.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        QualityMayhem.LOGGER.info("Registering Mod Potions for " + QualityMayhem.MOD_ID);
    }
}
