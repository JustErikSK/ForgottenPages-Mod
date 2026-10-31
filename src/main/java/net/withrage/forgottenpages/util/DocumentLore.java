package net.withrage.forgottenpages.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component.Serializer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.ChatFormatting;
import net.minecraft.util.RandomSource;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;

public class DocumentLore {

    private static final Map<String, List<String>> LORE = Map.ofEntries(
            // Random descriptions for a Handwritten Note
            Map.entry("handwritten_note", List.of(
                    "I heard footsteps outside. Nobody was there.",
                    "Do not answer the knocking.",
                    "Something has been watching the house."
            )),
            // Random descriptions for a Letter
            Map.entry("letter", List.of(
                    "I hope this letter reaches you before nightfall.",
                    "Please, don't come looking for me.",
                    "I should have listened to your warning."
            )),
            // Random descriptions for a Map
            Map.entry("map", List.of(
                    "The marked location does not exist.",
                    "Someone crossed out the only safe route.",
                    "There is a place the maps refuse to show."
            )),
            // Random descriptions for a Missing Report
            Map.entry("missing_report", List.of(
                    "The missing person was last seen near the forest.",
                    "No footprints were found at the scene.",
                    "The investigation was closed without explanation."
            )),
            // Random descriptions for Newspapers
            Map.entry("newspaper", List.of(
                    "Residents report strange noises after sunset.",
                    "Another unexplained disappearance shocks the village.",
                    "Authorities deny rumors of unusual activity."
            )),
            // Random descriptions for a Research Document
            Map.entry("research_document", List.of(
                    "Subject appears to react to human voices.",
                    "Observation terminated following incident 07.",
                    "No physical entity was detected."
            )),
            // Random descriptions for a Torn Page
            Map.entry("torn_page", List.of(
                    "...it knows when you are alone...",
                    "...the door opened by itself...",
                    "...we should never have entered..."
            ))
    );

    public static void applyRandomLore(
            ItemStack stack,
            RandomSource random
    ) {
        Item item = stack.getItem();

        var itemId = ForgeRegistries.ITEMS.getKey(item);

        if (itemId == null ||
                !itemId.getNamespace().equals("forgottenpages")) {
            return;
        }

        String itemName = itemId.getPath();

        List<String> descriptions = LORE.get(itemName);

        if (descriptions == null && itemName.startsWith("polaroid_")) {
            // Random descriptions for all Polaroids
            descriptions = List.of(
                    "A shadow stands behind the photographer.",
                    "The faces have been scratched away.",
                    "Something is visible between the trees.",
                    "The photograph was taken after everyone disappeared.",
                    "There is someone in the picture who shouldn't be there."
            );
        }

        if (descriptions == null || descriptions.isEmpty()) {
            return;
        }

        String selected = descriptions.get(
                random.nextInt(descriptions.size())
        );

        CompoundTag display = stack.getOrCreateTagElement("display");
        ListTag lore = new ListTag();

        Component component = Component.literal(selected)
                .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC);

        lore.add(StringTag.valueOf(
                Serializer.toJson(component)
        ));

        display.put("Lore", lore);
    }
}
