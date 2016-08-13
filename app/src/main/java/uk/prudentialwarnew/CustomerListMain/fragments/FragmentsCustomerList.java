package uk.prudentialwarnew.CustomerListMain.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

import uk.prudentialwarnew.CustomerListMain.ParserCustomerListMain.ParserCustomerList;
import uk.prudentialwarnew.CustomerListMain.ProgressHUD;
import uk.prudentialwarnew.CustomerListMain.RecyclerItemClickListener;
import uk.prudentialwarnew.CustomerListMain.adapter.AdapterCustomerList;
import uk.prudentialwarnew.CustomerListMain.adapter.models.CustomerListModel;
import uk.prudentialwarnew.CustomerListMain.adapter.models.DataModel_CustomerList;
import uk.prudentialwarnew.R;
import uk.prudentialwarnew.profileview.ProfileView;


/**
 * Created by user on 8/11/2016.
 */
public class FragmentsCustomerList  extends Fragment implements SearchView.OnQueryTextListener {

    public static boolean condition=false;
    ProgressHUD mProgressHUD2;
    public static String currentSelectedID;
    PullToRefreshView mPullToRefreshView;
    //    Button btn_dilog_cancel;
    String currentStatus = "";
    int scrollPosition = 0;
    //    Dialog dialogOptions;
    MenuItem item;
    ProgressHUD mProgressHUD;
    DataModel_CustomerList mSchema;
    LinearLayoutManager mLayoutManager;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    boolean isLoading = true;
    public int currentPage=1;
    boolean loadNow = true;
    boolean isStatusChanged = false;
    public static int clickPosition=0;

    Dialog dialogOptions;
    Button btn_dilog_cancel;
    TextView tvTextDialog;
    TextView tvTitleDialog;
    TextView addressDialog;
    String customer_id;

    public static FragmentsCustomerList newInstance() {
        return new FragmentsCustomerList();
    }


    private RecyclerView mRecyclerView;
    private AdapterCustomerList mAdapter;
    private List<CustomerListModel> mModels;
    private View view_post_new_truck_click;
    List<CustomerListModel> filteredModelList;
    boolean conditionForSearch = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_customerlist, container, false);

        mModels = new ArrayList<>();
        filteredModelList = new ArrayList<>();
        new fetchCustomerDetailsAsyncTask2("").execute();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mPullToRefreshView = (PullToRefreshView) view.findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        scrollPosition = 0;
                        loading = true;
                        isLoading = true;
                        currentPage=1;
                        loadNow = true;
                        mModels =  new ArrayList<>();
                        filteredModelList = new ArrayList<>();
                        mPullToRefreshView.setRefreshing(false);
                        new fetchCustomerDetailsAsyncTask2("").execute();
                    }
                }, 5000);
            }

        });
