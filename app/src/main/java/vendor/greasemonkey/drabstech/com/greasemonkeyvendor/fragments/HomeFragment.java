package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail.RequestDetailActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail.RequestListAdapter;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail.RequestModel;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.servicing_request.RequestStatusActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.utility.recyclerview_click_handler.RecyclerTouchListener;

public class HomeFragment extends Fragment {

    ArrayList<RequestModel> allRequests;
    private RecyclerView mRecyclerView;
    private RequestListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        allRequests=new ArrayList<>();
        requestList();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvServiceRequest);

        if(allRequests.size()>0){

            mRecyclerView.setVisibility(View.VISIBLE);
            mAdapter = new RequestListAdapter(allRequests);
            mRecyclerView.setAdapter(mAdapter);
            LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
            mRecyclerView.setLayoutManager(llm);
        }

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this.getContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                RequestModel requests= allRequests.get(position);
                String status = requests.getStatus();
                if(status == "New Request"){
                    Intent i=new Intent(getContext(),RequestDetailActivity.class);
                    startActivity(i);
                }else  if(status == "WIP"){
                    Intent i=new Intent(getContext(),RequestStatusActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }

    private void requestList(){
        allRequests.add(new RequestModel("Bhushan Jetha","01 SEP", "One Time Service","GOLD","New Request"));
        allRequests.add(new RequestModel("Chetan Jetha","01 SEP", "One Time Service","GOLD","WIP"));
        allRequests.add(new RequestModel("Viraj Jetha","01 SEP", "One Time Service","GOLd","New Request"));
        allRequests.add(new RequestModel("Vishal Jetha","01 SEP", "One Time Service","GOLD","New Request"));
        allRequests.add(new RequestModel("Pavan Jetha","01 SEP", "One Time Service","GOLD","New Request"));
    }
}
