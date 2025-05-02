package net.qualitycard.qualitymayhem.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup QUALITY_MAYHEM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(QualityMayhem.MOD_ID, "quality_mayhem_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.COBALT))
                    .displayName(Text.translatable("itemgroup.qualitymayhem.quality_mayhem_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.INFERNAL_INGOT);
                        entries.add(ModItems.RAW_COBALT);
                        entries.add(ModItems.COBALT);
                        entries.add(ModItems.TOPAZ);
                        entries.add(ModItems.ATHIUM);
                        entries.add(ModItems.BLOOD_OF_THE_GODS);
                        entries.add(ModItems.HEART_OF_THE_NETHER);
                        entries.add(ModItems.HEAVEN_PIERCER_HANDLE);
                        entries.add(ModItems.HEAVEN_PIERCER_CROSS_GUARD);
                        entries.add(ModItems.HEAVEN_PIERCER_BLADE);
                        entries.add(ModItems.GILDED_CLAYMORE_HANDLE);
                        entries.add(ModItems.GILDED_CLAYMORE_CROSS_GUARD);
                        entries.add(ModItems.GILDED_CLAYMORE_BLADE);
                        entries.add(ModItems.HEAT_CORE);

                        entries.add(ModItems.CHISEL);

                        entries.add(ModItems.RICE);
                        entries.add(ModItems.EGG_FRIED_RICE);
                        entries.add(ModItems.APPLE_PIE);
                        entries.add(ModItems.COOKED_BEEF_SANDWICH);
                        entries.add(ModItems.CHIPS);
                        entries.add(ModItems.FLAVOURED_ROCKS);

                        entries.add(ModItems.APPLE_JUICE);
                        entries.add(ModItems.ALCOHOL);
                        entries.add(ModItems.SODA);

                        entries.add(ModItems.COBALT_SWORD);
                        entries.add(ModItems.COBALT_PICKAXE);
                        entries.add(ModItems.COBALT_SHOVEL);
                        entries.add(ModItems.COBALT_AXE);
                        entries.add(ModItems.COBALT_HOE);
                        entries.add(ModItems.COBALT_HAMMER);

                        entries.add(ModItems.COBALT_HELMET);
                        entries.add(ModItems.COBALT_CHESTPLATE);
                        entries.add(ModItems.COBALT_LEGGINGS);
                        entries.add(ModItems.COBALT_BOOTS);

                        entries.add(ModItems.COBALT_HORSE_ARMOR);

                        entries.add(ModItems.HEAVEN_PIERCER);
                        entries.add(ModItems.GILDED_CLAYMORE);
                        entries.add(ModItems.BLAZING_SABRE);
                        entries.add(ModItems.MANGLED_DAGGER);
                        entries.add(ModItems.LUNAR_SOAKED_DIRK);
                        entries.add(ModItems.OCCULT_KATANA);
                        entries.add(ModItems.ETHEREAL_FLARE);

                        entries.add(ModItems.ATOMIC_BLAST);

                        entries.add(ModItems.SCUTTER_BUG_SPAWN_EGG);

                        entries.add(ModItems.RICK_ROLL_MUSIC_DISC);


                    })
                    .build()
    );

    public static final ItemGroup QUALITY_MAYHEM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(QualityMayhem.MOD_ID, "quality_mayhem_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.COBALT_BLOCK))
                    .displayName(Text.translatable("itemgroup.qualitymayhem.quality_mayhem_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.INFERNAL_INGOT_BLOCK);
                        entries.add(ModBlocks.COBALT_ORE);
                        entries.add(ModBlocks.DEEPSLATE_COBALT_ORE);
                        entries.add(ModBlocks.TOPAZ_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TOPAZ_ORE);

                        entries.add(ModBlocks.DUSK_BLOCK);

                        entries.add(ModBlocks.RAW_COBALT_BLOCK);
                        entries.add(ModBlocks.COBALT_BLOCK);

                        entries.add(ModBlocks.COBALT_STAIRS);
                        entries.add(ModBlocks.COBALT_SLAB);
                        entries.add(ModBlocks.COBALT_BUTTON);
                        entries.add(ModBlocks.COBALT_PRESSURE_PLATE);
                        entries.add(ModBlocks.COBALT_FENCE);
                        entries.add(ModBlocks.COBALT_FENCE_GATE);
                        entries.add(ModBlocks.COBALT_WALL);
                        entries.add(ModBlocks.COBALT_DOOR);
                        entries.add(ModBlocks.COBALT_TRAPDOOR);

                        entries.add(ModBlocks.SELF_LIT_REDSTONE_LAMP);

                        entries.add(ModBlocks.TRANSMUTATOR_BLOCK);

                    })
                    .build()
    );



    // Method / Function For Registering Mod Item Groups
    public static void registerItemGroups() {
        // Says that its "Registering Mod Item Groups for MOD_ID"
        QualityMayhem.LOGGER.info("Registering Mod Item Groups for " + QualityMayhem.MOD_ID);
    }
}
