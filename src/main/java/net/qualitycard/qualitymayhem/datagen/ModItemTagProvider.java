package net.qualitycard.qualitymayhem.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.qualitycard.qualitymayhem.item.ModItems;
import net.qualitycard.qualitymayhem.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.RAW_COBALT)
                .add(Items.GOLD_INGOT)
                .add(Items.IRON_INGOT)
                .add(Items.COAL);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.COBALT_SWORD)
                .add(ModItems.HEAVEN_PIERCER)
                .add(ModItems.GILDED_CLAYMORE)
                .add(ModItems.BLAZING_SABRE)
                .add(ModItems.MANGLED_DAGGER)
                .add(ModItems.LUNAR_SOAKED_DIRK)
                .add(ModItems.OCCULT_KATANA)
                .add(ModItems.ETHEREAL_FLARE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.COBALT_PICKAXE)
                .add(ModItems.COBALT_HAMMER);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.COBALT_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.COBALT_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.COBALT_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COBALT_HELMET)
                .add(ModItems.COBALT_CHESTPLATE)
                .add(ModItems.COBALT_LEGGINGS)
                .add(ModItems.COBALT_BOOTS);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.COBALT_HELMET)
                .add(ModItems.COBALT_CHESTPLATE)
                .add(ModItems.COBALT_LEGGINGS)
                .add(ModItems.COBALT_BOOTS);

    }
}
