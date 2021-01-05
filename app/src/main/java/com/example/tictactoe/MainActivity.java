package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int turn=0;
    int move=0;
    int w=-1;
    int status[]={-1,-1,-1,-1,-1,-1,-1,-1,-1};

   public void fun(View view)
    {

        move++;
        ImageView img=(ImageView) view;
        if(move!=10 && w==-1){
        if(turn==0 ) {
            img.setImageResource(R.drawable.p1);
            img.animate().alpha(1.0f).setDuration(2500);
            int tag_no=Integer.parseInt(img.getTag().toString());
            status[tag_no-1]=0;
            turn=1;

        }
        else
        {
            img.setImageResource(R.drawable.p2);
            img.animate().alpha(1.0f).setDuration(2500);
            int tag_no=Integer.parseInt(img.getTag().toString());
            status[tag_no-1]=1;
            turn=0;
        }}
        int winner[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for(int i=0;i<8;i++)
        {
            if(status[winner[i][0]]==status[winner[i][1]] && status[winner[i][1]]==status[winner[i][2]] && status[winner[i][0]]!=-1)
            {
                w=status[winner[i][0]];
                break;
            }
        }
        TextView text=findViewById(R.id.editText3);


         if(w==-1 && move==9)
        {

            text.setText("Match Draw");
            RelativeLayout elayout=(RelativeLayout)findViewById(R.id.elayout);
            elayout.setVisibility(view.VISIBLE);


        }
        else if(w!=-1)
        {
            if(w==0)
                text.setText("Match Won by Red");
            else if(w==1)
                text.setText("Match Won by Green");

            RelativeLayout elayout=(RelativeLayout)findViewById(R.id.elayout);
            elayout.setVisibility(view.VISIBLE);

        }

    }
    public void again(View view)
    {
        RelativeLayout elayout=(RelativeLayout)findViewById(R.id.elayout);
        elayout.setVisibility(view.INVISIBLE);
        turn=0;
        move=0;
        for(int i=0;i<9;i++)
            status[i]=-1;
        w=-1;

        GridLayout grd=(GridLayout) findViewById(R.id.grild);
        for(int i=0;i<grd.getChildCount();i++)
            ((ImageView)grd.getChildAt(i)).setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
