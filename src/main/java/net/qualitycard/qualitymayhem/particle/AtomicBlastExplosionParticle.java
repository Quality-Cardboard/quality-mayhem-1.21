package net.qualitycard.qualitymayhem.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

public class AtomicBlastExplosionParticle extends SpriteBillboardParticle {


    public AtomicBlastExplosionParticle(ClientWorld clientWorld, double x, double y, double z,
                                        SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);

        this.velocityMultiplier = 0f;
        this.gravityStrength = 0.0F;
        this.velocityX = 0.0;
        this.velocityY = 0.0;
        this.velocityZ = 0.0;

        this.maxAge = 1000;
        this.setSpriteForAge(spriteProvider);

        this.red = 1f;
        this.blue = 1f;
        this.green = 1f;

    }

    @Override
    public void tick() {
        this.age++;
        float a = 1.25f;
        a = a + 0.01f;
        if (a < 15) {
            this.scale(a);
        }
        super.tick();
    }

    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        this.alpha = 1.0F - MathHelper.clamp(((float)this.age + tickDelta) / (float)this.maxAge, 0.0F, 1.0F);
        Quaternionf quaternionf = new Quaternionf();
        quaternionf.rotationYXZ(0F, -1.58F, 0F);
        this.method_60373(vertexConsumer, camera, quaternionf, tickDelta);
    }


    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new AtomicBlastExplosionParticle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
