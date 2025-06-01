package net.qualitycard.qualitymayhem;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.qualitycard.qualitymayhem.block.ModBlocks;
import net.qualitycard.qualitymayhem.block.custom.TransmutatorBlock;
import net.qualitycard.qualitymayhem.component.ModDataComponentTypes;
import net.qualitycard.qualitymayhem.damage.types.ModDamageTypes;
import net.qualitycard.qualitymayhem.effect.ModEffects;
import net.qualitycard.qualitymayhem.entity.ModEntities;
import net.qualitycard.qualitymayhem.entity.custom.ScutterBugEntity;
import net.qualitycard.qualitymayhem.event.*;
import net.qualitycard.qualitymayhem.item.ModItemGroups;
import net.qualitycard.qualitymayhem.item.ModItems;
import net.qualitycard.qualitymayhem.item.custom.FalseSunItem;
import net.qualitycard.qualitymayhem.particle.ModParticles;
import net.qualitycard.qualitymayhem.potion.ModPotions;
import net.qualitycard.qualitymayhem.sound.ModSounds;
import net.qualitycard.qualitymayhem.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Objects;

import static java.util.Arrays.fill;

public class QualityMayhem implements ModInitializer {
	public static final String MOD_ID = "qualitymayhem";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	// When Initialized this method / function will run
	public void onInitialize() {
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

		// Registering Mod Particles
		ModParticles.registerParticles();

		// Registering Mod Potions
		ModPotions.registerPotions();

		// Registering Mod Damage Types
		ModDamageTypes.registerDamageTypes();

		FabricDefaultAttributeRegistry.register(ModEntities.SCUTTER_BUG, ScutterBugEntity.createAtrributes());

		// Registering Mod Potion Recipe
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.WITHER_SKELETON_SKULL, ModPotions.CATASTROPHE_POTION);
		});

		// FINALLY MADE EVENTS CLEAN INSTEAD OF ALL IN THE INITIALIZE FUNCTION :skull:
		// Runs the Player block break event for the hammer to break the 3x3 blocks
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		// Runs the AttackEntityCallback for the legendary weapons. E.g. Heaven Piercer, Gilded Claymore
		AttackEntityCallback.EVENT.register(new HeavenPiercerUsageEvent());
		AttackEntityCallback.EVENT.register(new GildedClaymoreUsageEvent());

		// Adds a custom hud thingy for when the blighted effect is CAST UPON THEE
		HudRenderCallback.EVENT.register(new BlightedHudRendererCallback());
	}



}