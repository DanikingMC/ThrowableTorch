package daniking.throwabletorch.common;

import daniking.throwabletorch.common.registry.ModRegistry;
import net.fabricmc.api.ModInitializer;

public class ThrowableTorch implements ModInitializer {

    public static final String MODID = "throwabletorch";

    @Override
    public void onInitialize() {
        ModRegistry.init();
    }
}


