package com.whitemanx.NYCSchools;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnSchool;
    Button btn2;
    ListView lv;
    TextView textView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    ArrayList<String> scores_name;
    String numStudents;
    String critical_avg="";
    String math_avg="";
    String write_avg="";
    String name="";
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<school> schools = new ArrayList<school>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //btnSchool= findViewById(R.id.btnHighSChool);
        btn2 = findViewById(R.id.btn2);
         lv = findViewById(R.id.ListView1);
        textView = findViewById(R.id.textView);

        arrayList = new ArrayList<String>();
       // ArrayList<school> schools;
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);

     //this code will find the schools on the website

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url ="https://data.cityofnewyork.us/resource/s3k6-pzi2.json";

        int lenghtOfResponse = 0;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String SchoolName = "";
                try {
                    response.length();

                    //will add a arrayhere
                    for( int i = 0; i <= response.length()-1 ; i = i + 1){
                        JSONObject Info = response.getJSONObject(i);
                        SchoolName = Info.getString("school_name");
                        name =SchoolName.toString();
                        //phone_number
                        names.add(SchoolName);
                        String phoneNumber = Info.getString("phone_number");
                        //fax_number
                        //String fax_number = Info.getString("fax_number");
                        //website
                        String website = Info.getString("website");
                        //city
                        String city = Info.getString("city");
                        //school_email
                        String greeting = name;

                        // will add stuff to constructur arraylist of the schools that
                        school sc = new school();
                        sc.setName(SchoolName);
                        sc.setPhone(Info.getString("phone_number"));
                        sc.setCity(city);
                        sc.setWebsite(website);
                        sc.setCity(Info.getString("city"));
                        //school_email
                        //most do not have it and only 10 will have it
                        //sc.setEmail(Info.getString("school_email"));
                        //added sc to a arraylist of school objects with the attributs
                        schools.add(sc);
                        //this will do greetings
                        arrayList.add(greeting);
                        adapter.notifyDataSetChanged();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Toast.makeText(MainActivity.this,  arrayList.toString(),Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this, "size = " + response.length(),Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "CLick on the an Item in the list",Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, "If nothing happens is because there is no data on that school",Toast.LENGTH_LONG).show();
            }
        },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(MainActivity.this,"Something is wrong",Toast.LENGTH_SHORT).show();
            }
        });



        MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);

