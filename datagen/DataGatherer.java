/*

- DATA GEN TEMPLATE -

- PLACEHOLDERS:
    - <MODCLASS>
    - <PACKAGE>

    This file runs on ./gradlew runData. Run Data is needed any time a change is made to the data generators eg. a new translation, texture etc.
    Currently this file contains all the data generators we have ever used in our projects. Data Gen varies a lot based on the project feel
free to remove any that don't fit your use case <3

package <PACKAGE>;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = <MODCLASS>.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGatherer {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new ItemModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new BlockModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new RecipesProvider(output, lookupProvider));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(BlockLootTableProvider::new, LootContextParamSets.BLOCK)
        ), lookupProvider));
        BlockTagProvider blockTagProvider = new BlockTagProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeClient(), blockTagProvider);
        generator.addProvider(event.includeClient(), new ItemTagProvider(output, lookupProvider, blockTagProvider.contentsGetter()));
        generator.addProvider(event.includeServer(),new LootModifierProvider(output,lookupProvider));
        generator.addProvider(event.includeServer(), new WorldGenProvider(output, lookupProvider));
    }
}
*/