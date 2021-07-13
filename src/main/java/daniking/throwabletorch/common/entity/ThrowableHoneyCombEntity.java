package daniking.throwabletorch.common.entity;

import daniking.throwabletorch.common.registry.ModEntityTypes;
import daniking.throwabletorch.common.registry.ModRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ThrowableHoneyCombEntity extends ThrowableTorchEntity{

    public ThrowableHoneyCombEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(ModEntityTypes.THROWABLE_HONEY_COMB_ENTITY, world);
    }

    public ThrowableHoneyCombEntity(World world, LivingEntity player){
        super(ModEntityTypes.THROWABLE_HONEY_COMB_ENTITY, world, player);
    }

    @Override
    protected Item getDefaultItem() {
        return ModRegistry.THROWABLE_HONEYCOMB_TORCH;
    }
}

