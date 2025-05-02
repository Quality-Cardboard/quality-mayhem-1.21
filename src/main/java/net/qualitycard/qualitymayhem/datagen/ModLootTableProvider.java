package net.qualitycard.qualitymayhem.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.qualitycard.qualitymayhem.block.ModBlocks;
import net.qualitycard.qualitymayhem.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.COBALT_BLOCK);
        addDrop(ModBlocks.RAW_COBALT_BLOCK);
        addDrop(ModBlocks.INFERNAL_INGOT_BLOCK);
        addDrop(ModBlocks.TRANSMUTATOR_BLOCK);

        addDrop(ModBlocks.COBALT_ORE, oreDrops(ModBlocks.COBALT_ORE, ModItems.RAW_COBALT));
        addDrop(ModBlocks.DEEPSLATE_COBALT_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_COBALT_ORE, ModItems.RAW_COBALT, 3, 7));
        addDrop(ModBlocks.TOPAZ_ORE, oreDrops(ModBlocks.TOPAZ_ORE, ModItems.TOPAZ));
        addDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_TOPAZ_ORE, ModItems.TOPAZ, 1, 2));

        addDrop(ModBlocks.COBALT_STAIRS);
        addDrop(ModBlocks.COBALT_SLAB, slabDrops(ModBlocks.COBALT_SLAB));
        addDrop(ModBlocks.COBALT_BUTTON);
        addDrop(ModBlocks.COBALT_PRESSURE_PLATE);
        addDrop(ModBlocks.COBALT_FENCE);
        addDrop(ModBlocks.COBALT_FENCE_GATE);
        addDrop(ModBlocks.COBALT_WALL);
        addDrop(ModBlocks.COBALT_DOOR, doorDrops(ModBlocks.COBALT_DOOR));
        addDrop(ModBlocks.COBALT_TRAPDOOR);

        addDrop(ModBlocks.SELF_LIT_REDSTONE_LAMP);

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
