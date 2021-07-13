package daniking.throwabletorch.common.entity;

import daniking.throwabletorch.common.network.packet.EntitySpawnPacket;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public abstract class ThrowableTorchEntity extends ThrownItemEntity {

    public ThrowableTorchEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ThrowableTorchEntity(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner) {
        super(entityType, owner, world);
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.create(this);
    }

    boolean hasHit = false;

    protected void onBlockHit(BlockHitResult hit) {

        if (!world.isClient) {

            Direction direction = hit.getSide();
            BlockPos placeAt = hit.getBlockPos().offset(direction);
            Block placeTorch = Blocks.TORCH;
            Block placeWallTorch = Blocks.WALL_TORCH;

            if (placeAt == null) {
                this.remove();
                return;
            }

            boolean isPlaceableUp = Blocks.TORCH.canPlaceAt(placeTorch.getDefaultState(), world, placeAt);
            boolean isPlaceableNorth = Blocks.WALL_TORCH.canPlaceAt(placeWallTorch.getDefaultState().with(WallTorchBlock.FACING, Direction.NORTH), world, placeAt);
            boolean isPlaceableSouth = Blocks.WALL_TORCH.canPlaceAt(placeWallTorch.getDefaultState().with(WallTorchBlock.FACING, Direction.SOUTH), world, placeAt);
            boolean isPlaceableEast = Blocks.WALL_TORCH.canPlaceAt(placeWallTorch.getDefaultState().with(WallTorchBlock.FACING, Direction.EAST), world, placeAt);
            boolean isPlaceableWest = Blocks.WALL_TORCH.canPlaceAt(placeWallTorch.getDefaultState().with(WallTorchBlock.FACING, Direction.WEST), world, placeAt);

                if (!hasHit) {
                    if (world.getBlockState(placeAt).isAir()) {
                        if (direction == Direction.UP && isPlaceableUp) {
                            world.setBlockState(placeAt, placeTorch.getDefaultState());
                        } else if (direction == Direction.DOWN) {
                            world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(Blocks.TORCH)));
                        } else if (direction == Direction.NORTH && isPlaceableNorth) {
                            world.setBlockState(placeAt, placeWallTorch.getDefaultState().with(WallTorchBlock.FACING, Direction.NORTH));
                        } else if (direction == Direction.SOUTH && isPlaceableSouth) {
                            world.setBlockState(placeAt, placeWallTorch.getDefaultState().with(WallTorchBlock.FACING, Direction.SOUTH));
                        } else if (direction == Direction.EAST && isPlaceableEast) {
                            world.setBlockState(placeAt, placeWallTorch.getDefaultState().with(WallTorchBlock.FACING, Direction.EAST));
                        } else if (direction == Direction.WEST && isPlaceableWest) {
                            world.setBlockState(placeAt, placeWallTorch.getDefaultState().with(WallTorchBlock.FACING, Direction.WEST));
                        }
                    } else {
                        world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(Blocks.TORCH)));
                    }

                }
                remove();
            }

            for(int i = 0; i < 16; ++i) {
                this.world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, getDefaultItem().getDefaultStack()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }

        }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(Blocks.TORCH)));
        entityHitResult.getEntity().damage(DamageSource.thrownProjectile(this, this.getOwner()), 1F);
        this.remove();
    }

}