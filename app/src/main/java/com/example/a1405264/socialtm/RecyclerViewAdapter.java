package com.example.a1405264.socialtm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 1405264 on 2/18/2017.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {

    private ArrayList<New_Project_Details> ListData;
    private LayoutInflater inflater;
    private Context Main;


    public RecyclerViewAdapter(ArrayList<New_Project_Details> listData, Context c) {
        this.ListData = listData;
        this.inflater=LayoutInflater.from(c);
        Main=c;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.new_project_row,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        New_Project_Details list_item=ListData.get(position);

        holder.Title.setText("Title : "+list_item.project_name);
        holder.Description.setText("Description :"+list_item.field);
        // holder.Time.setText("Time : "+list_item.getDateTime());
        //   holder.Status.setText("Status : "+list_item.getStatus());
        // holder.Address.setText("Address : "+list_item.getAddress());
        //   holder.IssueNo.setText("IssueNo : " +list_item.getIssueNo());
        //  holder.IssueDescription.setText("Issue : "+list_item.getIssueDescprition());
        // holder.icon.setImageResource(list_item.getResid());

    }

    @Override
    public int getItemCount() {
        return ListData.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView Title;
        private TextView Description;

        public Holder(View itemView) {
            super(itemView);



            Title=(TextView) itemView.findViewById(R.id.name);
            Description=(TextView) itemView.findViewById(R.id.detail);

        }

        @Override
        public void onClick(View view) {

        /*    New_Project_Details complains;

            Log.v("Dinkus32", String.valueOf(getPosition()));
            int pos=getPosition();

            complains=ListData.get(pos);
            Intent EditAct=new Intent(Main,Display.class);

            EditAct.putExtra("Id",complains.getIssueNo());

            if(complains.getStatus().equals("Pending"))
            {
                EditAct.putExtra("Status","0");
            }
            else
            {
                EditAct.putExtra("Status","1");
            }

            if(complains.getIssueDescprition().equals("Garbage"))
            {
                EditAct.putExtra("IssueDescrip","1");
            }
            else if(complains.getIssueDescprition().equals("Potholes")){
                EditAct.putExtra("IssueDescrip","2");
            }
            else if(complains.getIssueDescprition().equals("Speed Breakers")){
                EditAct.putExtra("IssueDescrip","3");
            }
            else if(complains.getIssueDescprition().equals("Street light not working")){
                EditAct.putExtra("IssueDescrip","4");
            }
            else if(complains.getIssueDescprition().equals("Traffic")){
                EditAct.putExtra("IssueDescrip","5");
            }
            else if(complains.getIssueDescprition().equals("Water Logging")){
                EditAct.putExtra("IssueDescrip","6");
            }else if(complains.getIssueDescprition().equals("Other")){
                EditAct.putExtra("IssueDescrip","7");
            }
            else {
                EditAct.putExtra("IssueDescrip","8");
            }
            EditAct.putExtra("Address",complains.getAddress());
            EditAct.putExtra("Time",complains.getDateTime());
            EditAct.putExtra("Description",complains.getDescription());
            EditAct.putExtra("ImageURL",complains.getImage_Url());
            EditAct.putExtra("lat",complains.getLat());
            EditAct.putExtra("lng",complains.getLong());



            Main.startActivity(EditAct);



            Log.v("Dinkus 33",ListData.get(pos).getDescription() +ListData.get(pos).getLat() + ListData.get(pos).getLong() );
                    */
        }
    }


}