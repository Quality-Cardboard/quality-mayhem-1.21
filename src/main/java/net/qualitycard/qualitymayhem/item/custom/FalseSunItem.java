package net.qualitycard.qualitymayhem.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.qualitycard.qualitymayhem.damage.types.ModDamageTypes;
import net.qualitycard.qualitymayhem.particle.ModParticles;
import net.qualitycard.qualitymayhem.sound.ModSounds;
import net.qualitycard.qualitymayhem.util.ModTags;

public class FalseSunItem extends ShieldItem {
    public FalseSunItem(Settings settings) {
        super(settings);
    }

    public static void createCircle(World world, Vec3d center, int radius, int numParticles, ParticleEffect particleEffect) {
        double angleIncrement = 2 * Math.PI / numParticles;
        for (int i = 0; i < numParticles; i++) {
            double angle = i * angleIncrement;
            double x = center.getX() + radius * Math.cos(angle);
            double z = center.getZ() + radius * Math.sin(angle);
            world.addParticle(particleEffect, x, center.getY(), z, 0, 0, 0);
        }
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isIn(ModTags.Items.FALSE_SUN_REPAIR_ITEMS) || super.canRepair(stack, ingredient);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand); // Start charging
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        float chargeTime = getMaxUseTime(stack, user)- remainingUseTicks;
        // Perform action based on chargeTime
        if (chargeTime > 5) {
            var entitiesList = world.getEntitiesByType(TypeFilter.instanceOf(LivingEntity.class), new Box(user.getX() - 4, user.getY() - 4, user.getZ() - 4, user.getX() + 4, user.getY() + 2, user.getZ() + 2), EntityPredicates.VALID_ENTITY);
            for (Entity selectedEntity : entitiesList) {
                if (selectedEntity != user) {
                    selectedEntity.damage(ModDamageTypes.of(world, ModDamageTypes.LIGHT_DAMAGE_TYPE), chargeTime / 4);
                    selectedEntity.pushAwayFrom(user);
                    createCircle(world, user.getPos(), 4, Math.round(chargeTime), ModParticles.LIGHT_PARTICLE);
                    world.playSound(null, user.getBlockPos(), ModSounds.PARRY, SoundCategory.PLAYERS, 2f, 1f);
                }
            }
        }
    }
}
