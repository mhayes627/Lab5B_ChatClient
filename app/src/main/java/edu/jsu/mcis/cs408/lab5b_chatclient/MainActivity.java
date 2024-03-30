package edu.jsu.mcis.cs408.lab5b_chatclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.util.Log;

import java.beans.PropertyChangeEvent;
import edu.jsu.mcis.cs408.lab5b_chatclient.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AbstractView {

    public static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    private ChatController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        /* Create Controller and Models */

        controller = new ChatController();
        ChatWebServiceModel model = new ChatWebServiceModel();

        /* Register Activity View and Model with Controller */

        controller.addView(this);
        controller.addModel(model);

        /* Initialize Model to Default Values */

        model.initDefault();


        binding.postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = binding.input.getText().toString();
                controller.sendPostRequest(input);
            }
        });

        binding.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.sendDeleteRequest();
            }
        });

    }

    @Override
    public void modelPropertyChange(final PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();
        String propertyValue = evt.getNewValue().toString();

        Log.i(TAG, "New " + propertyName + " Value from Model: " + propertyValue);

        if ( propertyName.equals(ChatController.ELEMENT_OUTPUT_PROPERTY) ) {

            String oldPropertyValue = binding.output.getText().toString();

            if ( !oldPropertyValue.equals(propertyValue) ) {
                binding.output.setText(propertyValue);
            }

        }

    }

}
