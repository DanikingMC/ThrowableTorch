package com.daniking.throwabletorch.entity;

import com.daniking.throwabletorch.client.ThrowableTorchClient;
import com.daniking.throwabletorch.registry.ModEntities;
import com.daniking.throwabletorch.registry.ModRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ThrowableTorchEntity extends ThrownItemEntity {

    public ThrowableTorchEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ThrowableTorchEntity(World world, LivingEntity owner) {
        super(ModEntities.THROWABLE_TORCH_ENTITY, owner, world);
    }

    public ThrowableTorchEntity(World world, double x, double y, double z) {
        super(ModEntities.THROWABLE_TORCH_ENTITY, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModRegistry.THROWABLE_SLIME_TORCH;
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.create(this, ThrowableTorchClient.PacketID);

    }

        Boolean hasHit = false;

    @Override
    protected void onBlockHit(BlockHitResult hit) {
        Direction direction = hit.getSide();
        BlockPos placeAt = hit.getBlockPos().offset(direction);


        if (!hasHit && direction == Direction.UP) {
            world.setBlockState(placeAt, Blocks.TORCH.getDefaultState());
            hasHit = true;
        } else if (!hasHit && direction == Direction.NORTH) {
            world.setBlockState(placeAt, Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, Direction.NORTH));
            hasHit = true;
         } else if (!hasHit && direction == Direction.SOUTH) {
            world.setBlockState(placeAt, Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, Direction.SOUTH));
            hasHit = true;
        } else if (!hasHit && direction == Direction.WEST) {
            world.setBlockState(placeAt, Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, Direction.WEST));
            hasHit = true;
        } else if (!hasHit && direction == Direction.EAST) {
            world.setBlockState(placeAt, Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, Direction.EAST));
            hasHit = true;
        }
    }



    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(DamageSource.thrownProjectile(this, this.getOwner()), 1F);
        this.remove(); // kills the projectile
    }

}