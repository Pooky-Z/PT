package com.example.a13218.demo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a13218.demo.Adapter.FragmentAdapter;
import com.example.a13218.demo.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this com.example.a13218.demo.fragment must implement the
 * {@link fragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment1#newInstance} factory method to
 * create an instance of this com.example.a13218.demo.fragment.
 */
public class fragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the com.example.a13218.demo.fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ViewPager mviewPager;
    private TabLayout mtabLayout;
    private List<Fragment> mFragments=new ArrayList<>();
    private List<String> mTitles=new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private OnFragmentInteractionListener mListener;

    public fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this com.example.a13218.demo.fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of com.example.a13218.demo.fragment fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment1 newInstance(String param1, String param2) {
        fragment1 fragment = new fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this com.example.a13218.demo.fragment
        view=inflater.inflate(R.layout.fragment_fragment1,container,false);
        mviewPager=view.findViewById(R.id.viewPager1);
        mtabLayout=view.findViewById(R.id.tab1);
        initView(view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    private void initView(View view){
        mTitles.add("我的收藏");
        mTitles.add("浏览记录");
        mTitles.add("我的关注");
        tabfragment1 mtabfragment1=new tabfragment1();
        Bundle bundle1=new Bundle();
        bundle1.putInt("position",1);
        mtabfragment1.setArguments(bundle1);
        tabfragment2 mtabfragment2=new tabfragment2();
        Bundle bundle2=new Bundle();
        bundle2.putInt("position",2);
        mtabfragment1.setArguments(bundle2);
        tabfragment3 mtabfragment3=new tabfragment3();
        Bundle bundle3=new Bundle();
        bundle3.putInt("position",3);
        mtabfragment1.setArguments(bundle3);
        mFragments.add(new tabfragment1());
        mFragments.add(new tabfragment2());
        mFragments.add(new tabfragment3());
        mviewPager.setAdapter(new FragmentAdapter(getFragmentManager(),mFragments,mTitles));
        mtabLayout.setupWithViewPager(mviewPager);
        mviewPager.setOffscreenPageLimit(1);
    }
    /**
     * This interface must be implemented by activities that contain this
     * com.example.a13218.demo.fragment to allow an interaction in this com.example.a13218.demo.fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
