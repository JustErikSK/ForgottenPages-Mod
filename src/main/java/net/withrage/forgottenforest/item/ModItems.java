package net.withrage.forgottenforest.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.withrage.forgottenforest.ForgottenForest;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ForgottenForest.MOD_ID);
    public static final RegistryObject<Item> HANDWRITTEN_NOTE = ITEMS.register("handwritten_note", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LETTER = ITEMS.register("letter", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAP = ITEMS.register("map", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MISSING_REPORT = ITEMS.register("missing_report", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NEWSPAPER = ITEMS.register("newspaper", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POLAROID_0 = ITEMS.register("polaroid_0", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POLAROID_1 = ITEMS.register("polaroid_1", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POLAROID_2 = ITEMS.register("polaroid_2", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POLAROID_3 = ITEMS.register("polaroid_3", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POLAROID_4 = ITEMS.register("polaroid_4", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RESEARCH_DOCUMENT = ITEMS.register("research_document", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TORN_PAGE = ITEMS.register("torn_page", () -> new Item(new Item.Properties()));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
