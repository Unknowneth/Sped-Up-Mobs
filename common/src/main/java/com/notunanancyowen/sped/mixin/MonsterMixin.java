package com.notunanancyowen.sped.mixin;

import com.notunanancyowen.sped.SpedUpMobs;
import net.minecraft.world.entity.monster.Monster;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Monster.class)
public abstract class MonsterMixin extends PathfinderMobMixin {
    @Inject(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Monster;updateSwingTime()V"))
    private void fasterMelees(CallbackInfo ci) {
        for(int i = 1; i < level().getGameRules().getInt(SpedUpMobs.MOB_ACTION_SPEED); i++) updateSwingTime();
    }
}
