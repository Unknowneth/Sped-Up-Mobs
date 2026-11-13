package com.notunanancyowen.sped;

import net.minecraft.world.level.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SpedUpMobs {
    public static final String MOD_ID = "sped_up_mobs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static GameRules.Key<GameRules.IntegerValue> MOB_AI_SPEED;
    public static GameRules.Key<GameRules.IntegerValue> MOB_MOVE_SPEED;
    public static GameRules.Key<GameRules.IntegerValue> MOB_ACTION_SPEED;
    public static void init() {
        LOGGER.info("Bring forth the chaos you wish to unfold...");
    }
}
