package edu.jsu.mcis.cs408.lab5b_chatclient;

import java.beans.PropertyChangeEvent;

public interface AbstractView {

    public abstract void modelPropertyChange(final PropertyChangeEvent evt);

}
