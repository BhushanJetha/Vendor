package vendor.greasemonkey.drabstech.com.greasemonkeyvendor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail.RequestDetailActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail.RequestListAdapter;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail.RequestModel;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.utility.recyclerview_click_handler.RecyclerTouchListener;

public class HomeActivity extends AppCompatActivity {

    ArrayList<RequestModel> allRequests;
    private RecyclerView mRecyclerView;
    private RequestListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setToolbar();


        allRequests=new ArrayList<>();
        requestList();
        mRecyclerView = (RecyclerView) findViewById(R.id.rvServiceRequest);

        if(allRequests.size()>0){

            mRecyclerView.setVisibility(View.VISIBLE);
            mAdapter = new RequestListAdapter(allRequests);
            mRecyclerView.setAdapter(mAdapter);
            LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
            mRecyclerView.setLayoutManager(llm);
        }

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent i=new Intent(HomeActivity.this,RequestDetailActivity.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public void setToolbar(){
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Grease Monkey");

       /* if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }*/
    }

    private void requestList(){


        allRequests.add(new RequestModel("Bhushan Jetha","01 SEP", "One Time Service","GOLD","New Request"));
        allRequests.add(new RequestModel("Chetan Jetha","01 SEP", "One Time Service","GOLD","New Request"));
        allRequests.add(new RequestModel("Viraj Jetha","01 SEP", "One Time Service","GOLd","New Request"));
        allRequests.add(new RequestModel("Vishal Jetha","01 SEP", "One Time Service","GOLD","New Request"));
        allRequests.add(new RequestModel("Pavan Jetha","01 SEP", "One Time Service","GOLD","New Request"));
    }


}
