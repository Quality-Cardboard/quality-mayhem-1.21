package net.qualitycard.qualitymayhem.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.block.custom.SelfLitRedstoneLampBlock;
import net.qualitycard.qualitymayhem.block.custom.TransmutatorBlock;
import net.qualitycard.qualitymayhem.sound.ModSounds;

public class ModBlocks {

    // Making the new Mod Blocks
    public static final Block INFERNAL_INGOT_BLOCK = registerBlock("infernal_ingot_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS).sounds(ModSounds.INFERNAL_INGOT_BLOCK_SOUNDS)));


    public static final Block COBALT_ORE = registerBlock("cobalt_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()
                            .sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(4f).requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block TOPAZ_ORE = registerBlock("topaz_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()
                            .sounds(BlockSoundGroup.NETHER_GOLD_ORE)));

    public static final Block DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool()
                            .sounds(BlockSoundGroup.NETHER_GOLD_ORE)));

    public static final Block DUSK_BLOCK = registerBlock("dusk_block",
            new Block(AbstractBlock.Settings.create().strength(999f, 999f).sounds(BlockSoundGroup.HONEY)));


    public static final Block RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block COBALT_BLOCK = registerBlock("cobalt_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block COBALT_STAIRS = registerBlock("cobalt_stairs",
            new StairsBlock(ModBlocks.COBALT_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block COBALT_SLAB = registerBlock("cobalt_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block COBALT_BUTTON = registerBlock("cobalt_button",
            new ButtonBlock(BlockSetType.COPPER, 3, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block COBALT_PRESSURE_PLATE = registerBlock("cobalt_pressure_plate",
            new PressurePlateBlock(BlockSetType.COPPER, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block COBALT_FENCE = registerBlock("cobalt_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block COBALT_FENCE_GATE = registerBlock("cobalt_fence_gate",
            new FenceGateBlock(WoodType.WARPED, AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block COBALT_WALL = registerBlock("cobalt_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block COBALT_DOOR = registerBlock("cobalt_door",
            new DoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block COBALT_TRAPDOOR = registerBlock("cobalt_trapdoor",
            new TrapdoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block SELF_LIT_REDSTONE_LAMP = registerBlock("self_lit_redstone_lamp",
            new SelfLitRedstoneLampBlock(AbstractBlock.Settings.create()
                    .strength(1f).requiresTool().luminance(state -> state.get(SelfLitRedstoneLampBlock.CLICKED) ? 15 : 0)));


    // Custom Blocks
    public static final Block TRANSMUTATOR_BLOCK = registerBlock("transmutator_block",
            new TransmutatorBlock(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));





    // Registers the block and runs the registerBlockItem Method / Function
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(QualityMayhem.MOD_ID, name), block);
    }

    // Registering the Item part of the Block (Ex. When it's in your inventory or dropped)
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(QualityMayhem.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    // Method / Function For Registering Mod Blocks
    public static void registerModBlocks() {
        // Says that its "Registering Mod Blocks for MOD_ID"
        QualityMayhem.LOGGER.info("Registering Mod Blocks for " + QualityMayhem.MOD_ID);

        // Adds the Mod Items to an Item Group (Building Blocks)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(INFERNAL_INGOT_BLOCK);

            entries.add(COBALT_ORE);
            entries.add(DEEPSLATE_COBALT_ORE);
            entries.add(TOPAZ_ORE);
            entries.add(DEEPSLATE_TOPAZ_ORE);

            entries.add(RAW_COBALT_BLOCK);
            entries.add(COBALT_BLOCK);

            entries.add(DUSK_BLOCK);

        });

        // Adds the Mod Items to an Item Group (Functional Blocks)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(TRANSMUTATOR_BLOCK);
        });
    }
}
