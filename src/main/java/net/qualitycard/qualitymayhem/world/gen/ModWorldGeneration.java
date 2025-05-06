package net.qualitycard.qualitymayhem.world.gen;

import net.qualitycard.qualitymayhem.entity.ModEntities;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        ModEntitiesSpawns.addSpawns();
    }

}
