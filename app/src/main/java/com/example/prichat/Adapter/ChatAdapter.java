package com.example.prichat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prichat.Models.MessageModel;
import com.example.prichat.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class
ChatAdapter extends RecyclerView.Adapter{

    ArrayList<MessageModel> messageModels;
    Context context;

    int Sender_ViewType = 1 , Receiver_ViewType = 2;

    public ChatAdapter(ArrayList<MessageModel> messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==Sender_ViewType){
            View view = LayoutInflater.from(context).inflate(R.layout.sample_sender,parent,false);
            return new SenderViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_receiver,parent,false);
            return new ReceiverViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModel messageModel = messageModels.get(position);

//        if(holder.getClass() == SenderViewHolder.class){
//            ((SenderViewHolder)holder).senderMsg.setText(messageModel.getMessage());
//        }else{
//            ((ReceiverViewHolder)holder).receiverMsg.setText(messageModel.getMessage());
//        }

        if (holder instanceof SenderViewHolder) {
            ((SenderViewHolder) holder).senderMsg.setText(messageModel.getMessage());
            ((SenderViewHolder) holder).senderTime.setText(messageModel.getTimestamp().toString());
        } else if (holder instanceof ReceiverViewHolder) {
            ((ReceiverViewHolder) holder).receiverMsg.setText(messageModel.getMessage());
            ((ReceiverViewHolder) holder).receiverTime.setText(messageModel.getTimestamp().toString());
        }
    }

    @Override
    public int getItemViewType(int position) {

        if(messageModels.get(position).getUid().equals(FirebaseAuth.getInstance().getUid())){
            return Sender_ViewType;
        }else {
            return Receiver_ViewType;
        }
    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public class ReceiverViewHolder extends RecyclerView.ViewHolder{

        TextView receiverMsg , receiverTime ;

        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);

            receiverMsg = itemView.findViewById(R.id.receivertext);
            receiverTime = itemView.findViewById(R.id.receivertime);

        }
    }

    public class SenderViewHolder extends RecyclerView.ViewHolder{

        TextView senderMsg , senderTime ;

        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);

            senderMsg = itemView.findViewById(R.id.sendertext);
            senderTime = itemView.findViewById(R.id.sendertime);

        }
    }

}
