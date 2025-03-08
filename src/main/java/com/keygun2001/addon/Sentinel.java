package com.keygun2001.addon;

import com.keygun2001.addon.modules.FriendNotifier;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class Sentinel extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Sentinel");
    public static final HudGroup HUD_GROUP = new HudGroup("Sentinel");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Sentinel");

        // Modules
        Modules.get().add(new FriendNotifier());

        // Commands
//        Commands.add(new CommandExample());

        // HUD
//        Hud.get().register(HudExample.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.keygun2001.addon";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("keygun-development", "Sentinel");
    }
}
