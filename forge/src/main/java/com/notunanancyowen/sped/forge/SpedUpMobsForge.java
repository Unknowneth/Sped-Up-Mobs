package com.notunanancyowen.sped.forge;

import net.minecraft.world.level.GameRules;
import net.minecraftforge.fml.common.Mod;

import com.notunanancyowen.sped.SpedUpMobs;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SpedUpMobs.MOD_ID)
public final class SpedUpMobsForge {
    public SpedUpMobsForge(FMLJavaModLoadingContext context) {
        SpedUpMobs.init();
        context.getModEventBus().addListener(this::registerGamerules);
    }
    private void registerGamerules(final FMLCommonSetupEvent event) {
        SpedUpMobs.MOB_AI_SPEED = GameRules.register("mobAItickRateMultiplier", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
        SpedUpMobs.MOB_MOVE_SPEED = GameRules.register("mobMoveSpeedMultiplier", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
        SpedUpMobs.MOB_ACTION_SPEED = GameRules.register("mobActionSpeedMultiplier", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
    }
}
