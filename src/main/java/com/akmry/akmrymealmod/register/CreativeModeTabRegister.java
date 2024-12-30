package com.akmry.akmrymealmod.register;

import com.akmry.akmrymealmod.reference.ModReference;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * クリエイティブタブを登録するためのクラスです。
 */
public class CreativeModeTabRegister {
    /**
     * クリエイティブタブレジスター
     */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModReference.MOD_ID);

    /**
     * 料理タブ
     */
    public static final RegistryObject<CreativeModeTab> MEAL_TAB = CREATIVE_MODE_TABS.register("meal_tab",
        () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemRegister.MEAL_ITEM.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.akmrymealmod.meal_tab"))
            .displayItems((parameters, output) -> {
                output.accept(ItemRegister.MEAL_BLOCK_ITEM.get());
                output.accept(ItemRegister.MEAL_ITEM.get());
            }).build());
}