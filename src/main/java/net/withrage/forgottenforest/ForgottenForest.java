package net.withrage.forgottenforest;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.withrage.forgottenforest.item.ModItems;

@Mod(ForgottenForest.MOD_ID)
public class ForgottenForest {
    public static final String MOD_ID = "forgottenforest";

    public ForgottenForest() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
    }
}
