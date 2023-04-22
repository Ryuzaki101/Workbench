package de.wisag.automation.micas.olt.base.connection;

public interface IConnectedDevice {
    /**
     * @author krm
     */
    public interface ReadCallback {
        /**
         * @return command which should be sent to device
         */
        public String getCommand();

        /**
         * @param text
         *            -
         */
        public void processResult(String text);

        /**
         * gets called if the response is complete
         */
        public void signalDone();
    }

    boolean isBusy();

    /**
     * send a command and process response
     *
     * @param readCallback
     */
    void sendCommandWithCallback(ReadCallback readCallback);

    /**
     * Reset the callback if a timeout occurs
     */
    void forceRemoveOwnCallback();

    /**
     * send a command and forget it
     *
     * @param command
     */
    void sendString(String command);

    void disconnect();

}
