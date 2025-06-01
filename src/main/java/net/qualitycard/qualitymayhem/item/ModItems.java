package net.qualitycard.qualitymayhem.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.entity.ModEntities;
import net.qualitycard.qualitymayhem.item.custom.*;
import net.qualitycard.qualitymayhem.sound.ModSounds;

import java.util.List;

public class ModItems {

    // Adds the actual Mod Items and their settings (Ex. Rarity, Lava-proof etc.)
    public static final Item INFERNAL_INGOT = registerItem("infernal_ingot", new Item(new Item.Settings()));
    public static final Item COBALT = registerItem("cobalt", new Item(new Item.Settings()));
    public static final Item RAW_COBALT = registerItem("raw_cobalt", new Item(new Item.Settings()));
    public static final Item TOPAZ = registerItem("topaz", new Item(new Item.Settings()));
    public static final Item ATHIUM = registerItem("athium", new Item(new Item.Settings()));
    public static final Item CONQUERORS_ALLOY = registerItem("conquerors_alloy", new Item(new Item.Settings()));
    public static final Item BLOOD_OF_THE_GODS = registerItem("blood_of_the_gods", new Item(new Item.Settings().fireproof()));
    public static final Item HEART_OF_THE_NETHER = registerItem("heart_of_the_nether", new Item(new Item.Settings().fireproof()));
    public static final Item HEAVEN_PIERCER_HANDLE = registerItem("heaven_piercer_handle", new Item(new Item.Settings().fireproof()));
    public static final Item HEAVEN_PIERCER_CROSS_GUARD = registerItem("heaven_piercer_cross_guard", new Item(new Item.Settings().fireproof()));
    public static final Item HEAVEN_PIERCER_BLADE = registerItem("heaven_piercer_blade", new Item(new Item.Settings().fireproof()));
    public static final Item GILDED_CLAYMORE_HANDLE = registerItem("gilded_claymore_handle", new Item(new Item.Settings().fireproof()));
    public static final Item GILDED_CLAYMORE_CROSS_GUARD = registerItem("gilded_claymore_cross_guard", new Item(new Item.Settings().fireproof()));
    public static final Item GILDED_CLAYMORE_BLADE = registerItem("gilded_claymore_blade", new Item(new Item.Settings().fireproof()));

