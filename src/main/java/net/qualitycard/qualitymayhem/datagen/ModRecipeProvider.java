package net.qualitycard.qualitymayhem.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.block.ModBlocks;
import net.qualitycard.qualitymayhem.item.ModItems;
import net.qualitycard.qualitymayhem.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Lists for Smelting & Blasting
        List<ItemConvertible> COBALT_SMELTABLES = List.of(ModItems.RAW_COBALT, ModBlocks.COBALT_ORE, ModBlocks.DEEPSLATE_COBALT_ORE);

        // Mod Blocks Recipe

        // Reversible Recipe From Item to Block Ex. Iron Ingots to Iron Block & Iron Block to Iron Ingot
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_COBALT, RecipeCategory.DECORATIONS, ModBlocks.RAW_COBALT_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.COBALT, RecipeCategory.DECORATIONS, ModBlocks.COBALT_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.INFERNAL_INGOT, RecipeCategory.DECORATIONS, ModBlocks.INFERNAL_INGOT_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.INFERNAL_INGOT_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.INFERNAL_INGOT)
                .criterion(hasItem(ModItems.INFERNAL_INGOT), conditionsFromItem(ModItems.INFERNAL_INGOT))
                .offerTo(exporter ,Identifier.of(QualityMayhem.MOD_ID, "infernal_ingot_block_from_infernal_ingot"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INFERNAL_INGOT, 9)
                .input(ModBlocks.INFERNAL_INGOT_BLOCK)
                .criterion(hasItem(ModBlocks.INFERNAL_INGOT_BLOCK), conditionsFromItem(ModBlocks.INFERNAL_INGOT_BLOCK))
                .offerTo(exporter ,Identifier.of(QualityMayhem.MOD_ID, "infernal_ingot_from_infernal_ingot_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INFERNAL_INGOT, 1)
                .pattern("@#@")
                .pattern("$$$")
                .pattern("@#@")
                .input('#', Items.LAVA_BUCKET)
                .input('@', Items.GOLD_BLOCK)
                .input('$', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter ,Identifier.of(QualityMayhem.MOD_ID, "infernal_ingot_from_netherite"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ATHIUM, 2)
                .input(Items.DIAMOND)
                .input(Items.AMETHYST_SHARD)
                .input(ModItems.COBALT)
                .input(ModItems.TOPAZ)
                .criterion(hasItem(ModItems.TOPAZ), conditionsFromItem(ModItems.TOPAZ))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEAVEN_PIERCER_HANDLE, 1)
                .pattern(" &#")
                .pattern(" @&")
                .pattern("#  ")
                .input('#', ModItems.INFERNAL_INGOT)
                .input('@', Items.IRON_BLOCK)
                .input('&', Items.NETHERITE_SCRAP)
                .criterion(hasItem(ModItems.HEAVEN_PIERCER), conditionsFromItem(ModItems.HEAVEN_PIERCER))
                .offerTo(exporter);
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEAVEN_PIERCER_CROSS_GUARD, 1)
                .pattern("#&#")
                .pattern(" @&")
                .pattern("  #")
                .input('#', Items.GOLD_BLOCK)
                .input('@', Items.IRON_INGOT)
                .input('&', ModItems.INFERNAL_INGOT)
                .criterion(hasItem(ModItems.HEAVEN_PIERCER), conditionsFromItem(ModItems.HEAVEN_PIERCER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEAVEN_PIERCER_BLADE, 1)
                .pattern(" &#")
                .pattern("&@&")
                .pattern("#& ")
                .input('#', Items.REDSTONE_BLOCK)
                .input('@', ModItems.BLOOD_OF_THE_GODS)
                .input('&', ModItems.INFERNAL_INGOT)
                .criterion(hasItem(ModItems.HEAVEN_PIERCER), conditionsFromItem(ModItems.HEAVEN_PIERCER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GILDED_CLAYMORE_HANDLE, 1)
                .pattern(" &#")
                .pattern(" @&")
                .pattern("#  ")
                .input('#', ModItems.INFERNAL_INGOT)
                .input('@', Items.LAVA_BUCKET)
                .input('&', Items.NETHERITE_SCRAP)
                .criterion(hasItem(ModItems.GILDED_CLAYMORE), conditionsFromItem(ModItems.GILDED_CLAYMORE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GILDED_CLAYMORE_CROSS_GUARD, 1)
                .pattern("#&#")
                .pattern("  &")
                .pattern("  #")
                .input('#', ModItems.INFERNAL_INGOT)
                .input('&', Items.MAGMA_BLOCK)
                .criterion(hasItem(ModItems.GILDED_CLAYMORE), conditionsFromItem(ModItems.GILDED_CLAYMORE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GILDED_CLAYMORE_BLADE, 1)
                .pattern("&##")
                .pattern("#@#")
                .pattern("##&")
                .input('#', ModItems.INFERNAL_INGOT)
                .input('@', ModItems.HEART_OF_THE_NETHER)
                .input('&', Items.NETHERITE_SCRAP)
                .criterion(hasItem(ModItems.GILDED_CLAYMORE), conditionsFromItem(ModItems.GILDED_CLAYMORE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GILDED_CLAYMORE, 1)
                .pattern("  @")
                .pattern(" # ")
                .pattern("&  ")
                .input('@', ModItems.GILDED_CLAYMORE_BLADE)
                .input('#', ModItems.GILDED_CLAYMORE_CROSS_GUARD)
                .input('&', ModItems.GILDED_CLAYMORE_HANDLE)
                .criterion(hasItem(ModItems.GILDED_CLAYMORE), conditionsFromItem(ModItems.GILDED_CLAYMORE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEAVEN_PIERCER, 1)
                .pattern("  #")
                .pattern(" @ ")
                .pattern("&  ")
                .input('#', ModItems.HEAVEN_PIERCER_BLADE)
                .input('@', ModItems.HEAVEN_PIERCER_CROSS_GUARD)
                .input('&', ModItems.HEAVEN_PIERCER_HANDLE)
                .criterion(hasItem(ModItems.HEAVEN_PIERCER), conditionsFromItem(ModItems.HEAVEN_PIERCER))
                .offerTo(exporter);

        // Cobalt Blocks (Eg Stairs, Slabs, Buttons)
        createStairsRecipe(ModBlocks.COBALT_STAIRS, Ingredient.ofItems(ModItems.COBALT)).criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT)).offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBALT_SLAB, Ingredient.ofItems(ModItems.COBALT)).criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.COBALT_BUTTON, 1).input(ModItems.COBALT).criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT)).offerTo(exporter);
        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBALT_PRESSURE_PLATE, Ingredient.ofItems(ModItems.COBALT)).criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT)).offerTo(exporter);
        createFenceRecipe(ModBlocks.COBALT_FENCE, Ingredient.ofItems(ModItems.COBALT)).criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT)).offerTo(exporter);
        createFenceGateRecipe(ModBlocks.COBALT_FENCE_GATE, Ingredient.ofItems(ModItems.COBALT)).criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBALT_WALL, 6)
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.COBALT)
                .criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT))
                .offerTo(exporter);
        createDoorRecipe(ModBlocks.COBALT_DOOR, Ingredient.ofItems(ModItems.COBALT)).criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT)).offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.COBALT_TRAPDOOR, Ingredient.ofItems(ModItems.COBALT)).criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT)).offerTo(exporter);

        // Self lit Redstone Lamp
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.SELF_LIT_REDSTONE_LAMP, 1)
                .input(Items.REDSTONE_LAMP)
                .input(Items.LEVER)
                .criterion(hasItem(Items.REDSTONE_LAMP), conditionsFromItem(Items.REDSTONE_LAMP))
                .offerTo(exporter);


        // Mod Items Recipe

        // Smelting & Blasting Recipes for Mod Items
        offerSmelting(exporter, COBALT_SMELTABLES, RecipeCategory.MISC, ModItems.COBALT, 0.25f, 200, "cobalt");
        offerBlasting(exporter, COBALT_SMELTABLES, RecipeCategory.MISC, ModItems.COBALT, 0.25f, 100, "cobalt");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHISEL, 1)
                .input(Items.STICK)
                .input(Items.STICK)
                .input(Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HEAT_CORE, 1)
                .pattern("$#$")
                .pattern("###")
                .pattern("$#$")
                .input('$', Items.MAGMA_CREAM)
                .input('#', Items.MAGMA_BLOCK)
                .criterion(hasItem(Items.MAGMA_BLOCK), conditionsFromItem(Items.MAGMA_BLOCK))
                .offerTo(exporter);

        // Mod Food Items Recipes
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RICE, 4)
                .input(Items.WHEAT)
                .input(Items.BOWL)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.EGG_FRIED_RICE, 4)
                .input(ModItems.RICE)
                .input(Items.EGG)
                .criterion(hasItem(ModItems.RICE), conditionsFromItem(ModItems.RICE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.APPLE_PIE, 1)
                .input(Items.APPLE)
                .input(Items.EGG)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.RICE), conditionsFromItem(ModItems.RICE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.COOKED_BEEF_SANDWICH, 1)
                .input(Items.BREAD)
                .input(Items.BREAD)
                .input(Items.COOKED_BEEF)
                .criterion(hasItem(Items.COOKED_BEEF), conditionsFromItem(Items.COOKED_BEEF))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHIPS, 1)
                .input(Items.PAPER)
                .input(Items.BAKED_POTATO)
                .criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.FLAVOURED_ROCKS, 8)
                .input(Items.COBBLESTONE)
                .input(Items.REDSTONE)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);

        // Mod Drink Items Recipes
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.APPLE_JUICE, 1)
                .input(Items.APPLE)
                .input(Items.SUGAR)
                .input(Items.GLASS_BOTTLE)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ALCOHOL, 1)
                .input(Items.FERMENTED_SPIDER_EYE)
                .input(Items.SUGAR)
                .input(Items.GLASS_BOTTLE)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SODA, 1)
                .input(Items.SUGAR_CANE)
                .input(Items.BLACK_DYE)
                .input(Items.GLASS_BOTTLE)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .offerTo(exporter);





        // Mod Weapons and Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COBALT_SWORD, 1)
                .pattern("#")
                .pattern("#")
                .pattern("@")
                .input('#', ModItems.COBALT)
                .input('@', Items.STICK)
                .criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT))
                .offerTo(exporter, Identifier.of(QualityMayhem.MOD_ID, "cobalt_sword"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COBALT_PICKAXE, 1)
                .pattern("###")
                .pattern(" @ ")
                .pattern(" @ ")
                .input('#', ModItems.COBALT)
                .input('@', Items.STICK)
                .criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COBALT_SHOVEL, 1)
                .pattern("#")
                .pattern("@")
                .pattern("@")
                .input('#', ModItems.COBALT)
                .input('@', Items.STICK)
                .criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT))
                .offerTo(exporter, Identifier.of(QualityMayhem.MOD_ID, "cobalt_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COBALT_AXE, 1)
                .pattern("##")
                .pattern("@#")
                .pattern("@ ")
                .input('#', ModItems.COBALT)
                .input('@', Items.STICK)
                .criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT))
                .offerTo(exporter, Identifier.of(QualityMayhem.MOD_ID, "cobalt_axe_facing_right"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COBALT_AXE, 1)
                .pattern("##")
                .pattern("#@")
                .pattern(" @")
                .input('#', ModItems.COBALT)
                .input('@', Items.STICK)
                .criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT))
                .offerTo(exporter, Identifier.of(QualityMayhem.MOD_ID, "cobalt_axe_facing_left"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COBALT_HOE, 1)
                .pattern("##")
                .pattern("@ ")
                .pattern("@ ")
                .input('#', ModItems.COBALT)
                .input('@', Items.STICK)
                .criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT))
                .offerTo(exporter, Identifier.of(QualityMayhem.MOD_ID, "cobalt_hoe_facing_right"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COBALT_HOE, 1)
                .pattern("##")
                .pattern(" @")
                .pattern(" @")
                .input('#', ModItems.COBALT)
                .input('@', Items.STICK)
                .criterion(hasItem(ModItems.COBALT), conditionsFromItem(ModItems.COBALT))
                .offerTo(exporter, Identifier.of(QualityMayhem.MOD_ID, "cobalt_hoe_facing_left"));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLAZING_SABRE, 1)
                .pattern("  #")
                .pattern(" @ ")
                .pattern("$$ ")
                .input('#', Items.GOLD_BLOCK)
                .input('@', ModItems.INFERNAL_INGOT)
                .input('$', Items.NETHERITE_INGOT)
                .criterion(hasItem(ModItems.INFERNAL_INGOT), conditionsFromItem(ModItems.INFERNAL_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MANGLED_DAGGER, 1)
                .pattern("  $")
                .pattern(" @@")
                .pattern("#  ")
                .input('#', Items.STICK)
                .input('@', Items.IRON_INGOT)
                .input('$', ModItems.RAW_COBALT)
                .criterion(hasItem(ModItems.RAW_COBALT), conditionsFromItem(ModItems.RAW_COBALT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUNAR_SOAKED_DIRK, 1)
                .pattern("  $")
                .pattern("%@ ")
                .pattern("#% ")
                .input('#', Items.STICK)
                .input('%', Items.IRON_INGOT)
                .input('$', ModItems.TOPAZ)
                .input('@', ModItems.MANGLED_DAGGER)
                .criterion(hasItem(ModItems.MANGLED_DAGGER), conditionsFromItem(ModItems.MANGLED_DAGGER))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OCCULT_KATANA, 1)
                .pattern(" #$")
                .pattern("%@#")
                .pattern(" % ")
                .input('#', ModBlocks.COBALT_BLOCK)
                .input('%', Items.AMETHYST_SHARD)
                .input('$', Items.NETHERITE_INGOT)
                .input('@', ModItems.LUNAR_SOAKED_DIRK)
                .criterion(hasItem(ModItems.LUNAR_SOAKED_DIRK), conditionsFromItem(ModItems.LUNAR_SOAKED_DIRK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ETHEREAL_FLARE, 1)
                .pattern("#%$")
                .pattern("@+%")
                .pattern("=&#")
                .input('#', ModItems.TOPAZ)
                .input('%', ModItems.INFERNAL_INGOT)
                .input('$', ModItems.ATHIUM)
                .input('@', Items.WITHER_SKELETON_SKULL)
                .input('&', Items.NETHER_STAR)
                .input('=', ModItems.BLAZING_SABRE)
                .input('+', ModItems.OCCULT_KATANA)
                .criterion(hasItem(ModItems.OCCULT_KATANA), conditionsFromItem(ModItems.OCCULT_KATANA))
                .offerTo(exporter);
    }
}