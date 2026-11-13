package com.notunanancyowen.sped.mixin;

import com.notunanancyowen.sped.SpedUpMobs;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public abstract class MobMixin extends LivingEntityMixin {
    @Shadow @Final protected GoalSelector goalSelector;
    @Inject(method = "serverAiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ai/goal/GoalSelector;tickRunningGoals(Z)V"))
    private void tickAIFaster1(CallbackInfo ci) {
        for(int i = 1; i < level().getGameRules().getInt(SpedUpMobs.MOB_AI_SPEED); i++) goalSelector.tickRunningGoals(false);
    }
    @Inject(method = "serverAiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ai/goal/GoalSelector;tick()V"))
    private void tickAIFaster2(CallbackInfo ci) {
        for(int i = 1; i < level().getGameRules().getInt(SpedUpMobs.MOB_AI_SPEED); i++) goalSelector.tick();
    }
}
