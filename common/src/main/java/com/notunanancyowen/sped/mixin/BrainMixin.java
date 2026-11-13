package com.notunanancyowen.sped.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.notunanancyowen.sped.SpedUpMobs;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Brain.class)
public abstract class BrainMixin<E extends LivingEntity> {
    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ai/Brain;tickSensors(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;)V"))
    private void tickSensorsFaster(Brain<E> instance, ServerLevel serverLevel, E livingEntity, Operation<Void> original) {
        for(int i = 0; i < serverLevel.getGameRules().getInt(SpedUpMobs.MOB_AI_SPEED); i++) original.call(instance, serverLevel, livingEntity);
    }
    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ai/Brain;startEachNonRunningBehavior(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;)V"))
    private void tickNonRunningBehaviorsFaster(Brain<E> instance, ServerLevel serverLevel, E livingEntity, Operation<Void> original) {
        for(int i = 0; i < serverLevel.getGameRules().getInt(SpedUpMobs.MOB_AI_SPEED); i++) original.call(instance, serverLevel, livingEntity);
    }
    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ai/Brain;tickEachRunningBehavior(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;)V"))
    private void tickEachRunningBehaviorFaster(Brain<E> instance, ServerLevel serverLevel, E livingEntity, Operation<Void> original) {
        for(int i = 0; i < serverLevel.getGameRules().getInt(SpedUpMobs.MOB_AI_SPEED); i++) original.call(instance, serverLevel, livingEntity);
    }
}
