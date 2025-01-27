/*

- RECIPE BUILDER TEMPLATE -

- PLACEHOLDERS:
    - <MODCLASS>
    - <PACKAGE>

package <PACKAGE>;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public interface TemplateRecipeBuilder extends RecipeBuilder {
    List<Ingredient> getIngredients();

    String getName();

    @Override
    default void save(RecipeOutput recipeOutput) {
        StringBuilder builder = new StringBuilder();
        for (Ingredient ingredient : getIngredients()) {
            for (Ingredient.Value value : ingredient.getValues()) {
                if (value instanceof Ingredient.ItemValue(ItemStack item)) {
                    ResourceLocation itemLocation = BuiltInRegistries.ITEM.getKey(item.getItem());
                    builder.append(itemLocation.getPath()).append("_");
                } else if (value instanceof Ingredient.TagValue(TagKey<Item> tag)) {
                    builder.append(tag.location().getPath()).append("_");
                }
            }
        }
        Item result = getResult();
        if (result != Items.AIR) {
            builder.append("to_").append(BuiltInRegistries.ITEM.getKey(result).getPath());
        } else {
            builder.deleteCharAt(builder.length() - 1);
        }
        save(recipeOutput, ResourceLocation.fromNamespaceAndPath(<MODCLASS>.MODID, getName() + "/" + builder));
    }
}
*/
