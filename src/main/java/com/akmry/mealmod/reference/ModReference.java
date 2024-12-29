package com.akmry.mealmod.reference;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

/**
 * MODの参照変数を定義するためのクラスです。
 */
public class ModReference {
    /**
     * MODのID
     */
    public static final String MOD_ID = "akmrymealmod";

    /**
     * MODの名前
     */
    public static final String MOD_NAME = "AKMRY Meal Mod";

    /**
     * MODのバージョン
     */
    public static final String MOD_VERSION = "${version}";
    
    /**
     * ロガー
     */
    public static final Logger LOGGER = LogUtils.getLogger();
}
