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
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.qualitycard.qualitymayhem.QualityMayhem;
import net.qualitycard.qualitymayhem.effect.ModEffects;

import java.awt.*;
import java.util.List;

public class GildedClaymoreItem extends SwordItem {
    public GildedClaymoreItem(ToolMaterial toolMaterial, Settings settings) {super(toolMaterial, settings);}

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        target.disablesShield();

        Identifier world = target.getEntityWorld().getRegistryKey().getValue();
        QualityMayhem.LOGGER.info(String.valueOf(world));
        if (world.toString().equals("qualitymayhem:infernal_descent")) {
            target.addStatusEffect(new StatusEffectInstance(ModEffects.SMOULDERING, 50, 1));
        }

    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.qualitymayhem.gilded_claymore"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
