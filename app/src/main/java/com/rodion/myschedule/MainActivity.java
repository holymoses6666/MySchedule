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

    public String [][] StringArray = new String[100][100];
    public int [] lenght = new int[100];

        public Button NewPunkt[][] = new Button[100][100];






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
                if(DeloNumber > 0)
                {
                    PunktLayout.removeAllViews();
                    DeloNumber--;
                    PunktNumber = lenght[PunktNumber];
                    LoadButton();
                }
                break;
            case R.id.right:
                PunktLayout.removeAllViews();
               DeloNumber++;
                PunktNumber = lenght[PunktNumber];
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
                i(int i = 0; i< PunktNumber; i++;)
                StringArray[0][0] = "ЗАЕБИСЬ";
                break;
            case 0:
                NewPunkt[0][0].setText("ЗАЕБИСЬ");
                StringArray[0][0] = "ЗАЕБИСЬ";
                break;
            case 1:
                NewPunkt[0][1].setText("ЗАЕБИСЬ");
                StringArray[0][1] =  "ЗАЕБИСЬ";
                break;
            case 2:
                NewPunkt[0][2].setText("ЗАЕБИСЬ");
                break;
            case 3:
                NewPunkt[0][3].setText("ЗАЕБИСЬ");
                break;
            case 4:
                NewPunkt[0][4].setText("ЗАЕБИСЬ");
                break;
            case 5:
                NewPunkt[0][5].setText("ЗАЕБИСЬ");
                break;
            case 6:
                NewPunkt[0][6].setText("ЗАЕБИСЬ");
                break;
            case 7:
                NewPunkt[0][7].setText("ЗАЕБИСЬ");
                break;
            case 8:
                NewPunkt[0][8].setText("ЗАЕБИСЬ");
                break;
            case 9:
                NewPunkt[0][9].setText("ЗАЕБИСЬ");
                break;


        }

        Delo.setText("Дело" + DeloNumber);
        //Punkt.setText("Пункт"+ PunktNumber);
    }

    public void createButton()
    {

            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lParams.gravity = Gravity.LEFT;
            NewPunkt[DeloNumber][PunktNumber] = new Button(this);
            NewPunkt[DeloNumber][PunktNumber].setId(PunktNumber);
            NewPunkt[DeloNumber][PunktNumber].setText(Punkt.getText().toString());
            PunktLayout.addView(NewPunkt[DeloNumber][PunktNumber], lParams);
            NewPunkt[DeloNumber][PunktNumber].setOnClickListener(this);


     }


     public void saveButton()
     {
         StringArray[DeloNumber][PunktNumber] = Punkt.getText().toString();

     }
    public void LoadButton()
    {
        for(int i = 0; i < lenght[DeloNumber]; i++)
        {

            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lParams.gravity = Gravity.LEFT;
            NewPunkt[DeloNumber][PunktNumber] = new Button(this);
            NewPunkt[DeloNumber][PunktNumber].setText(StringArray[DeloNumber][i]);
            PunktLayout.addView(NewPunkt[DeloNumber][PunktNumber], lParams);
            NewPunkt[DeloNumber][PunktNumber].setOnClickListener(this);

        }
    }



}
/*
    Toast toast = Toast.makeText(getApplicationContext(),
            "Пора покормить кота!", Toast.LENGTH_SHORT);
                toast.show();
*/