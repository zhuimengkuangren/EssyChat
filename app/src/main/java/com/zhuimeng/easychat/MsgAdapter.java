package com.zhuimeng.easychat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhuimeng on 2017/9/17.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;

    public MsgAdapter(List<Msg> mMsgList) {
        this.mMsgList = mMsgList;
    }

    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED){
            //如果是收到消息，则显示左边布局，隐藏右边布局
            holder.receivedLayout.setVisibility(View.VISIBLE);
            holder.sendLayout.setVisibility(View.GONE);
            holder.receivedMsg.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SEND){
            //如果是发送消息，则显示右边消息，隐藏左边布局
            holder.sendLayout.setVisibility(View.VISIBLE);
            holder.receivedLayout.setVisibility(View.GONE);
            holder.sendMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final LinearLayout receivedLayout;
        private final LinearLayout sendLayout;
        private final TextView receivedMsg;
        private final TextView sendMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            receivedLayout = (LinearLayout) itemView.findViewById(R.id.received_layout);
            sendLayout = (LinearLayout) itemView.findViewById(R.id.send_layout);
            receivedMsg = (TextView) itemView.findViewById(R.id.received_msg);
            sendMsg = (TextView) itemView.findViewById(R.id.send_msg);
        }
    }
}
