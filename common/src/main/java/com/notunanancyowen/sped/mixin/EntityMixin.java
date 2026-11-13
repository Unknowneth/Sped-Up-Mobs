package com.notunanancyowen.sped.mixin;

import com.notunanancyowen.sped.SpedUpMobs;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow public abstract Level level();
    @Shadow public abstract boolean isNoGravity();
    @ModifyVariable(method = "move", at = @At("HEAD"), argsOnly = true, index = 2)
    private Vec3 fasterMovement(Vec3 vec3, MoverType moverType) {
        if(moverType == MoverType.SELF) if((Entity)(Object)this instanceof Mob m) {
            int multiplier = level().getGameRules().getInt(SpedUpMobs.MOB_MOVE_SPEED);
            return vec3.multiply(multiplier, !(m instanceof FlyingMob) && !isNoGravity() ? 1 : multiplier, multiplier);
        }
        return vec3;
    }
}
