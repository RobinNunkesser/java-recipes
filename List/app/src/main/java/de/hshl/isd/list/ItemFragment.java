package de.hshl.isd.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends Fragment {

    private ListAdapter<String, MyItemRecyclerViewAdapter.ViewHolder> mAdapter;
    private ItemViewModel mViewModel;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view =
                inflater.inflate(R.layout.fragment_item_list, container, false);

        mAdapter = new MyItemRecyclerViewAdapter(mListener);

        mViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        mViewModel.getData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                mAdapter.submitList(strings);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setAdapter(
                    mAdapter);

        ((SearchView) view.findViewById(R.id.searchView))
                .setOnQueryTextListener(
                        new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String s) {
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(final String s) {
                                if (s.isEmpty()) {
                                    mAdapter.submitList(
                                            mViewModel.getData().getValue());
                                    return false;
                                }
                                List filteredList =
                                        mViewModel.getData().getValue().stream()
                                                .filter(new Predicate<String>() {
                                                    @Override
                                                    public boolean test(
                                                            String value) {
                                                        return value
                                                                .toLowerCase()
                                                                .contains(
                                                                        s.toLowerCase());
                                                    }
                                                }).collect(
                                                Collectors.toList());
                                mAdapter.submitList(filteredList);
                                return false;
                            }
                        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(String item);
    }
}