//        setData();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.searchmenu, menu);

        item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextChange(String query) {
        filteredModelList = filter(mModels, query);
        mAdapter.animateTo(filteredModelList);
        mRecyclerView.scrollToPosition(0);
        conditionForSearch = true;
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<CustomerListModel> filter(List<CustomerListModel> models, String query) {
        query = query.toLowerCase();

        final List<CustomerListModel> filteredModelList = new ArrayList<>();
        for (CustomerListModel model : models) {
            final String text = model.getNameFirst().toLowerCase();
            final String textID = model.getNameLast().toLowerCase();
            final String textSource = model.getProductsname().toLowerCase();
            final String textDestination = model.getProductstype().toLowerCase();
            final String textWeight = model.getPhone().toLowerCase();
            if (text.contains(query) || textID.contains(query) || textSource.contains(query) || textDestination.contains(query) || textWeight.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    public void setData(){
        try {

            if(ParserCustomerList.schema.getList().size()<1) {

            }
            //#######################################################
            //  mModels = new ArrayList<>();

//                for (String movie : MOVIES) {
//                    mModels.add(new CustomerListModel(movie));
//                }
            for (int i = 0; i < ParserCustomerList.schema.getList().size(); i++) {
                mModels.add(new CustomerListModel(
                        ParserCustomerList.schema.getList().get(i).getLongitude()+"",
                        ParserCustomerList.schema.getList().get(i).getLatitude()+"",
                        ParserCustomerList.schema.getList().get(i).getRegistered()+"",
                        ParserCustomerList.schema.getList().get(i).getAbout()+"",
                        ParserCustomerList.schema.getList().get(i).getAddress()+"",
                        ParserCustomerList.schema.getList().get(i).getPhone()+"",
                        ParserCustomerList.schema.getList().get(i).getEmail()+"",
                        ParserCustomerList.schema.getList().get(i).getCompany()+"",
                        ParserCustomerList.schema.getList().get(i).getName().getFirst()+"",
                        ParserCustomerList.schema.getList().get(i).getName().getLast()+"",
                        ParserCustomerList.schema.getList().get(i).getDob()+"",
                        ParserCustomerList.schema.getList().get(i).getGender()+"",
                        ParserCustomerList.schema.getList().get(i).getPaymentFrequency()+"",
                        ParserCustomerList.schema.getList().get(i).getProducts().get(0).getJoiningDate()+"",
                        ParserCustomerList.schema.getList().get(i).getProducts().get(0).getAccountBalance()+"",
                        ParserCustomerList.schema.getList().get(i).getProducts().get(0).getMaturityDate()+"",
                        ParserCustomerList.schema.getList().get(i).getProducts().get(0).getType()+"",
                        ParserCustomerList.schema.getList().get(i).getProducts().get(0).getName()+"",
                        ParserCustomerList.schema.getList().get(i).getProducts().get(0).getId()+"",
                        ParserCustomerList.schema.getList().get(i).getY()+"",
                        ParserCustomerList.schema.getList().get(i).getM()+"",
                        ParserCustomerList.schema.getList().get(i).getD()+"",
                        ParserCustomerList.schema.getList().get(i).getBool()+"",
                        ParserCustomerList.schema.getList().get(i).getAge()+"",
                        ParserCustomerList.schema.getList().get(i).getPicture()+"",
                        ParserCustomerList.schema.getList().get(i).getBalance()+"",
                        ParserCustomerList.schema.getList().get(i).getStatus()+"",
                        ParserCustomerList.schema.getList().get(i).getGuid()+"",
                        ParserCustomerList.schema.getList().get(i).getIndex()+"",
                        ParserCustomerList.schema.getList().get(i).getId()+""

                ));
            }
            filteredModelList = filter(mModels, "");
            conditionForSearch = true;
            mAdapter = new AdapterCustomerList(getActivity(), mModels);

            mRecyclerView.setAdapter(mAdapter);
            if(!isStatusChanged) {
                mRecyclerView.scrollToPosition(scrollPosition - 1);
            }
            else {
                mRecyclerView.scrollToPosition(scrollPosition);
                isStatusChanged = false;
            }

            mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    if (conditionForSearch)
                        Toast.makeText(getActivity(), "Clicked " + position + " " + filteredModelList.get(position).getId(), Toast.LENGTH_SHORT).show();
                    currentSelectedID = filteredModelList.get(position).getId();
                    scrollPosition = position;
                    clickPosition = position;
                    for (int i = 0; i < mModels.size(); i++) {
                        if (currentSelectedID.equalsIgnoreCase(mModels.get(i).getId())) {
                            customer_id = mModels.get(i).getId();
                            Intent intent = new Intent(getActivity(), ProfileView.class);
                            startActivity(intent);
                            mProgressHUD2 = ProgressHUD.show(getActivity(),
                                    "Loading details....", true, true, null);
                        }
                    }
                    //new getTruckJobDetailsAsyncTask("").execute();

                }
            }));

//            new fetchCustomerDetailsAsyncTask2("").execute();
//            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//                @Override
//                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                    super.onScrollStateChanged(recyclerView, newState);
//                }
//
//                @Override
//                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                    // super.onScrolled(recyclerView, dx, dy);
//                    if(dy > 0) //check for scroll down
//                    {
//                        visibleItemCount = mLayoutManager.getChildCount();
//                        totalItemCount = mLayoutManager.getItemCount();
//                        pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();
//
//                        System.out.println("CASE SCROLLING :::::1:::"+visibleItemCount+" "+totalItemCount +" "+pastVisiblesItems);
//
//                        boolean conditionLoader = currentPage <= ParserCustomerList.schema.getList().size();
//                        if(conditionLoader)
//                            loading = true;
//                        else
//                            loading=false;
//                        if (loading)
//                        {
//                            System.out.println("CASE SCROLLING :::::2:::"+visibleItemCount+" "+totalItemCount +" "+pastVisiblesItems);
//                            if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
//                            {
//                                System.out.println("CASE SCROLLING :::::3:::"+visibleItemCount+" "+totalItemCount +" "+pastVisiblesItems);
//                                //loading =false;
//                                Log.v("...", "Last Item Wow !");
//                                //Do pagination.. i.e. fetch new data
//                                scrollPosition = visibleItemCount + pastVisiblesItems;
//                                if(loadNow) {
//                                    loadNow = false;
//                                    currentPage = currentPage + 1;
////                                    if(currentPage <= Parser_SearchTruckList.schema.getTotalPage())
////                                        new fetchCustomerDetailsAsyncTask2().execute();
//
//                                }
//
//                            }
//                        }
//                    }
//                }
//            });
            //#######################################################
            //#######################################################
        } catch (Exception e) {
            e.printStackTrace();
            try {
//                CustomDialog dialog = new CustomDialog(getActivity(), "MESSAGE", "Some Thing went wrong. Please try again." + "", "ALERT");
//                dialog.setCancelable(true);
//                dialog.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    class fetchCustomerDetailsAsyncTask2 extends AsyncTask<String, Void, String> {

        private Exception exception;
        String mID;

        public fetchCustomerDetailsAsyncTask2(String id) {
            mID = id;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressHUD2 = ProgressHUD.show(getActivity(),
                    "Fetching Customer Details List....", true, true, null);
        }

        protected String doInBackground(String... urls) {
            try {
                ParserCustomerList deleteTruckDetails = new ParserCustomerList(getActivity());
                return "";
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
        }

        protected void onPostExecute(String feed) {

            mProgressHUD2.dismiss();
            try {

                mSchema = ParserCustomerList.schema;
                setData();
//                final List<DataModel_CustomerList> filteredModelList = new ArrayList<>();
//                //mStrings = mSchema.getList().size();
//                for(int i=0;i<mSchema.getList().size();i++) {
//                    mStrings[i] = mSchema.getList().get(i).getName().getFirst();
//                }
//
//                mSearchView = (android.widget.SearchView) findViewById(R.id.search_view);
//
//                int id = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
//                TextView textView = (TextView) mSearchView.findViewById(id);
//                textView.setTextColor(Color.BLACK);
//
//                //mSearchView.setLayoutParams(new ActionBar.LayoutParams(Gravity.RIGHT));
//                mListView = (ListView) findViewById(R.id.list_view);
////                mListView.setAdapter(mAdapter = new ArrayAdapter<String>(CustomerListActivityMain.this,
////                        android.R.layout.simple_list_item_1,
////                        mStrings));
//
//                mListView.setAdapter(new CustomAdapter(CustomerListActivityMain.this,mSchema));
//                setupSearchView();
//                mListView.setTextFilterEnabled(true);
//                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
////                        Intent intent = new Intent(CustomerListActivityMain.this,FilterActivity.class);
////                        startActivity(intent);
//
//                    }
//                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    

}