    // Adds the Mod weapons and tools
    public static final Item COBALT_SWORD = registerItem("cobalt_sword",
            new SwordItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COBALT, 3 ,-2.4f))));

    public static final Item COBALT_PICKAXE = registerItem("cobalt_pickaxe",
            new PickaxeItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COBALT, 1 ,-2.0f))));

    public static final Item COBALT_SHOVEL = registerItem("cobalt_shovel",
            new ShovelItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COBALT, 1.5f ,-3.0f))));

    public static final Item COBALT_AXE = registerItem("cobalt_axe",
            new AxeItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COBALT, 6 ,-3.2f))));

    public static final Item COBALT_HOE = registerItem("cobalt_hoe",
            new HoeItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COBALT, 0 ,-3.0f))));

    public static final Item COBALT_HAMMER = registerItem("cobalt_hammer",
            new HammerItem(ModToolMaterials.COBALT, new Item.Settings()
                    .attributeModifiers(HammerItem.createAttributeModifiers(ModToolMaterials.COBALT, 7 ,-3.4f))));


    public static final Item HEAVEN_PIERCER = registerItem("heaven_piercer",
            new HeavenPiercerItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5 ,-2.4f)).fireproof().rarity(Rarity.EPIC)));
    public static final Item GILDED_CLAYMORE = registerItem("gilded_claymore",
            new GildedClaymoreItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5 ,-2.4f)).fireproof().rarity(Rarity.EPIC)));
    public static final Item FALSE_SUN = registerItem("false_sun",
            new FalseSunItem(new Item.Settings().maxDamage(500)));


    public static final Item BLAZING_SABRE = registerItem("blazing_sabre",
            new BlazingSabre(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -2.4f)).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item MANGLED_DAGGER = registerItem("mangled_dagger",
            new SwordItem(ToolMaterials.WOOD, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 1, -2.4f))));
    public static final Item LUNAR_SOAKED_DIRK = registerItem("lunar_soaked_dirk",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.4f))));
    public static final Item OCCULT_KATANA = registerItem("occult_katana",
            new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item ETHEREAL_FLARE = registerItem("ethereal_flare",
            new EtherealFlareItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 3, -2.4f)).fireproof().rarity(Rarity.RARE)));

    public static final Item ATOMIC_BLAST = registerItem("atomic_blast",
            new AtomicBlastItem(new Item.Settings().maxCount(16)));

    public static final Item COBALT_HELMET = registerItem("cobalt_helmet",
            new ModArmorItem(ModArmorMaterials.COBALT_ARMOR_MATERIAl, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(33))));
    public static final Item COBALT_LEGGINGS = registerItem("cobalt_leggings",
            new ArmorItem(ModArmorMaterials.COBALT_ARMOR_MATERIAl, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(33))));
    public static final Item COBALT_CHESTPLATE = registerItem("cobalt_chestplate",
            new ArmorItem(ModArmorMaterials.COBALT_ARMOR_MATERIAl, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(33))));
    public static final Item COBALT_BOOTS = registerItem("cobalt_boots",
            new ArmorItem(ModArmorMaterials.COBALT_ARMOR_MATERIAl, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(33))));

    public static final Item CONQUERORS_MASK = registerItem("conquerors_mask",
            new ModArmorItem(ModArmorMaterials.CONQUERORS_ARMOR_MATERIAl, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(66))));
    public static final Item CONQUERORS_LEGGINGS = registerItem("conquerors_leggings",
            new ArmorItem(ModArmorMaterials.CONQUERORS_ARMOR_MATERIAl, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(66))));
    public static final Item CONQUERORS_CHESTPLATE = registerItem("conquerors_chestplate",
            new ArmorItem(ModArmorMaterials.CONQUERORS_ARMOR_MATERIAl, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(66))));
    public static final Item CONQUERORS_BOOTS = registerItem("conquerors_boots",
            new ArmorItem(ModArmorMaterials.CONQUERORS_ARMOR_MATERIAl, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(66))));

    public static final Item COBALT_HORSE_ARMOR = registerItem("cobalt_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.COBALT_ARMOR_MATERIAl, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(128)));

    // Item Foods
    public static final Item RICE = registerItem("rice", new Item(new Item.Settings().food(ModFoodComponents.RICE).maxCount(16)));
    public static final Item EGG_FRIED_RICE = registerItem("egg_fried_rice", new Item(new Item.Settings().food(ModFoodComponents.EGG_FRIED_RICE).maxCount(16)));
    public static final Item APPLE_PIE = registerItem("apple_pie", new Item(new Item.Settings().food(ModFoodComponents.APPLE_PIE)));
    public static final Item COOKED_BEEF_SANDWICH = registerItem("cooked_beef_sandwich", new Item(new Item.Settings().food(ModFoodComponents.COOKED_BEEF_SANDWICH)));
    public static final Item CHIPS = registerItem("chips", new Item(new Item.Settings().food(ModFoodComponents.CHIPS)));
    public static final Item FLAVOURED_ROCKS = registerItem("flavoured_rocks", new FlavouredRocksItem(new Item.Settings().food(ModFoodComponents.FLAVOURED_ROCKS)));

    // Item Drinks
    public static final Item APPLE_JUICE = registerItem("apple_juice", new AppleJuiceItem(new Item.Settings().food(ModFoodComponents.APPLE_JUICE)));
    public static final Item ALCOHOL = registerItem("alcohol", new AlcoholItem(new Item.Settings().food(ModFoodComponents.ALCOHOL)));
    public static final Item SODA = registerItem("soda", new SodaItem(new Item.Settings().food(ModFoodComponents.SODA)));

    // Spawn Eggs
    public static final Item SCUTTER_BUG_SPAWN_EGG = registerItem("scutter_bug_spawn_egg",
            new SpawnEggItem(ModEntities.SCUTTER_BUG, 0x151515, 0xbdbdbd, new Item.Settings()));

    // Music Discs
    public static final Item RICK_ROLL_MUSIC_DISC = registerItem("rick_roll_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.RICK_ROLL_KEY).maxCount(1)));

    // Item Fuels (Ex. Coal, Oak Planks, Blaze Rods etc)
    public static final Item HEAT_CORE = registerItem("heat_core", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.qualitymayhem.heat_core"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });


    // Returns the Name of the item and the Item
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(QualityMayhem.MOD_ID, name), item);
    }

    // Method / Function For Registering Mod Items
    public static void registerModItems() {
        // Says that its "Registering Mod Items for MOD_ID"
        QualityMayhem.LOGGER.info("Registering Mod Items for " + QualityMayhem.MOD_ID);

        // Adds the Mod Items to an Item Group (Ingredients)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(INFERNAL_INGOT);
            entries.add(COBALT);
            entries.add(RAW_COBALT);
            entries.add(TOPAZ);
            entries.add(ATHIUM);
            entries.add(BLOOD_OF_THE_GODS);
            entries.add(HEART_OF_THE_NETHER);
            entries.add(HEAVEN_PIERCER_HANDLE);
            entries.add(HEAVEN_PIERCER_CROSS_GUARD);
            entries.add(HEAVEN_PIERCER_BLADE);
            entries.add(GILDED_CLAYMORE_HANDLE);
            entries.add(GILDED_CLAYMORE_CROSS_GUARD);
            entries.add(GILDED_CLAYMORE_BLADE);
            entries.add(HEAT_CORE);
        });

        // Adds the Mod Items to an Item Group (Functional)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CHISEL);
            entries.add(COBALT_PICKAXE);
            entries.add(COBALT_SHOVEL);
            entries.add(COBALT_AXE);
            entries.add(COBALT_HOE);
            entries.add(COBALT_HAMMER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(COBALT_HELMET);
            entries.add(COBALT_CHESTPLATE);
            entries.add(COBALT_LEGGINGS);
            entries.add(COBALT_BOOTS);
            entries.add(COBALT_HORSE_ARMOR);

            entries.add(FALSE_SUN);

            entries.add(COBALT_SWORD);
            entries.add(HEAVEN_PIERCER);
            entries.add(GILDED_CLAYMORE);
            entries.add(BLAZING_SABRE);
            entries.add(MANGLED_DAGGER);
            entries.add(LUNAR_SOAKED_DIRK);
            entries.add(OCCULT_KATANA);
            entries.add(ETHEREAL_FLARE);

            entries.add(ATOMIC_BLAST);
        });


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(RICE);
            entries.add(EGG_FRIED_RICE);
            entries.add(APPLE_PIE);
            entries.add(COOKED_BEEF_SANDWICH);
            entries.add(CHIPS);
            entries.add(FLAVOURED_ROCKS);
            entries.add(APPLE_JUICE);
            entries.add(SODA);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(SCUTTER_BUG_SPAWN_EGG);
            entries.add(ATHIUM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(RICK_ROLL_MUSIC_DISC);
            entries.add(ATHIUM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(CONQUERORS_MASK);
            entries.add(CONQUERORS_CHESTPLATE);
            entries.add(CONQUERORS_LEGGINGS);
            entries.add(CONQUERORS_BOOTS);
            entries.add(CONQUERORS_ALLOY);
        });

    }
}
