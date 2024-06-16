package it.mjicio.plugin.files;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FileManager {
    private final JavaPlugin plugin;

    private final String fileName;

    private FileConfiguration fileConfiguration;

    private File file;

    public FileManager(JavaPlugin plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
    }

    public void setup() {
        this.file = new File(this.plugin.getDataFolder(), this.fileName + ".yml");
        if (!this.file.exists())
            try {
                this.file.createNewFile();
                InputStream inputStream = this.plugin.getResource(this.fileName + ".yml");
                if (inputStream == null)
                    throw new IllegalArgumentException("File " + this.fileName + ".yml non trovato nelle cartelle del plugin");
                OutputStream outputStream = new FileOutputStream(this.file);
                byte[] buf = new byte[1024];
                int len;
                while ((len = inputStream.read(buf)) > 0)
                    outputStream.write(buf, 0, len);
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                this.plugin.getLogger().severe("C'stato un problema nella creazione del file " + this.fileName + ".yml");
            }
        this.fileConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
    }

    public FileConfiguration get() {
        return this.fileConfiguration;
    }

    public void reload() {
        this.fileConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
    }

    public void save() {
        try {
            this.fileConfiguration.save(this.file);
        } catch (IOException e) {
            this.plugin.getLogger().severe("C'stato un problema nel salvataggio del file " + this.fileName + ".yml");
        }
    }
}