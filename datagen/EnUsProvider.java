/*

- TRANSLATION TEMPLATE -

- PLACEHOLDERS:
    - <MODCLASS>
    - <ITEMSCLASS>
    - <BLOCKSCLASS>

package com.portingdeadmods.nautec.datagen;

import com.portingdeadmods.nautec.compat.modonomicon.ModonomiconCompat;
import com.portingdeadmods.nautec.registries.NTBlocks;
import com.portingdeadmods.nautec.registries.NTFluidTypes;
import com.portingdeadmods.nautec.utils.Utils;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static <ITEMSCLASS>.*;
import static <BLOCKSCLASS>.*;

public class EnUsProvider extends LanguageProvider {
    public EnUsProvider(PackOutput output) {
        super(output, <MODCLASS>.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("template.string", "Template Translated String");
        addFluidType(TemplateFluidTypes.TemplateFluid, "Template Fluid");
        addItem(TEMPLATE_ITEM, "Template Item");
        addBlock(TEMPLATE_BLOCK, "Template Block");
    }

    public static <T> Component registryTranslation(Registry<T> registry, T registryObject) {
        ResourceLocation objLoc = registry.getKey(registryObject);
        return Component.translatable(registry.key().location().getPath() + "." + objLoc.getNamespace() + "." + objLoc.getPath());
    }

    private void addFluidType(Supplier<? extends FluidType> fluidType, String val) {
        add(registryTranslation(NeoForgeRegistries.FLUID_TYPES, fluidType.get()).getString(), val);
    }

    private void curiosIdent(String key, String val) {
        add("curios.identifier." + key, val);
    }

    private void addItem(String key, String val) {
        add("item." + <MODCLASS>.MODID + "." + key, val);
    }

    private void addBlock(String key, String val) {
        add("block." + <MODCLASS>.MODID + "." + key, val);
    }
}
 */
