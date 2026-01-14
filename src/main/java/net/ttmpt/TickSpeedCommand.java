package net.ttmpt;

import com.hypixel.hytale.protocol.FormattedMessage;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.AbstractCommand;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.RequiredArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import com.hypixel.hytale.server.core.modules.time.TimeResource;
import com.hypixel.hytale.server.core.universe.Universe;

import java.util.concurrent.CompletableFuture;

public class TickSpeedCommand extends AbstractCommand {

    public TickSpeedCommand() {
        super("tickspeed", "Adjust the time dilation multiplier for the server");
    }

    private RequiredArg<Float> multiplier = withRequiredArg("multiplier", "Time dilation multiplier", ArgTypes.FLOAT);

    @Override
    protected CompletableFuture<Void> execute(CommandContext context) {
        float newMultiplier = context.get(multiplier);

        if (newMultiplier < 0)
            newMultiplier = 0;
        else if (newMultiplier > 1000)
            newMultiplier = 1000;

        TimeResource tr = Universe.get().getDefaultWorld().getEntityStore().getStore().getResource(TimeResource.getResourceType());
        tr.setTimeDilationModifier(newMultiplier);

        FormattedMessage msg = new FormattedMessage();
        msg.rawText = "Time dilation set to " + newMultiplier + "x";
        context.sendMessage(new Message(msg));

        return CompletableFuture.completedFuture(null);
    }
}
