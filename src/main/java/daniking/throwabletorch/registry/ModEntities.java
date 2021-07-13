package daniking.throwabletorch.registry;

import daniking.throwabletorch.ThrowableTorch;
import daniking.throwabletorch.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {


    public static final EntityType<ThrowableSlimeTorchEntity> THROWABLE_SLIME_TORCH_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ThrowableTorch.MODID, "throwable_slime_torch"),
            FabricEntityTypeBuilder.<ThrowableSlimeTorchEntity>create(SpawnGroup.MISC, ThrowableSlimeTorchEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<ThrowableClayTorchEntity>THROWABLE_CLAY_TORCH_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ThrowableTorch.MODID, "throwable_clay_torch"),
            FabricEntityTypeBuilder.<ThrowableClayTorchEntity>create(SpawnGroup.MISC,ThrowableClayTorchEntity::new)
                    .dimensions(EntityDimensions.fixed(.025F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<ThrowableMagmaTorchEntity>THROWABLE_MAGMA_TORCH_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ThrowableTorch.MODID, "throwable_magma_torch"),
            FabricEntityTypeBuilder.<ThrowableMagmaTorchEntity>create(SpawnGroup.MISC,ThrowableMagmaTorchEntity::new)
                    .dimensions(EntityDimensions.fixed(.025F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<ThrowableHoneyCombEntity>THROWABLE_HONEY_COMB_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ThrowableTorch.MODID, "throwable_honeycomb_torch"),
            FabricEntityTypeBuilder.<ThrowableHoneyCombEntity>create(SpawnGroup.MISC,ThrowableHoneyCombEntity::new)
                    .dimensions(EntityDimensions.fixed(.025F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );


}
