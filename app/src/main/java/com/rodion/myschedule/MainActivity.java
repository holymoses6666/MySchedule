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
    public int PunktNumber;

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


        /*childBtn = PunktLayout.getChildAt(id);

        childBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                PunktLayout.removeAllViews();
            }


        });*/


    }




    @Override
    public void onClick(View v)
    {



        switch (v.getId())
        {
            case R.id.left:
                PunktLayout.removeAllViews();
                DeloNumber--;
                PunktNumber = 0;
                LoadButton();
                break;
            case R.id.right:
                PunktLayout.removeAllViews();
               DeloNumber++;
                PunktNumber = 0;
                LoadButton();
                break;
            case R.id.create_button:
                lenght[DeloNumber]++;
                createButton();
                saveButton();
                PunktNumber++;
                break;
            case R.id.delete_button:
                PunktLayout.removeAllViews();
                lenght[DeloNumber]=0;
                break;
            case 10:
                PunktLayout.removeAllViews();
                break;
        }

        Delo.setText("Дело" + DeloNumber);
        Punkt.setText("Пункт"+ PunktNumber);
    }

    public void createButton()
    {


            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lParams.gravity = Gravity.LEFT;
            Button NewPunkt = new Button(this);
            NewPunkt.setId(10);
            NewPunkt.setText(Punkt.getText().toString());
            PunktLayout.addView(NewPunkt, lParams);
            NewPunkt.setOnClickListener(this);


     }


     public void saveButton()
     {
         BtnArray[DeloNumber][PunktNumber] = Punkt.getText().toString();

     }
    public void LoadButton()
    {
        for(int i = 0; i < lenght[DeloNumber]; i++)
        {

            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lParams.gravity = Gravity.LEFT;
            Button NewPunkt = new Button(this);
            NewPunkt.setText(BtnArray[DeloNumber][i]);
            PunktLayout.addView(NewPunkt, lParams);
            NewPunkt.setOnClickListener(this);

        }
    }



}
/*
    Toast toast = Toast.makeText(getApplicationContext(),
            "Пора покормить кота!", Toast.LENGTH_SHORT);
                toast.show();
*/