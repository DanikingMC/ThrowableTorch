package daniking.throwabletorch.entity;

import daniking.throwabletorch.registry.ModEntities;
import daniking.throwabletorch.registry.ModRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

/**
 * Copyright 2021 DaniK1ngRD
 */

public class ThrowableMagmaTorchEntity extends ThrowableTorchEntity{

    public ThrowableMagmaTorchEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(ModEntities.THROWABLE_MAGMA_TORCH_ENTITY, world);
    }


    public ThrowableMagmaTorchEntity(World world, LivingEntity player) {
        super(ModEntities.THROWABLE_MAGMA_TORCH_ENTITY, world, player);
    }

    @Override
    protected Item getDefaultItem() {
        return ModRegistry.THROWABLE_MAGMA_TORCH;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        entityHitResult.getEntity().damage(DamageSource.thrownProjectile(this, this.getOwner()), 1F);
        entityHitResult.getEntity().setOnFireFor(5);
        this.remove();

    }
}
