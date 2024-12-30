package com.akmry.akmrymealmod.register;

import com.akmry.akmrymealmod.reference.ModReference;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * ブロックを登録するためのクラスです。
 */
public class BlockRegister {
    /**
     * ブロックレジスター
     */
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModReference.MOD_ID);

    /**
     * 料理ブロック
     */
    public static final RegistryObject<Block> MEAL_BLOCK = BLOCKS.register("meal_block",
        () -> new Block(BlockBehaviour.Properties.of()
            .setId(BLOCKS.key("meal_block"))
            .mapColor(MapColor.STONE)
        )
    );
}