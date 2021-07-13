package daniking.throwabletorch.common.registry;

import daniking.throwabletorch.client.network.packet.ModEntityPacket;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class ModEntityRenderer {

    public static void EntityRenderer(){

        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.THROWABLE_SLIME_TORCH_ENTITY, (dispatcher, context) ->
                new FlyingItemEntityRenderer<>(dispatcher, context.getItemRenderer()));
        ModEntityPacket.handle();


        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.THROWABLE_CLAY_TORCH_ENTITY, (dispatcher, context) ->
            new FlyingItemEntityRenderer<>(dispatcher, context.getItemRenderer()));
    ModEntityPacket.handle();

        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.THROWABLE_MAGMA_TORCH_ENTITY, (dispatcher, context) ->
                new FlyingItemEntityRenderer<>(dispatcher, context.getItemRenderer()));
        ModEntityPacket.handle();

        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.THROWABLE_HONEY_COMB_ENTITY, (dispatcher, context) ->
                new FlyingItemEntityRenderer<>(dispatcher, context.getItemRenderer()));
        ModEntityPacket.handle();


    }
}

