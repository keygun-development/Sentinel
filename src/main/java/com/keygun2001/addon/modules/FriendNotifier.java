package com.keygun2001.addon.modules;

import com.keygun2001.addon.Sentinel;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.friends.Friends;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.network.PlayerListEntry;

import java.util.*;

public class FriendNotifier extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Boolean> catGreeter = sgGeneral.add(new BoolSetting.Builder()
        .name("cat-greeter")
        .description("Sends a cat-like greeting in chat when a friend comes online.")
        .defaultValue(false)
        .build()
    );

    private final Set<String> previousOnlineFriends = new HashSet<>();
    private static final List<String> CAT_SOUNDS = Arrays.asList("Meow", "Nya", "Mrrrp");
    private static final Random RANDOM = new Random();
    private boolean firstJoin = true;

    public FriendNotifier() {
        super(Sentinel.CATEGORY, "friend-notifier", "Notifies you when friends join the server.");
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.getNetworkHandler() == null || mc.player == null) return;

        Set<String> currentOnlineFriends = new HashSet<>();
        for (PlayerListEntry player : mc.getNetworkHandler().getPlayerList()) {
            if (Friends.get().isFriend(player)) {
                String name = player.getProfile().getName();
                currentOnlineFriends.add(name);

                if (firstJoin) continue;

                if (!previousOnlineFriends.contains(name)) {
                    info(name + " has come online!");

                    if (catGreeter.get()) {
                        String catSound = CAT_SOUNDS.get(RANDOM.nextInt(CAT_SOUNDS.size()));
                        mc.player.networkHandler.sendChatMessage(name + "! " + catSound + "!");
                        break;
                    }
                }
            }
        }

        if (firstJoin) {
            if (!currentOnlineFriends.isEmpty()) {
                info("Online friends: " + String.join(", ", currentOnlineFriends));
            }
            firstJoin = false;
        }

        previousOnlineFriends.retainAll(currentOnlineFriends);
        previousOnlineFriends.addAll(currentOnlineFriends);
    }

    @Override
    public void onDeactivate() {
        previousOnlineFriends.clear();
        firstJoin = true;
    }
}
