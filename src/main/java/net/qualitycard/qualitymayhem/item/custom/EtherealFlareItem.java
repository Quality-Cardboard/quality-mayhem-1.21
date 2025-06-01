package net.qualitycard.qualitymayhem.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.effect.ModEffects;

public class EtherealFlareItem extends SwordItem {
    public EtherealFlareItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        target.setOnFireFor(10f);

        Identifier world = target.getEntityWorld().getRegistryKey().getValue();
        QualityMayhem.LOGGER.info(String.valueOf(world));
        if (world.toString().equals("minecraft:overworld")) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 50, 1));
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 50, 1));
        } else if (world.toString().equals("minecraft:the_nether")) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 50, 1));
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 50, 1));
        } else if (world.toString().equals("minecraft:the_end")) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 50, 1));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 50, 1));
        }

    }
}
