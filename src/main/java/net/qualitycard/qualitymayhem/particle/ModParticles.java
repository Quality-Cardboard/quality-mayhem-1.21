package net.qualitycard.qualitymayhem.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;

public class ModParticles {
    public static final SimpleParticleType ATOMIC_BLAST_EXPLOSION_PARTICLE =
            registerParticle("atomic_blast_explosion_particle", FabricParticleTypes.simple());

    public static final SimpleParticleType LIGHT_PARTICLE =
            registerParticle("light_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(QualityMayhem.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        QualityMayhem.LOGGER.info("Registering Particles for " + QualityMayhem.MOD_ID);
    }
}
