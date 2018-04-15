package com.example.pj.contacts;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.pj.contacts.Utils.ListCustomAdapter;

import java.util.ArrayList;


public class ContactsFragment extends android.support.v4.app.Fragment {

    private static final String TAG = "ContactsFragment";
    private static final String EXAPLME_IMG = "https://mobileclick.pl/wp-content/uploads/2017/05/android-logo-startowe.jpg";


    //states of the appbar
    private static final int NORMAL_BAR = 0;
    private static final int SEARCH_BAR = 1;
    private int appBarState;

    private AppBarLayout contactsBar , searchBar;
    private ListCustomAdapter listCustomAdapter;
    private ListView contactListView;


    //oncreate for fragments
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started");
        //attach layout file to a view and then return it
        View view = inflater.inflate(R.layout.fragment_contacts,container,false);
        contactsBar = view.findViewById(R.id.viewContactsToolbar);
        searchBar = view.findViewById(R.id.searchContactsToolbar);
        contactListView = view.findViewById(R.id.contactList);
        setCurentBarState(NORMAL_BAR);
        setupContatsList();

        //actions on fob
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: fab clicked");
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //actions on search img btn
        ImageView searchImgBtn = view.findViewById(R.id.contactsToolbarSearchIcon);
        searchImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: search clicked");
                changeBarState();
            }
        });

        //action on back arrow in search fragment
        ImageView searchImgBackArrowBtn = view.findViewById(R.id.contactsToolbarBackArrowIcon);
        searchImgBackArrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: back arrow pressed");
                changeBarState();
            }
        });


        return view;

    }

    private void setupContatsList(){
        final ArrayList<ContactsDetail> contactsDetails = new ArrayList<>();
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));
        contactsDetails.add(new ContactsDetail("Jan Kowalski", "7979797979","gmail@gmail.com",EXAPLME_IMG));


        listCustomAdapter = new ListCustomAdapter(getActivity(),R.layout.layout_contactlist,contactsDetails,"");
        contactListView.setAdapter(listCustomAdapter);
    }

    //checking the state of the appbar
    private void changeBarState() {
        if(appBarState == NORMAL_BAR){
            setCurentBarState(SEARCH_BAR);
        }else{
            setCurentBarState(NORMAL_BAR);
        }
    }
    //hiding and showing tollbars and actions
    private void setCurentBarState(int barState) {
        appBarState = barState;

        if(appBarState == NORMAL_BAR){
            searchBar.setVisibility(View.GONE);
            contactsBar.setVisibility(View.VISIBLE);
            //keyboard open
            View view = getView();
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            try {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }catch (NullPointerException e){
                Log.d(TAG, "setCurentBarState: NullPointerException" + e.toString());
            }
        }else if(appBarState == SEARCH_BAR){
            searchBar.setVisibility(View.VISIBLE);
            contactsBar.setVisibility(View.GONE);
            //keyboard close
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);


        }
    }

    @Override
    public void onResume() {
        super.onResume();
        setCurentBarState(NORMAL_BAR);
    }
}
