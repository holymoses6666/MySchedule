package com.rodion.myschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import  android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import  android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener
{
    public Button left;
    public Button right;
    public Button CreateButton;

    public int DeloNumber;
    public TextView Delo;
    public EditText Punkt;

    public LinearLayout PunktLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = (Button)findViewById(R.id.left);
        right = (Button)findViewById(R.id.right);
        CreateButton =(Button) findViewById(R.id.create_button);

        Delo = (TextView)findViewById(R.id.delo);
        Punkt = (EditText)findViewById(R.id.punkt);
        PunktLayout = (LinearLayout)findViewById(R.id.punkt_layout);


        left.setOnClickListener(this);
        right.setOnClickListener(this);
        CreateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {


        switch (v.getId())
        {
            case R.id.left:
                if(DeloNumber>0)
                DeloNumber--;
                Delo.setText("Дело" + DeloNumber);
                break;
            case R.id.right:
                DeloNumber++;
                Delo.setText("Дело" + DeloNumber);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Пора покормить кота!", Toast.LENGTH_SHORT);
                toast.show();
                break;

            case R.id.create_button:



                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lParams.gravity = Gravity.LEFT;
            Button NewPunkt = new Button(this);
            NewPunkt.setText(Punkt.getText().toString());
            PunktLayout.addView(NewPunkt, lParams);
            NewPunkt.setOnClickListener(this);
                break;

        }



    }






}
