package com.ahmet.learnedmovementrobot;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 3/8/2024
 */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.List;

public class CustomListView extends ListView {

    public interface OnItemSelectedListener {
        void onItemSelected(String selectedItem);
    }

    private String[] data;
    private OnItemSelectedListener listener;

    public CustomListView(Context context) {
        super(context);
        initialize(context);
    }

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public CustomListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        if (isInEditMode()) {
            return;
        }

        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                handleItemClick(position);
            }
        });
    }

    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public void setData(String[] data) {
        this.data = data;
        refreshListView();
    }
    public void setData(List<String> data) {
        if (data == null || data.isEmpty()) {
            Toast.makeText(getContext(), "Veri yok", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] dataArray = data.toArray(new String[0]);
        setData(dataArray);
    }

    private void refreshListView() {
        if (data == null || data.length == 0) {
            Toast.makeText(getContext(), "Veri yok", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, data);
        setAdapter(adapter);
    }

    private void handleItemClick(int position) {
        String selectedName = data[position];
        if (listener != null) {
            listener.onItemSelected(selectedName);
        }
    }
}