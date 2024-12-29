package com.akmry.mealmod.event;

import com.akmry.mealmod.config.CommonConfig;
import com.akmry.mealmod.reference.ModReference;

import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * サーバーとクライアント共通のMODイベントを処理するためのクラスです。
 */
@Mod.EventBusSubscriber(modid = ModReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    /**
     * コンフィグイベントを処理します.
     *
     * @param event コンフィグイベント
     */
    @SubscribeEvent
    static void onModConfig(final ModConfigEvent event) {
        CommonConfig.load(event);
    }

    /**
     * 共通セットアップイベントを処理します.
     *
     * @param event 共通セットアップイベント
     */
    @SubscribeEvent
    private void onCommonSetup(final FMLCommonSetupEvent event) {
        ModReference.LOGGER.info("HELLO FROM COMMON SETUP");

        if (CommonConfig.getLogDirtBlock())
            ModReference.LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        ModReference.LOGGER.info(CommonConfig.getMagicNumberIntroduction() + CommonConfig.getMagicNumber());

        CommonConfig.getItems().forEach(item -> ModReference.LOGGER.info("ITEM >> {}", item.toString()));
    }
}
