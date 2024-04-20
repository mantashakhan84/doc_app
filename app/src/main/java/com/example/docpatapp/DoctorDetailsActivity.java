package com.example.docpatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name: Arshi Khan", "Hospital Address: VimanNagar", "Exp: 8yrs", "Mobile No: 8754639827", "600"},
                    {"Doctor Name: Mantasha Khan", "Hospital Address: FCroad", "Exp: 4yrs", "Mobile No: 8446618544", "900"},
                    {"Doctor Name: Punnam Patle", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No: 8737469820", "300"},
                    {"Doctor Name: Shruti Jayswal", "Hospital Address: Hinjewadi", "Exp: 10yrs", "Mobile No: 7655554977", "500"},
                    {"Doctor Name: Mohit Kapoor", "Hospital Address: Katraj", "Exp: 6yrs", "Mobile No: 9846643661", "800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name: Afroz Tamboli", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 4536639827", "600"},
                    {"Doctor Name: Swati Jha", "Hospital Address: Chinchwad", "Exp: 4yrs", "Mobile No: 7654618544", "900"},
                    {"Doctor Name: Khushi Thakre", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8737469457", "300"},
                    {"Doctor Name: Pratik Lade", "Hospital Address: YCM", "Exp: 10yrs", "Mobile No: 8675748784", "500"},
                    {"Doctor Name: Rahul Patil", "Hospital Address: Pimpri", "Exp: 7yrs", "Mobile No: 9846643544", "800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name: Amruta Dhongde", "Hospital Address: VimanNagar", "Exp: 2yrs", "Mobile No: 7667577579", "200"},
                    {"Doctor Name: Akshay Lade", "Hospital Address: FCroad", "Exp: 7yrs", "Mobile No: 6765645898", "300"},
                    {"Doctor Name: Abhinav Parte", "Hospital Address: Nigdi", "Exp: 8yrs", "Mobile No: 9876447788", "300"},
                    {"Doctor Name: Noshita Pardhi", "Hospital Address: Hinjewadi", "Exp: 10yrs", "Mobile No: 7655587875", "500"},
                    {"Doctor Name: Mannu Kha", "Hospital Address: Katraj", "Exp: 3yrs", "Mobile No: 9846865809", "600"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name: Sakshi More", "Hospital Address: VimanNagar", "Exp: 8yrs", "Mobile No: 8754636564", "100"},
                    {"Doctor Name: Pratiksha Iyear", "Hospital Address: FCroad", "Exp: 4yrs", "Mobile No: 8446615655", "800"},
                    {"Doctor Name: Sunny Chaddha", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No: 7766746982", "500"},
                    {"Doctor Name: Rupa Dsouza", "Hospital Address: Hinjewadi", "Exp: 10yrs", "Mobile No: 7785554977", "500"},
                    {"Doctor Name: Ghausiya Khan", "Hospital Address: Katraj", "Exp: 6yrs", "Mobile No: 7785743661", "900"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name: Shoaib Khan", "Hospital Address: VimanNagar", "Exp: 6yrs", "Mobile No: 6788639827", "600"},
                    {"Doctor Name: Pankaj Yadav", "Hospital Address: FCroad", "Exp: 8yrs", "Mobile No: 876518544", "900"},
                    {"Doctor Name: Ranbir Rai", "Hospital Address: Nigdi", "Exp: 7yrs", "Mobile No: 87767469820", "300"},
                    {"Doctor Name: Pinki Mirza", "Hospital Address: Hinjewadi", "Exp: 11yrs", "Mobile No: 7655558765", "500"},
                    {"Doctor Name: Seema Rastogi", "Hospital Address: Katraj", "Exp: 18yrs", "Mobile No: 9846648765", "800"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDName);
        btn= findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")== 0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")== 0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")== 0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")== 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4] +"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}

