/*

- PLACEHOLDERS:
    - <MODCLASS>
    - <PACKAGE>

package <PACKAGE>;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class RecipesProvider extends RecipeProvider {
    public RecipesProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TemplateBlocks.TEMPLATE_BLOCK.asItem(), 1)
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', TemplateItems.TEMPLATE_ITEM)
                .unlockedBy("has_item", has(TemplateItems.TEMPLATE_ITEM))
                .save(pRecipeOutput, <MODCLASS>.rl("template_recipe"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TemplateItems.TEMPLATE_ITEM.asItem(), 9)
                .requires(TemplateBlocks.TEMPLATE_BLOCK.get())
                .unlockedBy("has_item", has(TemplateBlocks.TEMPLATE_BLOCK.get()))
                .save(pRecipeOutput, <MODCLASS>.rl("template_recipe"));
    }
}
*/