package de.wisag.automation.micas.olt.internal.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;

/**
 * Query device database an fetch
 *
 * @author mkr
 */
public class GetCommand extends DeviceCommand<List<int[]>> {
    private String listName;

    @Override
    public String getCommandline() {
        Assert.isNotNull(getListName(), "listName was null");
        return String.format("GET %s", getListName());
    }

    @Override
    public List<int[]> execute(List<String> message) {
        List<int[]> result = new ArrayList<>();
        for (String string : message) {
            result.add(ParserUtils.parseGetResultLineAsByteValues(string));
        }
        return result;
    }

    public String getListName() {
        return listName;
    }

    /**
     * Name of list to retrive
     *
     * @param listName
     *            Name of the list
     */
    public void setListName(String listName) {
        this.listName = listName;
    }

}
