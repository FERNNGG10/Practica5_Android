package com.example.practica5_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    Integer [] botones;

    int[] tablero = new int[]{0,0,0,0,0,0,0,0,0};

    int estado =0;
    int colocado=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = (TextView) findViewById(R.id.resultado);
        resultado.setVisibility(View.INVISIBLE);

        botones = new Integer[]{
                R.id.cuadro1,R.id.cuadro2,R.id.cuadro3,
                R.id.cuadro4,R.id.cuadro5,R.id.cuadro6,
                R.id.cuadro7,R.id.cuadro8,R.id.cuadro9
        };

    }

    public void colocar(View view)
    {
       if(estado==0)
       {
           int num = Arrays.asList(botones).indexOf(view.getId());
          if(tablero[num]==0)
          {
              view.setBackgroundResource(R.drawable.cruz);
              tablero[num]=1;
              colocado+=1;
              estado=comp();
              if(estado==0)
              {
                  circ();
                  colocado+=1;
                  estado= comp();
              }
          }

       }
    }

    public void circ()
    {
        Random ran = new Random();
        int pos = ran.nextInt(tablero.length);
        while (tablero[pos]!=0)
        {
                pos = ran.nextInt(tablero.length);
        }
        Button b = (Button) findViewById(botones[pos]);
        b.setBackgroundResource(R.drawable.circulo);
        tablero[pos]=-1;
    }

    public int comp()
    {
        if(colocado<9)
        {
            return 0;
        }
        else {
            return 2;
        }
    }
}