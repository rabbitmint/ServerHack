package com.rabbitmint;

import org.bukkit.plugin.java.JavaPlugin;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class mainclass extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Server Side Hack 플러그인이 활성화 되었습니다.");
        getLogger().info("제작 : 민트토끼 , 아이디어 : EY");

        new NoFallDamage(this);

        getServer().getPluginManager().registerEvents(new CrouchAndSwapHandListener(), this);
        getServer().getPluginManager().registerEvents(new BodyClass(), this);
        getServer().getPluginManager().registerEvents(new SpeedHack(), this);
        getServer().getPluginManager().registerEvents(new JumpHack(), this);
        getServer().getPluginManager().registerEvents(new InfiniteHealth(), this);
    }
}
