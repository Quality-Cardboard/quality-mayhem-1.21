package net.qualitycard.qualitymayhem.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.qualitycard.qualitymayhem.item.custom.AppleJuiceItem;

public class ModFoodComponents {

    // Foods
    public static final FoodComponent RICE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200), 0.15f).usingConvertsTo(Items.BOWL).snack().build();
    public static final FoodComponent EGG_FRIED_RICE = new FoodComponent.Builder().nutrition(7).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200), 0.15f).usingConvertsTo(Items.BOWL).snack().build();
    public static final FoodComponent APPLE_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.25f).build();
    public static final FoodComponent FLAVOURED_ROCKS = new FoodComponent.Builder().nutrition(1).saturationModifier(0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 200, 3), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 60, 1), 0.10f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 60, 1), 0.10f)
            .snack().alwaysEdible().build();

    public static final FoodComponent COOKED_BEEF_SANDWICH = new FoodComponent.Builder().nutrition(10).saturationModifier(0.80f).build();
    public static final FoodComponent CHIPS = new FoodComponent.Builder().nutrition(7).saturationModifier(0.60f).snack().usingConvertsTo(Items.PAPER).build();

    // Drinks
    public static final FoodComponent APPLE_JUICE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.25f).usingConvertsTo(Items.GLASS_BOTTLE).build();
    public static final FoodComponent ALCOHOL = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f).usingConvertsTo(Items.GLASS_BOTTLE)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 1), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 2), 0.50f).build();
    public static final FoodComponent SODA = new FoodComponent.Builder().nutrition(4).saturationModifier(0.30f).usingConvertsTo(Items.GLASS_BOTTLE).build();
}
