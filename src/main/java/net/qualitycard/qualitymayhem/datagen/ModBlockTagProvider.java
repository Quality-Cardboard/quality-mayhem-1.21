package net.qualitycard.qualitymayhem.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.qualitycard.qualitymayhem.block.ModBlocks;
import net.qualitycard.qualitymayhem.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.COBALT_BLOCK)
                .add(ModBlocks.RAW_COBALT_BLOCK)
                .add(ModBlocks.COBALT_ORE)
                .add(ModBlocks.DEEPSLATE_COBALT_ORE)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
                .add(ModBlocks.COBALT_STAIRS)
                .add(ModBlocks.COBALT_SLAB)
                .add(ModBlocks.COBALT_BUTTON)
                .add(ModBlocks.COBALT_PRESSURE_PLATE)
                .add(ModBlocks.COBALT_FENCE)
                .add(ModBlocks.COBALT_FENCE_GATE)
                .add(ModBlocks.COBALT_WALL)
                .add(ModBlocks.COBALT_DOOR)
                .add(ModBlocks.COBALT_TRAPDOOR)
                .add(ModBlocks.INFERNAL_INGOT_BLOCK)
                .add(ModBlocks.TRANSMUTATOR_BLOCK);

        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.DUSK_BLOCK)
                .add(ModBlocks.TEST_PORTAL_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.COBALT_BLOCK)
                .add(ModBlocks.RAW_COBALT_BLOCK)
                .add(ModBlocks.COBALT_ORE)
                .add(ModBlocks.DEEPSLATE_COBALT_ORE)
                .add(ModBlocks.COBALT_STAIRS)
                .add(ModBlocks.COBALT_SLAB)
                .add(ModBlocks.COBALT_BUTTON)
                .add(ModBlocks.COBALT_PRESSURE_PLATE)
                .add(ModBlocks.COBALT_FENCE)
                .add(ModBlocks.COBALT_FENCE_GATE)
                .add(ModBlocks.COBALT_WALL)
                .add(ModBlocks.COBALT_DOOR)
                .add(ModBlocks.COBALT_TRAPDOOR)
                .add(ModBlocks.INFERNAL_INGOT_BLOCK)
                .add(ModBlocks.TRANSMUTATOR_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.COBALT_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.COBALT_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.COBALT_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_COBALT_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
