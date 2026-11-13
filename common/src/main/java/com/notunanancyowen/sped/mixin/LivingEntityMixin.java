package com.notunanancyowen.sped.mixin;

import com.notunanancyowen.sped.SpedUpMobs;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends EntityMixin {
    @Shadow protected abstract void updateSwingTime();
    @Shadow protected abstract void updatingUsingItem();
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;updatingUsingItem()V"))
    private void tickMobActionsFaster(CallbackInfo ci) {
        if((LivingEntity)(Object)this instanceof Mob) for(int i = 1; i < level().getGameRules().getInt(SpedUpMobs.MOB_ACTION_SPEED); i++) updatingUsingItem();
    }
}
