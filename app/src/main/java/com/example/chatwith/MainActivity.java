package com.example.chatwith;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList=new ArrayList<>();
    private EditText editText;
    private Button button;
    private RecyclerView recyclerView;
    private  MsgAdapter adapter;
    private boolean Send=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        editText=(EditText) findViewById(R.id.input_text);
        button=(Button) findViewById(R.id.send);
        recyclerView=(RecyclerView) findViewById(R.id.msg_recycle_view);
        adapter=new MsgAdapter(msgList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=editText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg;
                    if (Send)
                    { msg=new Msg(content,Msg.TYPE_SEND);
                    } else {
                        msg=new Msg(content,Msg.TYPE_RECEIVED);
                    }
                    Send=!Send;
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    recyclerView.scrollToPosition(msgList.size()-1);
                    editText.setText("");
                }
            }
        });
    }
    private void initMsgs(){
        for (int i=0;i<100;i++){
            int randomNumber = (int)(Math.random() * 3) + 1;
            int randomNumber2 = (int)(Math.random() * 3) + 1;
            int randomNumber3 = (int)(Math.random() * 3) + 1;
            if (randomNumber==1) {
                Msg msgi = new Msg("hello,good morning", Msg.TYPE_RECEIVED);
                msgList.add(msgi);
                Msg msgai = new Msg("good morning ", Msg.TYPE_SEND);
                msgList.add(msgai);
            }
            if (randomNumber==2) {
                Msg msgi = new Msg("hello,good afternoon", Msg.TYPE_RECEIVED);
                msgList.add(msgi);
                Msg msgai = new Msg("good afternoon ", Msg.TYPE_SEND);
                msgList.add(msgai);
            }
            if (randomNumber==3) {
                Msg msgi = new Msg("hello,good evening", Msg.TYPE_RECEIVED);
                msgList.add(msgi);
                Msg msgai = new Msg("good evening ", Msg.TYPE_SEND);
                msgList.add(msgai);
            }
         if (randomNumber2==1){
             Msg msgsi=new Msg("I Love you",Msg.TYPE_RECEIVED);
             msgList.add(msgsi);
            Msg msgli=new Msg("I Love you too ",Msg.TYPE_SEND);
                msgList.add(msgli);}
            if (randomNumber2==2){
                Msg msgsi=new Msg("Did you hava lunch ?",Msg.TYPE_RECEIVED);
                msgList.add(msgsi);
                Msg msgli=new Msg("I hava lunch.How about you ? ",Msg.TYPE_SEND);
                msgList.add(msgli);}
            if (randomNumber2==3){
                Msg msgsi=new Msg("I miss you",Msg.TYPE_RECEIVED);
                msgList.add(msgsi);
                Msg msgli=new Msg("I miss you too ",Msg.TYPE_SEND);
                msgList.add(msgli);}
            if (randomNumber3==1) {
                Msg msgdi = new Msg("The bast thing in the world is chat with you", Msg.TYPE_RECEIVED);
                msgList.add(msgdi);
                Msg msgli=new Msg("I think so ",Msg.TYPE_SEND);
                msgList.add(msgli);
            }
            if (randomNumber3==1) {
                Msg msgdi = new Msg("What did you do today", Msg.TYPE_RECEIVED);
        msgList.add(msgdi);
        Msg msgli=new Msg("I studied in the morning and read firends in the afternoon ",Msg.TYPE_SEND);
        msgList.add(msgli);
    }
            if (randomNumber3==2) {
            Msg msgdi = new Msg("What about going out with me tomorrow ?", Msg.TYPE_RECEIVED);
            msgList.add(msgdi);
            Msg msgli=new Msg("I sI made an appointment with my friend to play game ",Msg.TYPE_SEND);
            msgList.add(msgli);}
            if (randomNumber3==3) {
                Msg msgdi = new Msg("Let's go on a tour", Msg.TYPE_RECEIVED);
                msgList.add(msgdi);
                Msg msgli=new Msg("I want to stay at home ",Msg.TYPE_SEND);
                msgList.add(msgli);}
}}}
