package net.qualitycard.qualitymayhem;

import com.mojang.brigadier.ParseResults;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.qualitycard.qualitymayhem.block.ModBlocks;
import net.qualitycard.qualitymayhem.component.ModDataComponentTypes;
import net.qualitycard.qualitymayhem.effect.ModEffects;
import net.qualitycard.qualitymayhem.entity.ModEntities;
import net.qualitycard.qualitymayhem.entity.custom.AtomicBlastProjectileEntity;
import net.qualitycard.qualitymayhem.entity.custom.ScutterBugEntity;
import net.qualitycard.qualitymayhem.item.ModItemGroups;
import net.qualitycard.qualitymayhem.item.ModItems;
import net.qualitycard.qualitymayhem.potion.ModPotions;
import net.qualitycard.qualitymayhem.sound.ModSounds;
import net.qualitycard.qualitymayhem.util.HammerUsageEvent;
import net.qualitycard.qualitymayhem.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class QualityMayhem implements ModInitializer {
	public static final String MOD_ID = "qualitymayhem";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Thanks Adorable_Elk_3429 from a random reddit post for this function :D
	public boolean vanillaCommandByPlayer(World world, BlockPos pos, String command) {
		PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 5, false);
		if (player != null) {
			CommandManager commandManager = Objects.requireNonNull(player.getServer()).getCommandManager();
			ServerCommandSource commandSource = player.getServer().getCommandSource();
			commandManager.executeWithPrefix(commandSource, command);
			return true;
		}
		return false;
	}


	@Override
	// When Initialized this method / function will run
	public void onInitialize() {
		DisplayEntity.BlockDisplayEntity box;
		// Registering to make sure the java class is working

		// Registering World Generation
		ModWorldGeneration.generateModWorldGen();

		// Registering Mod Item Groups
		ModItemGroups.registerItemGroups();

		// Registering Mod Items and Blocks
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		// Registering Mod Entities
		ModEntities.registerModEntities();

		// Registering Mod Fuel Items
		FuelRegistry.INSTANCE.add(ModItems.HEAT_CORE, 16000);

		// Registering Mod Data Component Types
		ModDataComponentTypes.registerDataCompenentTypes();

		// Registering Mod Sounds
		ModSounds.registerSounds();

		// Registering Mod Effects
		ModEffects.registerEffects();

		// Registering Mod Potions
		ModPotions.registerPotions();

		FabricDefaultAttributeRegistry.register(ModEntities.SCUTTER_BUG, ScutterBugEntity.createAtrributes());

		// Registering Mod Potion Recipe
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.WITHER_SKELETON_SKULL, ModPotions.CATASTROPHE_POTION);
		});


		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			// Heaven Piercer
			if(player.getMainHandStack().getItem() == ModItems.HEAVEN_PIERCER && !world.isClient()) {
				if (!world.isClient) {
					float pitch = (float)(Math.random() * 5) ;
					if (pitch > 1) {
						world.playSound(null, entity.getBlockPos(), ModSounds.HEAVEN_PIERCER_ATTACK, SoundCategory.PLAYERS, 1f, pitch);
					}
					else {
						world.playSound(null, entity.getBlockPos(), ModSounds.HEAVEN_PIERCER_ATTACK, SoundCategory.PLAYERS, 1f, 1f);
					}

					boolean hasCatastropheEffect = player.hasStatusEffect(ModEffects.CATASTROPHE);
					if (hasCatastropheEffect) {
						player.clearStatusEffects();
						vanillaCommandByPlayer(world, player.getBlockPos(), "execute in qualitymayhem:valour run tp @a ~ ~ ~");
					}

				}
			}



			// Gilded Claymore
			if(player.getMainHandStack().getItem() == ModItems.GILDED_CLAYMORE && !world.isClient()) {
				if (!world.isClient) {
					float pitch = (float) (Math.random() * 2);
					if (pitch > 1) {
						world.playSound(null, entity.getBlockPos(), ModSounds.GILDED_CLAYMORE_ATTACK, SoundCategory.PLAYERS, 1f, pitch);
					} else {
						world.playSound(null, entity.getBlockPos(), ModSounds.GILDED_CLAYMORE_ATTACK, SoundCategory.PLAYERS, 1f, 1f);
					}

					boolean hasCatastropheEffect = player.hasStatusEffect(ModEffects.CATASTROPHE);
					if (hasCatastropheEffect) {
						player.clearStatusEffects();
						vanillaCommandByPlayer(world, player.getBlockPos(), "execute in qualitymayhem:infernal_descent run tp @a ~ ~ ~");
					}
				}
			}

			return ActionResult.PASS;

		});






	}



}