//                if(lenghtOfResponse > 4){
//
//                }



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int indexArray =i;
                String s =  schools.get(i).getName();
               // String s1 = lv.getItemAtPosition(i).toString();
                //String s = s1.split("Phone")[0];
               // string
               // Toast.makeText(MainActivity.this, s  , Toast.LENGTH_LONG).show();
               // Toast.makeText(MainActivity.this, s.split("Phone")[0], Toast.LENGTH_LONG).show();
                //adapter.dismiss(); // If you want to close the adapter



                //Toast.makeText(MainActivity.this,"Clicked Button Second Button",Toast.LENGTH_SHORT).show();

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url ="https://data.cityofnewyork.us/resource/f9bf-2cp4.json";
                //Toast.makeText(MainActivity.this,"Text view is input is " + textView.getText().toString(),Toast.LENGTH_SHORT).show();
                int lenghtOfResponse = 0;

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,null, new Response.Listener<JSONArray>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(JSONArray response) {
                        String SchoolName = "";
                        //Toast.makeText(MainActivity.this,"made it this far inside the orresponse",Toast.LENGTH_LONG).show();
                        try {
                            response.length();
                            //Toast.makeText(MainActivity.this,"the lenght is  " + response.length() , Toast.LENGTH_LONG).show();
                            //Toast.makeText(MainActivity.this,response.toString() , Toast.LENGTH_LONG).show();
                            //will add a arrayhere
                            JSONObject Info = response.getJSONObject(0);
                            SchoolName = Info.getString("school_name");
                            //Toast.makeText(MainActivity.this,SchoolName , Toast.LENGTH_LONG).show();
                            int counter;
                            int flag =0;
                            for( int i2 = 0; i2 <= response.length()-1 ; i2 = i2 + 1){
                                Info = response.getJSONObject(i2);
                                SchoolName = Info.getString("school_name");

                                //HENRY STREET SCHOOL FOR INTERNATIONAL STUDIES"
                                //textView.getText().toString()
                                //was using == and was not same object but where logically equivalent
                                if(SchoolName.equals(s.toUpperCase())){
                                    //Toast.makeText(MainActivity.this, " Found a Match we think for" +schools.get(indexArray).getName()   , Toast.LENGTH_LONG).show();
                                    numStudents =  Info.getString("num_of_sat_test_takers");
                                    schools.get(indexArray).setNumStudents(numStudents);
                                    math_avg =  Info.getString("sat_math_avg_score");
                                    schools.get(indexArray).setMath(math_avg);
                                    critical_avg = Info.getString("sat_critical_reading_avg_score");
                                    schools.get(indexArray).setCritical(critical_avg);
                                    //sat_writing_avg_score
                                    write_avg = Info.getString("sat_writing_avg_score");
                                    schools.get(indexArray).setVerbal(write_avg);
                                    //Toast.makeText(MainActivity.this, "mathavg = " + math_avg,Toast.LENGTH_LONG).show();
                                    //Toast.makeText(MainActivity.this, " critical_avg = " +  critical_avg,Toast.LENGTH_LONG).show();
                                    //Toast.makeText(MainActivity.this, "sat_writing_avg_score= " + write_avg,Toast.LENGTH_LONG).show();
                                    //Toast.makeText(MainActivity.this, "number of students are = " +  numStudents,Toast.LENGTH_LONG).show();
                                    flag =1;
                                } else {
                                    //Toast.makeText(MainActivity.this, "There is no data for this school",Toast.LENGTH_SHORT).show();
                                }



                                //arrayList.add(SchoolName);
                                //adapter.notifyDataSetChanged();
                            }
                            //flag is zero then it was not found
                            //flag is 1 then it was found

                            openActivity2(schools.get(indexArray));



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Toast.makeText(MainActivity.this, "ScholName = " + SchoolName,Toast.LENGTH_LONG).show();
                        //Toast.makeText(MainActivity.this, "size = " + response.length(),Toast.LENGTH_LONG).show();
                    }
                },  new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,"Something is wrong",Toast.LENGTH_SHORT).show();
                    }
                });
//
//
//
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);



            }
        });



//
//       lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView parentView, View childView,
//                                       int position, long id)
//            {
//                //setDetail(position);
//               // System.out.println("#############################################");
//                //System.out.println(position);
//                Toast.makeText(MainActivity.this,"the position is" + position,Toast.LENGTH_LONG).show();
//            }
//
//            public void onNothingSelected(AdapterView parentView) {
//
//            }
//        });




        //this code will have an evenlistener for the list view but the app will not respond
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
//
//                Object o = lv.getItemAtPosition(position);
//                textView.setText(position);
//                System.out.println(position);
//    /* write you handling code like...
//    String st = "sdcard/";
//    File f = new File(st+o.toString());
//    // do whatever u want to do with 'f' File object
//    */
//            }
//        });



//
//       btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//
//
////
//////                if(lenghtOfResponse > 4){
//////
//////                }
////
////
////
////
////
//           }
//     });
//
//
//
//
//
//
//
//
   }

    private void openActivity2(school sc) {
        Intent intent = new Intent(this,Scores.class);
        intent.putExtra("name",sc.getName() );
        intent.putExtra("math_avg", sc.getMath());
        intent.putExtra("critical_avg", sc.getCritical());
        intent.putExtra("write_avg", sc.getVerbal());
        intent.putExtra("numStudents", sc.getNumStudents());

        //trying to pass stuff from constructor
        intent.putExtra("website", sc.getWebsite());
        intent.putExtra("phone",sc.getPhone());
        intent.putExtra("city",sc.getCity());
        intent.putExtra("num",sc.getNumStudents());
        startActivity(intent);

    }

}