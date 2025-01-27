/*

package <PACKAGE>;

import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class BlockLootTableProvider extends BlockLootSubProvider {

    private final Set<Block> knownBlocks = new ReferenceOpenHashSet<>();

    public BlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Collections.emptySet(), FeatureFlags.VANILLA_SET, pRegistries);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }

    @Override
    protected void add(@NotNull Block block, @NotNull LootTable.Builder table) {
        //Overwrite the core register method to add to our list of known blocks
        super.add(block, table);
        knownBlocks.add(block);
    }

    @Override
    protected void generate() {
        dropSelf(NTBlocks.AQUATIC_CATALYST.get());
    }

    protected void prismarineSand(Block prismarineSandOre) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        add(prismarineSandOre, this.createSilkTouchDispatchTable(prismarineSandOre, this.applyExplosionDecay(prismarineSandOre, LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
        )).withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1f))
                .add(LootItem.lootTableItem(Items.PRISMARINE_SHARD))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))));
    }

    protected LootTable.Builder multiblockPartDrop(
            Block block, IntegerProperty partIndex, Map<Integer, Block> index2blocks
    ) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F));
        Integer last = partIndex.getPossibleValues().stream().toList().getLast();
        for (int i = 0; i < last; i++) {
            builder.add(LootItem.lootTableItem(index2blocks.get(i))
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(partIndex, i))));
        }
        return LootTable.lootTable()
                .withPool(
                        this.applyExplosionCondition(
                                block,
                                builder
                        )
                );
    }

    protected LootTable.Builder drainPartDrop(
            Block block
    ) {
        LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F));
        return LootTable.lootTable()
                .withPool(
                        this.applyExplosionCondition(
                                block,
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block)
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrainPartBlock.TOP, false))))
                        )
                );
    }

}
*/