package com.akmry.akmrymealmod.event;

import com.akmry.akmrymealmod.reference.ModReference;
import com.akmry.akmrymealmod.register.ItemRegister;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * クライアントのMODイベントを処理するためのクラスです。
 */
@Mod.EventBusSubscriber(modid = ModReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventHandler {
    /**
     * クライアント開始イベントを処理します。
     *
     * @param event クライアント開始イベント
     */
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ModReference.LOGGER.info("HELLO FROM CLIENT SETUP");
        ModReference.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
    
    /**
     * クリエイティブタブのコンテンツを構築するイベントを処理します。
     *
     * @param event クリエイティブタブのコンテンツ構築イベント
     */
    @SubscribeEvent
    public static void onBuildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(ItemRegister.MEAL_BLOCK_ITEM);
    }
}
