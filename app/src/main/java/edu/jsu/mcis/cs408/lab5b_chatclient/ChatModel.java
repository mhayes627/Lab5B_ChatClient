package edu.jsu.mcis.cs408.lab5b_chatclient;

import android.util.Log;

public class ChatModel extends AbstractModel {

    public static final String TAG = "ChatModel";

    private String outputText;

    public void initDefault() {

        setOutputText("Click the button to send an HTTP GET request ...");

    }

    public String getOutputText() {
        return outputText;
    }

    public void setOutputText(String newText) {

        String oldText = this.outputText;
        this.outputText = newText;

        Log.i(TAG, "Output Text Change: From " + oldText + " to " + newText);

        firePropertyChange(ChatController.ELEMENT_OUTPUT_PROPERTY, oldText, newText);

    }

}
