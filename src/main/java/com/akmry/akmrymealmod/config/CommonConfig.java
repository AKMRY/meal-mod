package com.akmry.akmrymealmod.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * サーバーとクライアント共通の設定を表すためのクラスです。
 */
public class CommonConfig {
    /**
     * コンフィグのビルダー
     */
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    /**
     * 土ブロックのログを取るかを表す設定
     */
    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
        .comment("Whether to log the dirt block on common setup")
        .define("logDirtBlock", true);

    /**
     * マジックナンバーを表す設定
     */
    private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER
        .comment("A magic number")
        .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

    /**
     * マジックナンバーの紹介を表す設定
     */
    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
        .comment("What you want the introduction message to be for the magic number")
        .define("magicNumberIntroduction", "The magic number is... ");

    /**
     * アイテムの一覧を表す設定
     */
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
        .comment("A list of items to log on common setup.")
        .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), CommonConfig::validateItemName);

    /**
     * コンフィグの設定
     */
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    /**
     *　土ブロックのログを取るかを表す設定値
     */
    private static boolean logDirtBlock;

    /**
     *　マジックナンバーを表す設定値
     */
    private static int magicNumber;

    /**
     *　マジックナンバーの紹介を表す設定値
     */
    private static String magicNumberIntroduction;
 
     /**
     *　アイテムの一覧を表す設定値
     */
    private static Set<Item> items;

    /**
     * 土ブロックのログを取るかを取得します.
     *
     * @return 土ブロックのログを取るかを返します。
     */
    public static boolean getLogDirtBlock() {
        return logDirtBlock;
    }

    /**
     * マジックナンバーを取得します.
     *
     * @return マジックナンバーを返します。
     */
    public static int getMagicNumber() {
        return magicNumber;
    }

    /**
     * マジックナンバーの紹介を取得します.
     *
     * @return マジックナンバーの紹介を返します。
     */
    public static String getMagicNumberIntroduction() {
        return magicNumberIntroduction;
    }

    /**
     * アイテムの一覧を取得します.
     *
     * @return アイテムの一覧を返します。
     */
    public static Set<Item> getItems() {
        return items;
    }

    /**
     * 設定をロードします.
     *
     * @param event コンフィグイベント
     */
    public static void load(final ModConfigEvent event) {
        logDirtBlock = LOG_DIRT_BLOCK.get();
        magicNumber = MAGIC_NUMBER.get();
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();
        items = ITEM_STRINGS.get().stream()
            .map(itemName -> ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(itemName)))
            .collect(Collectors.toSet());
    }

    /**
     * アイテム名を検証します.
     *
     * @param obj 設定値
     * @return アイテム名が正しい場合はtrue、それ以外の場合はfalseを返します。
     */
    private static boolean validateItemName(final Object obj) {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(ResourceLocation.tryParse(itemName));
    }
}
