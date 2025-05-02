package net.qualitycard.qualitymayhem.item.custom;

import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class FlavouredRocksItem extends Item {
    public FlavouredRocksItem(Settings settings) {
        super(settings);
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.BLOCK_STONE_BREAK;
    }
}
