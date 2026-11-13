package com.notunanancyowen.sped.mixin;

import com.notunanancyowen.sped.SpedUpMobs;
import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Creeper.class)
public abstract class CreeperMixin extends MonsterMixin {
    @ModifyVariable(method = "setSwellDir", at = @At("HEAD"), argsOnly = true, index = 1)
    private int modifySwellDir(int swellDir) {
        return swellDir * level().getGameRules().getInt(SpedUpMobs.MOB_ACTION_SPEED);
    }
}
