package com.example.a1405264.socialtm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Current_Projects extends Fragment {


    private ArrayList<New_Project_Details> new_project_detailses=new ArrayList<>();
    FirebaseAuth firebaseAuth;
    private RecyclerView rclist;
    DatabaseReference mDatabase;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_current__projects, container, false);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        String t=user.getUid().toString();
        mDatabase= FirebaseDatabase.getInstance().getReference().child(t);
        mDatabase.keepSynced(true);
        rclist=(RecyclerView)view.findViewById(R.id.blog_list);
        rclist.hasFixedSize();
        rclist.setLayoutManager(new LinearLayoutManager(this.getActivity()));


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.v("Data",dataSnapshot.toString());

             /*   for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    New_Project_Details nw= ds.getValue(New_Project_Details.class);
                    new_project_detailses.add(nw);


                }
                recyclerViewAdapter= new RecyclerViewAdapter(new_project_detailses,Home.Main);
                rclist.setAdapter(recyclerViewAdapter);*/

                New_Project_Details nw= dataSnapshot.getValue(New_Project_Details.class);
                new_project_detailses.add(nw);
                recyclerViewAdapter= new RecyclerViewAdapter(new_project_detailses,Home.Main);
                rclist.setAdapter(recyclerViewAdapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return  view;
    }

  /*  @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Project_Details,Holder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Project_Details, Holder>(
                Project_Details.class,
                R.layout.new_project_row,
                Holder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(Holder viewHolder, Project_Details model, int position) {
                viewHolder.setTitle(model.getProject_name());
                viewHolder.setdesc(model.getField());


            }
        };
        rclist.setAdapter(firebaseRecyclerAdapter);
    }

    public  static class Holder extends RecyclerView.ViewHolder
    {
        View mView;
        TextView post_title;
        TextView post_desc;
        public Holder(View itemView) {
            super(itemView);
            mView=itemView;

            post_title=(TextView)mView.findViewById(R.id.name);
            post_desc=(TextView)mView.findViewById(R.id.detail);


        }

        public  void setTitle(String title)
        {
            post_title.setText(title);
        }

        public  void setdesc(String desc)
        {
            post_desc.setText(desc);
        }

    } */


}
