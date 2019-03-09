package com.example.yiweizhang.csci3130project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentAccountDetail extends AppCompatActivity {


    TextView nameField, gpaField, genderField, idField,tuitionField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_account_detail);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("student");

        nameField = (TextView) findViewById(R.id.name);
        gpaField = (TextView) findViewById(R.id.gpa);
        genderField = (TextView) findViewById(R.id.gender);
        idField = (TextView) findViewById(R.id.sID);
        tuitionField=(TextView) findViewById(R.id.tuition);

        myRef.child("B0011111").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Student student = dataSnapshot.getValue(Student.class);
                nameField.setText("NAME: "+student.getName());
                String doubleGPA = Double.toString(student.getGPA());
                gpaField.setText("GPA: "+doubleGPA);
                genderField.setText("GENDER: "+student.getGender());
                idField.setText("ID: "+student.getStudentId());

                String StringTuition = Integer.toString(student.getTuition());
                tuitionField.setText("Tuition: "+ StringTuition);

            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }
}
