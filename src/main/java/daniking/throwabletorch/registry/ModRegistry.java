package daniking.throwabletorch.registry;

import daniking.throwabletorch.ThrowableTorch;
import daniking.throwabletorch.item.ItemThrowableClayTorch;
import daniking.throwabletorch.item.ItemThrowableHoneyCombTorch;
import daniking.throwabletorch.item.ItemThrowableMagmaTorch;
import daniking.throwabletorch.item.ItemThrowableSlimeTorch;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRegistry
{
    public static final Item THROWABLE_SLIME_TORCH = new ItemThrowableSlimeTorch(new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Item THROWABLE_CLAY_TORCH = new ItemThrowableClayTorch(new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Item THROWABLE_MAGMA_TORCH = new ItemThrowableMagmaTorch(new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final Item THROWABLE_HONEYCOMB_TORCH = new ItemThrowableHoneyCombTorch(new Item.Settings().group(ItemGroup.DECORATIONS));

    public static void registerItem(){
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MODID, "throwable_slime_torch"), THROWABLE_SLIME_TORCH);
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MODID, "throwable_clay_torch"), THROWABLE_CLAY_TORCH);
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MODID, "throwable_magma_torch"), THROWABLE_MAGMA_TORCH);
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MODID, "throwable_honeycomb_torch"), THROWABLE_HONEYCOMB_TORCH);

    }
}
