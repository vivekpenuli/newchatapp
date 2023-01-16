package com.example.chatfinal.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatfinal.ChatUserActivity;
import com.example.chatfinal.Model.User;
import com.example.chatfinal.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder>  {
Context context;
ArrayList<User> list;


    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;


    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.card,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

     //   RequestModel model = list.get(position);

User model = list.get(position);
   /*     holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChatUserActivity.class);

                intent.putExtra("userId",model.getUserID());
                context.startActivity(intent);
            }
        });
        */
  // here



            holder.name.setText(list.get(position).getName());
        Picasso.get()
                .load(list.get(position).getProfile_photo())
                .placeholder(R.drawable.profile)
                .into(holder.pic);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }





    public  class viewHolder extends RecyclerView.ViewHolder{
        ImageView pic;
        TextView name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            pic= itemView.findViewById(R.id.senderpic);
            name=itemView.findViewById(R.id.userchatname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int pos = getAdapterPosition();
                    Intent intent = new Intent(context, ChatUserActivity.class);
                    User temp = list.get(pos);  // eshe se ye pata chalegha kon se card me click keya he
                   // intent.putExtra("phone",temp.getPhone());
                    intent.putExtra("userId",temp.getUserID());

                    //    intent.putExtra("name", temp.getName());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);


                }
            });

        }
    }

}
