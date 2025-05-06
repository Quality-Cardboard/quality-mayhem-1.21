package net.qualitycard.qualitymayhem.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.qualitycard.qualitymayhem.entity.ModEntities;

public class ModEntitiesSpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK, BiomeKeys.LUSH_CAVES, BiomeKeys.DRIPSTONE_CAVES,
                        BiomeKeys.FROZEN_PEAKS, BiomeKeys.JAGGED_PEAKS, BiomeKeys.STONY_PEAKS),

                SpawnGroup.CREATURE, ModEntities.SCUTTER_BUG, 99, 2,5);

        SpawnRestriction.register(ModEntities.SCUTTER_BUG, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
