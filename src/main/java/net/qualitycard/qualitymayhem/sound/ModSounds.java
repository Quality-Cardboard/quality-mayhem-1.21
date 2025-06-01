package net.qualitycard.qualitymayhem.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.qualitycard.qualitymayhem.QualityMayhem;

public class ModSounds {

    public static final SoundEvent HEAVEN_PIERCER_ATTACK = registerSoundEvent("heaven_piercer_attack");
    public static final SoundEvent GILDED_CLAYMORE_ATTACK = registerSoundEvent("gilded_claymore_attack");
    public static final SoundEvent ATOMIC_BLAST_EXPLOSION = registerSoundEvent("atomic_blast_explosion");
    public static final SoundEvent ATOMIC_BLAST_EXPLOSION_ = registerSoundEvent("atomic_blast_explosion_");

    public static final SoundEvent INFERNAL_INGOT_BLOCK_BREAK = registerSoundEvent("infernal_ingot_block_break");
    public static final SoundEvent INFERNAL_INGOT_BLOCK_STEP = registerSoundEvent("infernal_ingot_block_step");
    public static final SoundEvent INFERNAL_INGOT_BLOCK_PLACE = registerSoundEvent("infernal_ingot_block_place");
    public static final SoundEvent INFERNAL_INGOT_BLOCK_HIT = registerSoundEvent("infernal_ingot_block_hit");
    public static final SoundEvent INFERNAL_INGOT_BLOCK_FALL = registerSoundEvent("infernal_ingot_block_fall");

    public static final BlockSoundGroup INFERNAL_INGOT_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
        INFERNAL_INGOT_BLOCK_BREAK, INFERNAL_INGOT_BLOCK_STEP, INFERNAL_INGOT_BLOCK_PLACE, INFERNAL_INGOT_BLOCK_HIT, INFERNAL_INGOT_BLOCK_FALL);

    public static final SoundEvent RICK_ROLL = registerSoundEvent("rick_roll");
    public static final RegistryKey<JukeboxSong> RICK_ROLL_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(QualityMayhem.MOD_ID, "rick_roll"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(QualityMayhem.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        QualityMayhem.LOGGER.info("Registering Mod Sounds for " + QualityMayhem.MOD_ID);
    }
}
