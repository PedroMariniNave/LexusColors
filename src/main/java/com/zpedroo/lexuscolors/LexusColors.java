package com.zpedroo.lexuscolors;

import com.zpedroo.lexuscolors.commands.ColorCmd;
import com.zpedroo.lexuscolors.listeners.PlayerChatListener;
import com.zpedroo.lexuscolors.managers.DataManager;
import com.zpedroo.lexuscolors.objects.Color;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public class LexusColors extends JavaPlugin {

    private static LexusColors instance;
    public static LexusColors get() { return instance; }

    public void onEnable() {
        instance = this;

        loadConfig();
        loadColors();

        registerCommands();
        registerListeners();

        new DataManager();
    }

    private void registerCommands() {
        getCommand("color").setExecutor(new ColorCmd());
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }

    private void loadConfig() {
        File file = new File(getDataFolder() + "/config.yml");

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();

                InputStream is = getResource("configuration-file/config.yml");
                copy(is, file);
            } catch (IOException ex) {
                System.out.println("Could not create config.yml!");
            }
        }

        BufferedReader in;

        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            YamlConfiguration.loadConfiguration(in);

            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadColors() {
        for (String str : getConfig().getStringList("Colors")) {
            Color color = new Color(str);
            Colors.getColors().add(color);
        }
    }

    private void copy(InputStream is, File file) throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len=is.read(buf))>0){
                out.write(buf,0,len);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            out.close();
            is.close();
        }
    }
}