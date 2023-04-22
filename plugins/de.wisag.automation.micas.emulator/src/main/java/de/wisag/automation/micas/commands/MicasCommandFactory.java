package de.wisag.automation.micas.commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.commands.olt.PLDCommand;
import de.wisag.automation.micas.commands.olt.PLFCommand;
import de.wisag.automation.micas.commands.olt.PLGCommand;
import de.wisag.automation.micas.commands.olt.PLHCommand;
import de.wisag.automation.micas.commands.olt.PLPCommand;

public class MicasCommandFactory {
    private final static Map<CommandVerb, Class<? extends ICommand>> verbs = new HashMap<CommandVerb, Class<? extends ICommand>>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            put(CommandVerb.CHD, CHDCommand.class);
            put(CommandVerb.CD, CDCommand.class);
            put(CommandVerb.K, KCommand.class);
            put(CommandVerb.R, RCommand.class);
            put(CommandVerb.Q, QCommand.class);
            put(CommandVerb.PLD, PLDCommand.class);
            put(CommandVerb.PLF, PLFCommand.class);
            put(CommandVerb.PLG, PLGCommand.class);
            put(CommandVerb.PLH, PLHCommand.class);
            put(CommandVerb.PLP, PLPCommand.class);
            put(CommandVerb.Y, YCommand.class);
            put(CommandVerb.EXIT, EXITCommand.class);
        }
    };

    public static ICommand create(CommandVerb verb, ClientContext context) {
        Class<? extends ICommand> cmdClass = verbs.get(verb);
        if (cmdClass == null) {
            return null;
        }
        Constructor<? extends ICommand> cons;
        try {
            cons = cmdClass.getConstructor(ClientContext.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }
        try {
            return cons.newInstance(context);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
