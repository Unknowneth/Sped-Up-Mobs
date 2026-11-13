package com.notunanancyowen.sped.fabric;

import net.fabricmc.api.ModInitializer;

import com.notunanancyowen.sped.SpedUpMobs;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;

public final class SpedUpMobsFabric implements ModInitializer {
    @Override public void onInitialize() {
        SpedUpMobs.init();
        SpedUpMobs.MOB_AI_SPEED = GameRuleRegistry.register("mobAItickRateMultiplier", GameRules.Category.MOBS, GameRuleFactory.createIntRule(1, 1, 100));
        SpedUpMobs.MOB_MOVE_SPEED = GameRuleRegistry.register("mobMoveSpeedMultiplier", GameRules.Category.MOBS, GameRuleFactory.createIntRule(1, 1, 100));
        SpedUpMobs.MOB_ACTION_SPEED = GameRuleRegistry.register("mobActionSpeedMultiplier", GameRules.Category.MOBS, GameRuleFactory.createIntRule(1, 1, 100));
    }
}
