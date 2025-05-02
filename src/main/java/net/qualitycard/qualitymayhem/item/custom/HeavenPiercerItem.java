package net.qualitycard.qualitymayhem.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class HeavenPiercerItem extends SwordItem {
    public HeavenPiercerItem(ToolMaterial toolMaterial, Settings settings) {super(toolMaterial, settings);}

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 1));
        target.disablesShield();

    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.qualitymayhem.heaven_piercer"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
