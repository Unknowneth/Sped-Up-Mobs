package com.notunanancyowen.sped.neoforge;

import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import com.notunanancyowen.sped.SpedUpMobs;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(SpedUpMobs.MOD_ID)
public final class SpedUpMobsNeoForge {
    public SpedUpMobsNeoForge(IEventBus modBus) {
        SpedUpMobs.init();
        modBus.addListener(this::registerGamerules);
    }
    private void registerGamerules(final FMLCommonSetupEvent event) {
        SpedUpMobs.MOB_AI_SPEED = GameRules.register("mobAItickRateMultiplier", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
        SpedUpMobs.MOB_MOVE_SPEED = GameRules.register("mobMoveSpeedMultiplier", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
        SpedUpMobs.MOB_ACTION_SPEED = GameRules.register("mobActionSpeedMultiplier", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
    }
}
