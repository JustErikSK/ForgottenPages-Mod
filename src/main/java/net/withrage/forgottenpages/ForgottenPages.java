package net.withrage.forgottenpages;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.withrage.forgottenpages.item.ModItems;
import net.withrage.forgottenpages.loot.ModLootModifiers;

@Mod(ForgottenPages.MOD_ID)
public class ForgottenPages {
    public static final String MOD_ID = "forgottenpages";

    public ForgottenPages() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIERS.register(modEventBus);

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
