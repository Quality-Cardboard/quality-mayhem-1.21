package net.qualitycard.qualitymayhem.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.qualitycard.qualitymayhem.entity.ModEntities;
import net.qualitycard.qualitymayhem.item.ModItems;
import org.joml.Vector2f;

public class AtomicBlastProjectileEntity extends PersistentProjectileEntity {
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
    private final int maxTime = 20 * 5; // 5 seconds in ticks

    @Override
    public void tick() {
        super.tick();
        projectileTimer++;

        World world = getWorld();
        if (projectileTimer >= maxTime) {

            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            int x = this.getBlockX();
            int y = this.getBlockY();
            int z = this.getBlockZ();
            world.spawnEntity(lightning);
            setOnFire(false);
            lightning.setPos(x + 0.5f,y,z + 0.5f);
        }
    }

    @Override
    protected boolean tryPickup(PlayerEntity player) {
        return false;
    }

}
