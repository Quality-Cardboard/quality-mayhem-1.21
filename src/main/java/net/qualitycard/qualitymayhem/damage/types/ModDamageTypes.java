package net.qualitycard.qualitymayhem.damage.types;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.qualitycard.qualitymayhem.QualityMayhem;

public class ModDamageTypes {
    /*
     * Store the RegistryKey of our DamageType into a new constant called CUSTOM_DAMAGE_TYPE
     * The Identifier in use here points to our JSON file we created earlier.
     */
    public static final RegistryKey<DamageType> ATOMIC_BLAST_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("qualitymayhem", "atomic_blast"));
    public static final RegistryKey<DamageType> LIGHT_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("qualitymayhem", "light"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }

    public static void registerDamageTypes() {
        QualityMayhem.LOGGER.info("Registering Mod Damage Types for " + QualityMayhem.MOD_ID);
    }
}
