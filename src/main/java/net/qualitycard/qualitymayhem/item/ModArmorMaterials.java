package net.qualitycard.qualitymayhem.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.qualitycard.qualitymayhem.QualityMayhem;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> COBALT_ARMOR_MATERIAl = registerArmorMaterial("cobalt",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }), 20, SoundEvents. ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.COBALT)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(QualityMayhem.MOD_ID, "cobalt"))), 3.0f,0.0f));

    public static final RegistryEntry<ArmorMaterial> CONQUERORS_ARMOR_MATERIAl = registerArmorMaterial("conquerors",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 20, SoundEvents. ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.CONQUERORS_ALLOY)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(QualityMayhem.MOD_ID, "conquerors"))), 3.1f, 0.15f));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(QualityMayhem.MOD_ID, name), material.get());
    }
}
