package com.rabbitmint;

import org.bukkit.plugin.java.JavaPlugin;

public final class mainclass extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("합법핵 플러그인이 활성화 되었습니다.");
        getLogger().info("제작 : 민트토끼 , 아이디어 : EY");
    }
}
