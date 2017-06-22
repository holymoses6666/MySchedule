package com.rodion.myschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener
{
    public Button left;
    public Button right;
    public Button CreateButton;
    public Button DeleteButton;

    public int DeloNumber;
    public int NumberPunkt;

    public TextView Delo;
    public EditText Punkt;

    public LinearLayout PunktLayout;

    public String [][] BtnArray = new String[100][100];
    public int [] lenght = new int[100];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        left = (Button)findViewById(R.id.left);
        right = (Button)findViewById(R.id.right);
        CreateButton =(Button) findViewById(R.id.create_button);
        DeleteButton =(Button) findViewById(R.id.delete_button);

        Delo = (TextView)findViewById(R.id.delo);
        Punkt = (EditText)findViewById(R.id.punkt);
        PunktLayout = (LinearLayout)findViewById(R.id.punkt_layout);


        left.setOnClickListener(this);
        right.setOnClickListener(this);
        CreateButton.setOnClickListener(this);
        DeleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {


        switch (v.getId())
        {
            case R.id.left:
                if(DeloNumber>0)
                DeloNumber--;
                PunktLayout.removeAllViews();
                NumberPunkt = 0;
              for(int i = 0; i< lenght[DeloNumber];i++)
              {
                createButton();
                  NumberPunkt++;
              }

                break;
            case R.id.right:
                DeloNumber++;
                PunktLayout.removeAllViews();
                NumberPunkt = 0;
                for(int i = 0; i< lenght[DeloNumber];i++)
                {
                    createButton();
                    NumberPunkt++;
                }
                break;
            case R.id.create_button:
                BtnArray[DeloNumber][NumberPunkt] = Punkt.getText().toString();
                createButton();
                NumberPunkt++;
                lenght[DeloNumber]++;
                Punkt.setText("");
                break;

            case R.id.delete_button:
                for(int i = 0; i< 100; i++)
                BtnArray[DeloNumber][i] = "";
                PunktLayout.removeAllViews();
                lenght[DeloNumber]=0;

                break;
        }

        Delo.setText("Дело" + DeloNumber);

    }

    public void createButton()
    {

        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lParams.gravity = Gravity.LEFT;
        Button NewPunkt = new Button(this);
        NewPunkt.setText(BtnArray[DeloNumber][NumberPunkt]);
        PunktLayout.addView(NewPunkt, lParams);
        NewPunkt.setOnClickListener(this);


    }




}
/*
    Toast toast = Toast.makeText(getApplicationContext(),
            "Пора покормить кота!", Toast.LENGTH_SHORT);
                toast.show();
*/