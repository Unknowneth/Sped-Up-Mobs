package com.notunanancyowen.sped.mixin;

import net.minecraft.world.entity.PathfinderMob;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PathfinderMob.class)
public abstract class PathfinderMobMixin extends MobMixin {
}
