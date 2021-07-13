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
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 1.0F, 1F);

        if (!user.abilities.creativeMode) {
            itemStack.decrement(1);
        }

        if (!world.isClient) {
            switch (type){
                case SLIME:
                    ThrowableSlimeTorchEntity slimeTorchEntity = new ThrowableSlimeTorchEntity(world, user);
                    slimeTorchEntity.setItem(itemStack);
                    slimeTorchEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 0F);
                    world.spawnEntity(slimeTorchEntity);
                    break;
                case CLAY:
                    ThrowableClayTorchEntity clayTorchEntity = new ThrowableClayTorchEntity(world, user);
                    clayTorchEntity.setItem(itemStack);
                    clayTorchEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 0F);
                    world.spawnEntity(clayTorchEntity);
                    break;
                case MAGMA:
                    ThrowableMagmaTorchEntity magmaTorchEntity = new ThrowableMagmaTorchEntity(world, user);
                    magmaTorchEntity.setItem(itemStack);
                    magmaTorchEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 0F);
                    world.spawnEntity(magmaTorchEntity);
                    break;
                case HONEYCOMB:
                    ThrowableHoneyCombEntity honeyCombEntity = new ThrowableHoneyCombEntity(world, user);
                    honeyCombEntity.setItem(itemStack);
                    honeyCombEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 0F);
                    world.spawnEntity(honeyCombEntity);
                    break;
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
