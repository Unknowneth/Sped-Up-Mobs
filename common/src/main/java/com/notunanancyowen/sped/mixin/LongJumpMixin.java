package com.notunanancyowen.sped.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.notunanancyowen.sped.SpedUpMobs;
import net.minecraft.world.entity.monster.breeze.Breeze;
import net.minecraft.world.entity.monster.breeze.LongJump;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LongJump.class)
public abstract class LongJumpMixin {
    @WrapOperation(method = "isFinishedJumping", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/breeze/Breeze;onGround()Z"))
    private static boolean preventSecondJump(Breeze instance, Operation<Boolean> original) {
        //exists to fix accidental cooldown resets
        if(instance.getDeltaMovement().y() > 0.0 && instance.level().getGameRules().getInt(SpedUpMobs.MOB_AI_SPEED) > 1) return false;
        return original.call(instance);
    }
}
