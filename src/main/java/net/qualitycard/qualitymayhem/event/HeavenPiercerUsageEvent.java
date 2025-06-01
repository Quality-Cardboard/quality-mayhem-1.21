package net.qualitycard.qualitymayhem.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.qualitycard.qualitymayhem.effect.ModEffects;
import net.qualitycard.qualitymayhem.item.ModItems;
import net.qualitycard.qualitymayhem.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class HeavenPiercerUsageEvent implements AttackEntityCallback {

    // Thanks Adorable_Elk_3429 from a random reddit post for this function :D
    public void vanillaCommandByPlayer(World world, BlockPos pos, String command) {
        PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 5, false);
        if (player != null) {
            CommandManager commandManager = Objects.requireNonNull(player.getServer()).getCommandManager();
            ServerCommandSource commandSource = player.getServer().getCommandSource();
            commandManager.executeWithPrefix(commandSource, command);
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
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
        return ActionResult.PASS;
    }
}
