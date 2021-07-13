package daniking.throwabletorch.client;

import daniking.throwabletorch.client.network.packet.ModEntityPacket;
import daniking.throwabletorch.common.registry.ModEntityRenderer;
import net.fabricmc.api.ClientModInitializer;

public class ThrowableTorchClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModEntityPacket.handle();
        ModEntityRenderer.EntityRenderer();
    }
}

