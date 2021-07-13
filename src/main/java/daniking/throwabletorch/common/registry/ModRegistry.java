package daniking.throwabletorch.common.registry;

import daniking.throwabletorch.common.ThrowableTorch;
import daniking.throwabletorch.common.item.ThrowableTorchItem;
import daniking.throwabletorch.common.item.ThrowableTorchTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRegistry {
    public static final Item THROWABLE_SLIME_TORCH = new ThrowableTorchItem(new Item.Settings().group(ItemGroup.DECORATIONS), ThrowableTorchTypes.SLIME);
    public static final Item THROWABLE_CLAY_TORCH = new ThrowableTorchItem(new Item.Settings().group(ItemGroup.DECORATIONS), ThrowableTorchTypes.CLAY);
    public static final Item THROWABLE_MAGMA_TORCH = new ThrowableTorchItem(new Item.Settings().group(ItemGroup.DECORATIONS), ThrowableTorchTypes.MAGMA);
    public static final Item THROWABLE_HONEYCOMB_TORCH = new ThrowableTorchItem(new Item.Settings().group(ItemGroup.DECORATIONS), ThrowableTorchTypes.HONEYCOMB);

    public static void init(){
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MODID, "throwable_slime_torch"), THROWABLE_SLIME_TORCH);
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MODID, "throwable_clay_torch"), THROWABLE_CLAY_TORCH);
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MODID, "throwable_magma_torch"), THROWABLE_MAGMA_TORCH);
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MODID, "throwable_honeycomb_torch"), THROWABLE_HONEYCOMB_TORCH);

    }
}
