package net.qualitycard.qualitymayhem.entity.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.qualitycard.qualitymayhem.damage.types.ModDamageTypes;
import net.qualitycard.qualitymayhem.entity.ModEntities;
import net.qualitycard.qualitymayhem.item.ModItems;
import net.qualitycard.qualitymayhem.particle.ModParticles;
import net.qualitycard.qualitymayhem.sound.ModSounds;
import org.joml.Vector2f;

import java.util.Objects;

public class AtomicBlastProjectileEntity extends PersistentProjectileEntity {

    boolean playedSound = false;
    private float rotation;
    public Vector2f groundedOffset;
    public AtomicBlastProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public AtomicBlastProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.ATOMIC_BLAST, player, world, new ItemStack(ModItems.ATOMIC_BLAST), null);
    }


    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.ATOMIC_BLAST);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);

        if(result.getSide() == Direction.SOUTH) {
            groundedOffset = new Vector2f(215f,180f);
        }
        if(result.getSide() == Direction.NORTH) {
            groundedOffset = new Vector2f(215f, 0f);
        }
        if(result.getSide() == Direction.EAST) {
            groundedOffset = new Vector2f(215f,-90f);
        }
        if(result.getSide() == Direction.WEST) {
            groundedOffset = new Vector2f(215f,90f);
        }

        if(result.getSide() == Direction.DOWN) {
            groundedOffset = new Vector2f(115f,180f);
        }
        if(result.getSide() == Direction.UP) {
            groundedOffset = new Vector2f(285f,180f);
        }

    }

    private int projectileTimer = 0;
    private final int maxTime = 20 * 1; // 2 seconds in ticks

    @Override
    public void tick() {
        super.tick();
        projectileTimer++;

        World world = getWorld();
        if (isGrounded()) {
            if (projectileTimer >= maxTime) {
                double x = this.getX();
                double y = this.getY();
                double z = this.getZ();
                setOnFire(false);

                // Freezes the Player
                final PlayerEntity closestPlayer = world.getClosestPlayer(this.getX(),this.getY(), this.getZ(),3,true);
                if (closestPlayer != null) {
                    // Constantly sets the player's position to the atomic blast
                    closestPlayer.setPos(x, y, z);

                    // Disables the hotbar by constantly set it to the -1 slot (which doesn't have anything) (Nvm it breaks the game)
                    if(MinecraftClient.getInstance().player != null){
                        MinecraftClient.getInstance().player.getInventory().selectedSlot = 1;
                    }

                    if (projectileTimer >= maxTime + 200) {
                        closestPlayer.damage(ModDamageTypes.of(world, ModDamageTypes.ATOMIC_BLAST_DAMAGE_TYPE), 999999999.0f);
                    }
                }

                // Plays Explosion Sound
                if (projectileTimer >= maxTime + 180) {
                    if (!playedSound) {
                        world.playSound(null, this.getBlockPos(), ModSounds.ATOMIC_BLAST_EXPLOSION, SoundCategory.MASTER, 2f, 1f);
                        playedSound = true;
                    }

                }


                // Makes some effects
                if (projectileTimer >= maxTime + 201) {

                    // Spawns Explosion Particles
                    world.addParticle(ModParticles.ATOMIC_BLAST_EXPLOSION_PARTICLE, this.getX(), this.getY() + 0.125f, this.getZ(), 0.0, 0.0, 0.0);

                    // Summons Lightning
                    LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                    world.spawnEntity(lightning);
                    lightning.setPos(x, y, z);

                    // Summons Explosion
                    this.getWorld().createExplosion(this, x, y, z, 10f, World.ExplosionSourceType.BLOCK);

                    // Deletes itself
                    this.discard();
                }
            }
        }
    }

    @Override
    protected boolean tryPickup(PlayerEntity player) {
        return false;
    }

}
