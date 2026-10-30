package net.withrage.forgottenpages.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import net.withrage.forgottenpages.util.DocumentLore;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ForgottenPagesLootModifier extends LootModifier {

    public static final Codec<ForgottenPagesLootModifier> CODEC =
            RecordCodecBuilder.create(instance ->
                    codecStart(instance).and(
                            Codec.FLOAT.fieldOf("chance")
                                    .forGetter(modifier -> modifier.chance)
                    ).apply(instance, ForgottenPagesLootModifier::new)
            );

    private final float chance;

    public ForgottenPagesLootModifier(
            LootItemCondition[] conditions,
            float chance
    ) {
        super(conditions);
        this.chance = chance;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(
            ObjectArrayList<ItemStack> generatedLoot,
            LootContext context
    ) {
        if (context.getRandom().nextFloat() >= chance) {
            return generatedLoot;
        }

        List<Item> documents = ForgeRegistries.ITEMS.getValues()
                .stream()
                .filter(item -> {
                    var id = ForgeRegistries.ITEMS.getKey(item);
                    return id != null
                            && id.getNamespace().equals("forgottenforest");
                })
                .toList();

        if (documents.isEmpty()) {
            return generatedLoot;
        }

        Item selected = documents.get(
                context.getRandom().nextInt(documents.size())
        );

        ItemStack stack = new ItemStack(selected);

        DocumentLore.applyRandomLore(
                stack,
                context.getRandom()
        );

        generatedLoot.add(stack);

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
