package net.withrage.forgottenpages.loot;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS =
            DeferredRegister.create(
                    ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
                    "forgottenpages"
            );

    public static final RegistryObject<Codec<ForgottenPagesLootModifier>>
            FORGOTTEN_PAGES = LOOT_MODIFIERS.register(
                    "forgotten_pages",
                    () -> ForgottenPagesLootModifier.CODEC
            );
}
