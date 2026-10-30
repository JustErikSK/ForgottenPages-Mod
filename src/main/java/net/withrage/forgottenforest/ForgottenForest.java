package net.withrage.forgottenforest;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.withrage.forgottenforest.item.ModItems;

@Mod(ForgottenForest.MOD_ID)
public class ForgottenForest {
    public static final String MOD_ID = "forgottenforest";

    public ForgottenForest() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }
    }
}
