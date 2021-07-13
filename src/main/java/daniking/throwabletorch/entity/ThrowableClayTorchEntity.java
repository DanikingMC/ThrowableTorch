package daniking.throwabletorch.entity;

import daniking.throwabletorch.registry.ModEntities;
import daniking.throwabletorch.registry.ModRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Copyright 2021 DaniK1ngRD
 */

public class ThrowableClayTorchEntity extends ThrowableTorchEntity
{

    public ThrowableClayTorchEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(ModEntities.THROWABLE_CLAY_TORCH_ENTITY, world);
    }

    public ThrowableClayTorchEntity(World world, LivingEntity player){
        super(ModEntities.THROWABLE_CLAY_TORCH_ENTITY, world, player);
    }

    @Override
    protected Item getDefaultItem() {
        return ModRegistry.THROWABLE_CLAY_TORCH;
    }
}
