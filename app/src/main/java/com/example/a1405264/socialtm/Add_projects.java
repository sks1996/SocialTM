package com.example.a1405264.socialtm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_projects extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    Button btn;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_projects);

        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        btn=(Button)findViewById(R.id.button2);

        firebaseAuth=FirebaseAuth.getInstance();

        databaseReference= FirebaseDatabase.getInstance().getReference();
        FirebaseUser user=firebaseAuth.getCurrentUser();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            saveprojectinfo();
             startActivity(new Intent(Add_projects.this,Home.class));
            }
        });
    }
    private  void saveprojectinfo()
    {
        String s1=ed1.getText().toString().trim();
        String s2=ed2.getText().toString().trim();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        New_Project_Details ob=new New_Project_Details(s1,s2);
        databaseReference.child(user.getUid()).setValue(ob);
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show();
    }
}
