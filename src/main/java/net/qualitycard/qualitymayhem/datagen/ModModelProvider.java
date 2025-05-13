package net.qualitycard.qualitymayhem.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.block.ModBlocks;
import net.qualitycard.qualitymayhem.block.custom.SelfLitRedstoneLampBlock;
import net.qualitycard.qualitymayhem.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool cobaltPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COBALT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_COBALT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TOPAZ_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DUSK_BLOCK);

        cobaltPool.stairs(ModBlocks.COBALT_STAIRS);
        cobaltPool.slab(ModBlocks.COBALT_SLAB);
        cobaltPool.button(ModBlocks.COBALT_BUTTON);
        cobaltPool.pressurePlate(ModBlocks.COBALT_PRESSURE_PLATE);
        cobaltPool.fence(ModBlocks.COBALT_FENCE);
        cobaltPool.fenceGate(ModBlocks.COBALT_FENCE_GATE);
        cobaltPool.wall(ModBlocks.COBALT_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.COBALT_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.COBALT_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.SELF_LIT_REDSTONE_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.SELF_LIT_REDSTONE_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.SELF_LIT_REDSTONE_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(SelfLitRedstoneLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INFERNAL_INGOT_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRANSMUTATOR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEST_PORTAL_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.INFERNAL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COBALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_COBALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.ATHIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_OF_THE_GODS, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_NETHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAVEN_PIERCER_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAVEN_PIERCER_CROSS_GUARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAVEN_PIERCER_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GILDED_CLAYMORE_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GILDED_CLAYMORE_CROSS_GUARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GILDED_CLAYMORE_BLADE, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAT_CORE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.RICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EGG_FRIED_RICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.APPLE_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_BEEF_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHIPS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLAVOURED_ROCKS, Models.GENERATED);

        itemModelGenerator.register(ModItems.APPLE_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALCOHOL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SODA, Models.GENERATED);

        itemModelGenerator.register(ModItems.COBALT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_BOOTS));

        itemModelGenerator.register(ModItems.COBALT_HORSE_ARMOR, Models.GENERATED);


        itemModelGenerator.register(ModItems.BLAZING_SABRE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MANGLED_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUNAR_SOAKED_DIRK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OCCULT_KATANA, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SCUTTER_BUG_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.RICK_ROLL_MUSIC_DISC, Models.GENERATED);



    }
}
