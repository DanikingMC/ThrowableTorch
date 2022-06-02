package daniking.throwabletorch.common.item;

import daniking.throwabletorch.common.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * Base class for all throwable torches.
 */

public class ThrowableTorchItem extends Item {

    private final ThrowableTorchTypes type;

    public ThrowableTorchItem(Settings settings, ThrowableTorchTypes type) {
        super(settings);

        this.type = type;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stackInHand = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 1.0F, 1.0F);

        if (!user.getAbilities().creativeMode) {
            stackInHand.decrement(1);
        }

        if (!world.isClient) {
            switch (type) {
                case SLIME -> {
                    ThrowableSlimeTorchEntity slimeTorchEntity = new ThrowableSlimeTorchEntity(world, user);
                    slimeTorchEntity.setItem(stackInHand);
                    slimeTorchEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
                    world.spawnEntity(slimeTorchEntity);
                }
                case CLAY -> {
                    ThrowableClayTorchEntity clayTorchEntity = new ThrowableClayTorchEntity(world, user);
                    clayTorchEntity.setItem(stackInHand);
                    clayTorchEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
                    world.spawnEntity(clayTorchEntity);
                }
                case MAGMA -> {
                    ThrowableMagmaTorchEntity magmaTorchEntity = new ThrowableMagmaTorchEntity(world, user);
                    magmaTorchEntity.setItem(stackInHand);
                    magmaTorchEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
                    world.spawnEntity(magmaTorchEntity);
                }
                case HONEYCOMB -> {
                    ThrowableHoneyCombEntity honeyCombEntity = new ThrowableHoneyCombEntity(world, user);
                    honeyCombEntity.setItem(stackInHand);
                    honeyCombEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
                    world.spawnEntity(honeyCombEntity);
                }
            }
        }

        return TypedActionResult.success(stackInHand, world.isClient());
    }
}
