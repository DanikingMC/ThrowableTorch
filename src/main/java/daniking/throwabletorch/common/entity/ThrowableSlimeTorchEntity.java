package daniking.throwabletorch.common.entity;

import daniking.throwabletorch.common.registry.ModEntityTypes;
import daniking.throwabletorch.common.registry.ModRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;


/**
 * Copyright 2021 DaniK1ngRD
 */

public class ThrowableSlimeTorchEntity extends ThrowableTorchEntity
{
    public ThrowableSlimeTorchEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(ModEntityTypes.THROWABLE_SLIME_TORCH_ENTITY, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModRegistry.THROWABLE_SLIME_TORCH;
    }

    public ThrowableSlimeTorchEntity (World world, LivingEntity player) {
        super(ModEntityTypes.THROWABLE_SLIME_TORCH_ENTITY, world, player);
    }



}
