package verbs;

import java.lang.reflect.InvocationTargetException;

import core.Area;
import core.Command;
import core.Context;
import core.Player;
import core.Verb;
import core.World;

public class Debug extends Verb {

    public Debug() {
        super("debug", Verb.usage().arbitrary());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run(final Command command, final Context construct) {
        final String leftovers = command.getLeftovers().trim();
        final String input = leftovers.substring(Math.min(5, leftovers.length()));
        if (input.startsWith(" teleport ")) {
            final String areaInput = input.substring(10);
            final int endOfName = input.indexOf(' ');
            final String areaName = areaInput.substring(0, endOfName);
            final Class<? extends Area<?>> area;
            {
                Class<?> area_;
                try {
                    area_ = Class.forName(areaName);
                } catch (final ClassNotFoundException e) {
                    e.printStackTrace();
                    area_ = null;
                }
                area = area_ != null && Area.class.isAssignableFrom(area_)
                        ? (Class<? extends Area<?>>) area_ : null;
            }
            if (area == null) {
                System.out.println("Invalid area.");
                return;
            }
            final World world = construct.getWorld();
            Area<?> worldArea = world.getArea(area);
            if (worldArea == null) {
                final String areaLeftovers = areaInput.substring(endOfName + 1);
                try {
                    try {
                        worldArea = area.getConstructor(World.class, String.class)
                                .newInstance(world, areaLeftovers);
                    } catch (final NoSuchMethodException e) {
                        worldArea = area.getConstructor(World.class).newInstance(world);
                    }
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                    return;
                }
                world.addArea(area, worldArea);
            }
            System.out.println("whoosh");
            final Player player = construct.getPlayer();
            player.setCurrentArea(worldArea);
            worldArea.enter(player);
            return;
        }
        System.out.println("No debug command given.");
    }

}
