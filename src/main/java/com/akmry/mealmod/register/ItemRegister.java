package com.akmry.mealmod.register;

import com.akmry.mealmod.reference.ModReference;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * アイテムを登録するためのクラスです。
 */
public class ItemRegister {
    /**
     * アイテムレジスター
     */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModReference.MOD_ID);

    /**
     * 料理ブロックアイテム
     */
    public static final RegistryObject<Item> MEAL_BLOCK_ITEM = ITEMS.register("meal_block",
        () -> new BlockItem(BlockRegister.MEAL_BLOCK.get(), new Item.Properties().setId(ITEMS.key("meal_block")))
    );

    /**
     * 料理アイテム
     */
    public static final RegistryObject<Item> MEAL_ITEM = ITEMS.register("meal_item",
        () -> new Item(new Item.Properties()
            .setId(ITEMS.key("meal_item"))
            .food(new FoodProperties.Builder()
                .alwaysEdible()
                .nutrition(1)
                .saturationModifier(2f)
                .build()
            )
        )
    );
}