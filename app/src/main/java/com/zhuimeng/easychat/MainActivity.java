package com.zhuimeng.easychat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private Button sendText;
    private EditText inputText;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiMsg();
        initView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final MsgAdapter msgAdapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(msgAdapter);
        sendText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)){
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    //当有消息时，刷新RecyclerView显示
                    msgAdapter.notifyItemInserted(msgList.size() - 1);
                    //将RecycelerView定位到最后一行
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");//清空输入框中内容
                }
            }
        });
    }

    private void intiMsg() {
        Msg msg1 = new Msg("Hello", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hi", Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("My name is zhuimengren!", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

    private void initView() {
        sendText = (Button) findViewById(R.id.send_text);
        inputText = (EditText) findViewById(R.id.input_text);
        recyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);

    }
}
