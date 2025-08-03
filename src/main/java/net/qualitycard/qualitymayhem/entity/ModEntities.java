package net.qualitycard.qualitymayhem.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.entity.custom.AtomicBlastProjectileEntity;
import net.qualitycard.qualitymayhem.entity.custom.DraupnirProjectileEntity;
import net.qualitycard.qualitymayhem.entity.custom.ScutterBugEntity;

public class ModEntities {
    public static final EntityType<ScutterBugEntity> SCUTTER_BUG = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(QualityMayhem.MOD_ID, "scutter_bug"),
            EntityType.Builder.create(ScutterBugEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.5f, 0.2f).build());

    public static final EntityType<AtomicBlastProjectileEntity> ATOMIC_BLAST = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(QualityMayhem.MOD_ID, "atomic_blast"),
            EntityType.Builder.<AtomicBlastProjectileEntity>create(AtomicBlastProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(4f, 0.5f).build());

    public static final EntityType<DraupnirProjectileEntity> DRAUPNIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(QualityMayhem.MOD_ID, "draupnir"),
            EntityType.Builder.<DraupnirProjectileEntity>create(DraupnirProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f).build());


    public static void registerModEntities() {
        QualityMayhem.LOGGER.info("Registering Mod Entities for " + QualityMayhem.MOD_ID);
    }
}
