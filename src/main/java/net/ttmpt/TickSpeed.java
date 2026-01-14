package net.ttmpt;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;

public class TickSpeed extends JavaPlugin {

    private boolean timeDilationSet = false;

    public TickSpeed(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        this.getCommandRegistry().registerCommand(new TickSpeedCommand());
    }
}
