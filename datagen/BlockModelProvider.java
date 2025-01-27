/*

- BLOCK MODEL REGISTRATION TEMPLATE -

- PLACEHOLDERS:
    - <MODCLASS>
    - <PACKAGE>

package <PACKAGE>;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.apache.commons.lang3.IntegerRange;
import org.jetbrains.annotations.NotNull;

public class BlockModelProvider extends BlockStateProvider {
    public BlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, <MODCLASS>.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Registering goes here
        simpleBlock(TemplateBlocks.templateBlock.get());
    }


    public ResourceLocation fromVanillaBlockTexture(Block vanilla, String suffix) {
        ResourceLocation name = key(vanilla);
        return ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + name.getPath() + suffix);
    }

    public ResourceLocation fromVanillaModelFile(Block vanilla, String suffix) {
        ResourceLocation name = key(vanilla);
        return ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + name.getPath() + suffix);
    }

    public ResourceLocation fromVanillaBlockTexture(Block vanilla) {
        ResourceLocation name = key(vanilla);
        return ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }

    public ResourceLocation fromVanillaModelFile(Block vanilla) {
        ResourceLocation name = key(vanilla);
        return ResourceLocation.withDefaultNamespace(ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }

    public void existingFacingBlock(Block block, Block modelOf) {
        facingBlock(block, models().getExistingFile(existingModelFile(modelOf)));
    }

    public void facingBlock(Block block, ModelFile model) {
        getVariantBuilder(block)
                .partialState().with(BlockStateProperties.FACING, Direction.UP)
                .modelForState().modelFile(model).addModel()
                .partialState().with(BlockStateProperties.FACING, Direction.DOWN)
                .modelForState().modelFile(model).rotationX(180).addModel()
                .partialState().with(BlockStateProperties.FACING, Direction.NORTH)
                .modelForState().modelFile(model).rotationX(90).addModel()
                .partialState().with(BlockStateProperties.FACING, Direction.SOUTH)
                .modelForState().modelFile(model).rotationX(90).rotationY(180).addModel()
                .partialState().with(BlockStateProperties.FACING, Direction.EAST)
                .modelForState().modelFile(model).rotationX(90).rotationY(90).addModel()
                .partialState().with(BlockStateProperties.FACING, Direction.WEST)
                .modelForState().modelFile(model).rotationX(90).rotationY(270).addModel();
    }

    private ResourceLocation existingModelFile(Block block) {
        ResourceLocation name = key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }

    private ResourceLocation existingModelFile(String name) {
        return modLoc(ModelProvider.BLOCK_FOLDER + "/" + name);
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return ResourceLocation.fromNamespaceAndPath(rl.getNamespace(), rl.getPath() + suffix);
    }
}
*/